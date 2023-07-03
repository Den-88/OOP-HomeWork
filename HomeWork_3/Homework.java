/**
 * Создать класс Контейнер - Container.
 * В контейнере могут быть ящики (класс Box).
 *
 * У каждого ящика есть вес.
 * У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков,
 * которые находятся в контейнере.
 *
 * 1. Класс Контейнер должен быть Comparable. Сравнивать он должен по весам
 * контейнера (чем меньше вес, тем меньше контейнер).
 * 2. Класс ContainerCountComparator - Comparator, который сравнивает контейнеры
 * по количеству ящиков (чем меньше ящиков, тем меньше контейнер).
 * 3. Класс контейнер должен быть Iterable - итерирование должно происходить по
 * ящикам внутри контейнера.
 * <code>
 *     Container c = new Container(...);
 *     // ...
 *     for (Box box: c) {
 *         box - это контейнер
 *     }
 * </code>
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Homework {
    public static void main(String[] args) {

        Container a = new Container("Первый"); // вес контейнера - 75, количество ящиков - 2
        a.addBox(new Box(45));
        a.addBox(new Box(30));

        Container b = new Container("Второй"); // вес контейнера - 60, количество ящиков - 4
        b.addBox(new Box(40));
        b.addBox(new Box(5));
        b.addBox(new Box(5));
        b.addBox(new Box(10));

        Container c = new Container("Третий"); // вес контейнера - 100, количество ящиков - 3
        c.addBox(new Box(50));
        c.addBox(new Box(15));
        c.addBox(new Box(35));

        System.out.println("Имеется три контейнера!");

        System.out.println("Выведем все контейнеры по возрастанию веса:");
        Set<Container> containerSetOne = new TreeSet<>();
        containerSetOne.addAll(Arrays.asList(a, b, c));
        for (Container container : containerSetOne) {
            System.out.println(container.getName() + " контейнер, вес - " +
                    container.getWeight() + ", количество ящиков - " + String.valueOf(container.getBoxes()));
        }

        System.out.println("\nВыведем все контейнеры по возрастанию количества ящиков:");
        Set<Container> containerSetTwo = new TreeSet<>(new ContainerBoxesComparator());
        containerSetTwo.addAll(Arrays.asList(a, b, c));
        for (Container container : containerSetTwo) {
            System.out.println(container.getName() + " контейнер, вес - " +
                    container.getWeight() + ", количество ящиков - " + String.valueOf(container.getBoxes()));
        }

        System.out.println("\nВыведем веса всех ящиков во втором контейнере:");
        for (Box box : b) {
            System.out.print(box + "  ");
        }
        System.out.println("");
    }

    static class Container implements Comparable<Container>, Iterable<Box> {
        private ArrayList<Box> boxArray = new ArrayList<>();
        private String name;

        Container(String name) {
            this.name = name;
        };

        public String getName() {
            return this.name;
        }

        public void addBox(Box box) {
            this.boxArray.add(box);
        }

        public int getWeight() {
            int weight = 0;
            for (Box box : boxArray) {
                weight += box.getWeight();
            }
            return weight;
        }

        public int getBoxes() {
            return boxArray.size();
        }

        @Override
        public int compareTo(Container another) {
            return getWeight() - another.getWeight();
        };

        @Override
        public Iterator<Box> iterator() {
            return boxArray.iterator();
        }
    }

    static class ContainerBoxesComparator implements Comparator<Container> {
        @Override
        public int compare(Container one, Container two) {
            return one.getBoxes() - two.getBoxes();
        }
    }

    static class Box {
        private int boxWeight;

        public Box(int boxWeight) {
            this.boxWeight = boxWeight;
        };

        public int getWeight() {
            return this.boxWeight;
        }

        @Override
        public String toString() {
            return "[" + boxWeight + "]";
        }
    }
}
