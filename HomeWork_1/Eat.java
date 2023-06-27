public class Eat {
    private int dogAndCatEat;
    private int cowEat;
    private int peruhEat;

    public Eat() {
        dogAndCatEat = 10_000;
        cowEat = 20_000;
        peruhEat = 3_000;
    }

    public Eat(int dogAndCatEat, int cowEat, int peruhEat) {
        this.dogAndCatEat = dogAndCatEat;
        this.cowEat = cowEat;
        this.peruhEat = peruhEat;
    }

    public void eatMinus(int eat, String type) {
        switch (type) {
            case "собака":
                this.dogAndCatEat = eatWithCheck(this.dogAndCatEat, eat);
                break;
            case "корова":
                this.cowEat = eatWithCheck(this.cowEat, eat);
                break;
            case "петух":
                this.peruhEat = eatWithCheck(this.peruhEat, eat);
                break;
            default:
                break;
        }
    }

    private int eatWithCheck(int available, int nowAppetite) {
        if (available - nowAppetite >= 0) {
            return available -= nowAppetite;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Еда для собак и кошек: %d, еда для коровы: %d, еда для петуха: %d",
                this.dogAndCatEat, this.cowEat, this.peruhEat);
    }
}
