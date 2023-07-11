import java.util.UUID;

public class Group {
    private final UUID id;
    private final String number;

    public Group(String number) {
        this.id = UUID.randomUUID();
        this.number = number;
    }

    public UUID getUuid() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return "[" + id + "] - " + number;
    }
}
