import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Lesson {
    private final UUID id;
    private final Date date;
    private UUID groupId;

    public Lesson(Date date, UUID groupId) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.groupId = groupId;
    }

    public UUID getGroupId() {
        return this.groupId;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = dateFormat.format(date);
        return "[" + id + "] - " + formattedDate;
    }
}
