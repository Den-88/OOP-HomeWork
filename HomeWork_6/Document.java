import java.util.UUID;

public class Document {

    private UUID id;
    private String number;
    private String name;
    private String text;
    // ...

    public Document(UUID id, String number, String name, String text) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.text = text;
    }
}