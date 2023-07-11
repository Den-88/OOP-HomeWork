import java.util.List;
import java.util.UUID;

public class GroupPresenter {
    private final GroupModel model;

    public GroupPresenter(GroupModel model) {
        this.model = model;
    }

    public void create(String number) {
        model.create(number);
    }

    public List<Group> getAll() {
        return model.getAll();
    }

    public Group getByNumber(String number) {
        return model.getByNumber(number);
    }

    public UUID getId(String number) {
        return model.getByNumber(number).getUuid();
    }
}
