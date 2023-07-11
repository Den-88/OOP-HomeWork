import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LessonModel {
    private List<Lesson> lessons = new ArrayList<>();

    public void create(Date date, UUID groupId) {
        lessons.add(new Lesson(date, groupId));
    }

    public List<Lesson> getAll() {
        return List.copyOf(lessons);
    }
}
