import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupModel {
    private List<Group> groups = new ArrayList<>();

    public void create(String number) {
        groups.add(new Group(number));
    }

    public List<Group> getAll() {
        return List.copyOf(groups);
    }

    public Group getByNumber(String number) {
        return groups.stream()
                .filter(it -> Objects.equals(it.getNumber(), number))
                .findFirst()
                .orElse(null);
    }
}
