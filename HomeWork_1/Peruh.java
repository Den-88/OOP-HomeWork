import java.util.Random;

public class Peruh extends Animal {
    private int minAppetite = 300;
    private int maxAppetite = 450;

    public Peruh(String name, int age) {
        super(name, age, "Кукарекууу", "петух");
    }

    @Override
    public int getNowAppetite() {
        Random random = new Random();
        return random.nextInt(minAppetite, maxAppetite);
    }

    @Override
    public void run() {
        super.distance += 2;
        System.out.println(String.format(
                "%s бегал в два раза быстрее остальных животных и кукарекал! Дистанция пробега (за всё время) - %d км!",
                super.name, super.distance));
    }
}
