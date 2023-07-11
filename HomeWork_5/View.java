import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class View {
    private final Scanner scanner;
    private GroupPresenter groupPresenter;
    private StudentPresenter studentPresenter;
    private LessonPresenter lessonPresenter;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void setGroupPresenter(GroupPresenter groupPresenter) {
        this.groupPresenter = groupPresenter;
    }

    public void setStudentPresenter(StudentPresenter studentPresenter) {
        this.studentPresenter = studentPresenter;
    }

    public void setLessonPresenter(LessonPresenter lessonPresenter) {
        this.lessonPresenter = lessonPresenter;
    }

    public void start() {
        while (true) {
            System.out.println("""
                        Введите номер команды:
                        1 - создание группы
                        2 - просмотр всех групп
                        3 - создание студента в группе
                        4 - просмотр всех студентов одной группы
                        5 - создание урока для групп
                        6 - просмотр всех уроков у студента
                        7 - завершение программы
                    """);
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Введите номер создаваемой группы: ");
                    String number = scanner.nextLine();
                    groupPresenter.create(number);
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Список всех групп:");
                    for (Group group : groupPresenter.getAll()) {
                        System.out.println(group);
                    }
                    System.out.println();
                    break;
                case "3":
                    System.out.print("Введите номер группы, в которую будем добавлять студента: ");
                    number = scanner.nextLine();
                    if (groupPresenter.getByNumber(number) != null) {
                        System.out.print("Введите имя студента: ");
                        String name = scanner.nextLine();
                        studentPresenter.create(name, groupPresenter.getId(number));
                    } else {
                        System.err.println("Группа с таким номером не существует! Повторите попытку!");
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.print("Введите номер группы, студентов которой нужно отобразить: ");
                    number = scanner.nextLine();
                    if (groupPresenter.getByNumber(number) != null) {
                        for (Student student : studentPresenter.getAllbyGroup(groupPresenter.getId(number))) {
                            System.out.println(student);
                        }
                    } else {
                        System.err.println("Группа с таким номером не существует! Повторите попытку!");
                    }
                    System.out.println();
                    break;
                case "5":
                    System.out.print("Введите номер группы, в которую будем добавлять урок: ");
                    number = scanner.nextLine();
                    if (groupPresenter.getByNumber(number) != null) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                        System.out.print("Введите дату урока (в формате dd.MM.yyyy): ");
                        String input = scanner.nextLine();
                        try {
                            Date date = dateFormat.parse(input);
                            lessonPresenter.create(date, groupPresenter.getId(number));
                        } catch (ParseException e) {
                            System.out.println("Неверный формат даты! Повторите попытку!\n");
                            break;
                        }
                    } else {
                        System.err.println("Группа с таким номером не существует! Повторите попытку!");
                    }
                    System.out.println();
                    break;
                case "6":
                    System.out.print("Введите имя студента, даты уроков которого нужно отобразить: ");
                    String name = scanner.nextLine();
                    UUID groupId = studentPresenter.getGroupIdByName(name);
                    if (groupId == null) {
                        System.out.println("Такого студента не существует!");
                        break;
                    }
                    if (lessonPresenter.getAllbyGroupId(groupId) != null) {
                        for (Lesson lesson : lessonPresenter.getAllbyGroupId(groupId)) {
                            System.out.println(lesson);
                        }
                    } else {
                        System.err.println("У данного студента нет запланированных уроков!");
                    }
                    System.out.println();
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.err.println("Введена неверная команда! Повторите ввод!\n");
                    break;
            }
        }
    }
}
