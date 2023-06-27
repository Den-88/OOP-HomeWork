import java.util.Random;

public class Cat extends Animal {
    private int minAppetite = 100;
    private int maxAppetite = 400;

    public Cat(String name, int age) {
        super(name, age, "Мяу", "кошка");
    }

    @Override
    public int getNowAppetite() {
        Random random = new Random();
        return random.nextInt(minAppetite, maxAppetite);
    }
}