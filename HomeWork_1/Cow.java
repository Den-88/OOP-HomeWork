import java.util.Random;

public class Cow extends Animal {
    private int minAppetite = 5000;
    private int maxAppetite = 10000;

    public Cow(String name, int age) {
        super(name, age, "Мууу", "корова");
    }

    @Override
    public int getNowAppetite() {
        Random random = new Random();
        return random.nextInt(minAppetite, maxAppetite);
    }

    @Override
    public void run() {
        System.out.println(String.format("%s не может бегать! Корова слишком медленное животное!",
                super.name));
    }
}
