import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LessonPresenter {
    private final LessonModel model;

    public LessonPresenter(LessonModel model) {
        this.model = model;
    }

    public void create(Date date, UUID groupId) {
        model.create(date, groupId);
    }

    public List<Lesson> getAllbyGroupId(UUID groupId) {
        List<Lesson> list = new ArrayList<>();
        for (Lesson lesson : model.getAll()) {
            if (lesson.getGroupId() == groupId) {
                list.add(lesson);
            }
        }
        return list;
    }
}
