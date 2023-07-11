import java.util.UUID;

public class Student {
    private final UUID id;
    private UUID groupId;
    private final String name;

    public Student(String name, UUID groupId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.groupId = groupId;
    }

    public String getName() {
        return this.name;
    }

    public UUID getGroupId() {
        return this.groupId;
    }

    @Override
    public String toString() {
        return "[" + id + "] - " + name;
    }
}
