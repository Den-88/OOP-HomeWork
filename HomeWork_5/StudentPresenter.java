import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentPresenter {
    private final StudentModel model;

    public StudentPresenter(StudentModel model) {
        this.model = model;
    }

    public void create(String number, UUID groupId) {
        model.create(number, groupId);
    }

    public List<Student> getAllbyGroup(UUID groupId) {
        List<Student> list = new ArrayList<>();
        for (Student student : model.getAll()) {
            if (student.getGroupId() == groupId) {
                list.add(student);
            }
        }
        return list;
    }

    public UUID getGroupIdByName(String name) {
        if (model.getByName(name) == null) {
            return null;
        }
        return model.getByName(name).getGroupId();
    }
}
