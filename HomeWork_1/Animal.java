import java.util.Random;

public class Animal {
    protected String name;
    private int age;
    private String talkSound;
    protected int distance;
    private String animalType;
    private boolean sleep;

    private int minStandartAppetite = 100;
    private int maxStandartAppetite = 400;

    public Animal(String name, int age, String talkSound, String animalType) {
        this.name = name;
        this.age = age;
        this.talkSound = talkSound;
        this.animalType = animalType;
        this.distance = 0;
        this.sleep = false;
    }

    public String getName() {
        return this.name;
    }

    protected String getType() {
        return this.animalType;
    }

    public String getVoice() {
        return this.talkSound;
    }

    protected int getNowAppetite() {
        Random random = new Random();
        return random.nextInt(minStandartAppetite, maxStandartAppetite);
    }

    public void feed(Eat eat) {
        eat.eatMinus(getNowAppetite(), getType());
    }

    public void run() {
        this.distance += 1;
        System.out.println(String.format("%s побегал! Дистанция пробега (за всё время) - %d км!",
                this.name, this.distance));
    }

    public void sleep() {
        if (!this.sleep) {
            this.sleep = true;
            System.out.println(this.name + " лег спать");
        } else {
            System.out.println(this.name + " уже спит");
        }
    }

    public void wake() {
        if (this.sleep) {
            this.sleep = false;
            System.out.println(this.name + " проснулся");
        } else {
            System.out.println(this.name + " не спал");
        }
    }

    @Override
    public String toString() {
        return String.format("Животное: %s, имя: %s, возраст: %d лет",
                this.animalType, this.name, this.age);
    }
}