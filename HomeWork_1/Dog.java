import java.util.Random;

public class Dog extends Animal {
    private int minAppetite = 200;
    private int maxAppetite = 700;

    public Dog(String name, int age) {
        super(name, age, "Гав-гав", "собака");
    }

    @Override
    public int getNowAppetite() {
        Random random = new Random();
        return random.nextInt(minAppetite, maxAppetite);
    }
}
