
/**
     * Задание
     *
     * Предположим, вы разрабатываете какую-то компьютерную игру, в которой есть несколько типов объектов (классов):
     * 1. Здание (имеет текущий уровень здоровья)
     * 2. Герой (имеет текущий уровень здоровья и текущий уровень магической энергии)
     * 3. Нейтральный персонаж (имеет текущий уровень здоровья)
     *
     * Также у вас есть класс Render с методом showIndicator, который срабатывает при наведении мышки на объект
     * и работает следующим образом:
     * 1. Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
     * 2. Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
     * * В качестве упрощения, пусть вывод на дисплей это запись информации в консоль.
     * * То есть вы пишете код, который выводит на консоль информацию.
     *
     *
     * Подсказка: нужно ввести 2 интерфейса: наличие здоровья и наличие магической энергии.
     * В классе Render проверять только на эти интерфейсы и выводить нужную информацию.
     * Необходимо продумать, какие методы должны быть в интерфейсе.
     *
     * ЧТО ДЕЛАТЬ НЕ НУЖНО:
     * Нельзя завязываться на конкретные классы. Предполагается, что таких классов очень много и они постоянно добавляются.
     *
     * * Необязательные задания, которые не относятся к теме, но при сильном желании можно реализовать.
     * * Со звездочкой: реализовать в консоли отображение индикатора.
     * Например, при максимальном уровне здоровья 100 и текущем 40 можно отобразить вот такую ленточку: [xxxx      ]
     * ** С двумя звездочками: раскрасить вывод. Чем меньше здоровья, тем "краснее" цвет индикатора. Для полного здоровья - цвет зеленый.
     */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Homework {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Render render = new Render();

        Building building = new Building(100);
        building.setCurrentHealthPoint(50);
        Hero hero = new Hero(200, 150);
        hero.setCurrentHealthPoint(50);
        hero.setCurrentManaPoint(50);
        Neutral neutral = new Neutral(300);
        neutral.setCurrentHealthPoint(300);

        System.out.println("Здание:");
        render.showIndicator(building); // В консоли должно быть примерно так: Текущий уровень здоровья: 50,
                                        // максимальный уровень здоровья: 100
        System.out.println("Герой:");
        render.showIndicator(hero);
        System.out.println("Нейтральный персонаж:");
        render.showIndicator(neutral);
    }

    static class Render {

        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим
         * уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с
         * текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            // Не должно быть упоминания конкретных классов!!!
            if (object instanceof InnerHealth) {
                InnerHealth innerHealth = (InnerHealth) object;
                List<Integer> healthList = innerHealth.getHealth();
                System.out.println(String.format("Текущий уровень здоровья: %d, максимальный уровень здоровья: %d",
                        healthList.get(0), healthList.get(1)));
                printIndicator(healthList);
            }
            if (object instanceof InnerMana) {
                InnerMana innerMana = (InnerMana) object;
                List<Integer> manaList = innerMana.getMana();
                System.out.println(String.format("Текущий уровень маны: %d, максимальный уровень маны: %d",
                        manaList.get(0), manaList.get(1)));
                printIndicator(manaList);
            }
        }

        public void printIndicator(List<Integer> list) {
            int fill = list.get(0) * 10 / list.get(1);
            String color;
            if (fill >= 7) {
                color = ANSI_GREEN;
            } else if (fill > 2){
                color = ANSI_YELLOW;
            } else {
                color = ANSI_RED;
            }
            System.out.print(color + "[");
            for (int i = 0; i < 10; i++) {
                if (fill > 0) {
                    System.out.print("x");
                    fill--;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("]" + ANSI_RESET);
        }
    }

    static class Building implements InnerHealth {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Building(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        public List<Integer> getHealth() {
            List<Integer> healthPoints = new ArrayList<>();
            healthPoints.add(this.currentHealthPoint);
            healthPoints.add(this.maxHealthPoint);
            return healthPoints;
        }
    }

    static class Hero implements InnerHealth, InnerMana {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        private int maxManaPoint; // максимально количество магический энергии
        private int currentManaPoint; // текущее количество магический энергии

        public Hero(int maxHealthPoint, int maxManaPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.maxManaPoint = maxManaPoint;

            this.currentHealthPoint = maxHealthPoint;
            this.currentManaPoint = maxManaPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        public void setCurrentManaPoint(int currentManaPoint) {
            this.currentManaPoint = currentManaPoint;
        }

        public List<Integer> getHealth() {
            List<Integer> healthPoints = new ArrayList<>();
            healthPoints.add(this.currentHealthPoint);
            healthPoints.add(this.maxHealthPoint);
            return healthPoints;
        }

        public List<Integer> getMana() {
            List<Integer> manaPoint = new ArrayList<>();
            manaPoint.add(this.currentManaPoint);
            manaPoint.add(this.maxManaPoint);
            return manaPoint;
        }
    }

    static class Neutral implements InnerHealth {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Neutral(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        public List<Integer> getHealth() {
            List<Integer> healthPoints = new ArrayList<>();
            healthPoints.add(this.currentHealthPoint);
            healthPoints.add(this.maxHealthPoint);
            return healthPoints;
        }
    }

    public interface InnerHealth {
        setCurrentHealthPoint(int currentHealthPoint);
        List<Integer> getHealth();
    }

    public interface InnerMana {
        setCurrentManaPoint(int currentManaPoint);
        List<Integer> getMana();
    }
}
