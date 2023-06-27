/**
 * Нужно создать несколько классов животных:
 * 1. Пес (Собака)
 * 2. Кот (Кошка)
 * 3. ... придумать еще парочку
 *
 * Каждое животное имеет: (поля)
 * 1. Имя (кличка)
 * 2. Возраст
 * 3. ... придумать еще какие-то параметры
 *
 * Каждое животное может: (методы)
 * 1. Подавать голос
 * 2. Питаться (съедает какое-то количество еды, переданное в метод)
 * 3. Двигаться
 * 4. ... все, что сумеете придумать
 *
 * Нужно выделить базовый тип с общими атрибутами, инкапсулировать то, что
 * является внутренним, внурь класса.
 * Создать массив с животными и в цикле заставить их поесть (какое-то количество
 * еды) и заставить подать голос.
 *
 * * Придумать свою структуру с наследованием по аналогии с животными и
 * банковскими счетами.
 */

import java.util.Arrays;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        Animal dog1 = new Dog("Рекс", 8);
        Animal dog2 = new Dog("Бетховен", 5);
        Animal cat = new Cat("Барсик", 3);
        Animal cow = new Cow("Аврора", 2);
        Animal peruh = new Peruh("Жозеф", 1);
        List<Animal> animals = Arrays.asList(dog1, dog2, cat, cow, peruh);

        Eat eat = new Eat();

        System.out.println("У нас есть следующие животные: ");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println();

        System.out.println("Наши животные подают голос таким образом:");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " - " + animal.getVoice());
        }
        System.out.println();

        System.out.println("Сейчас количество оствавшейся еды:");
        System.out.println(eat);
        System.out.println();

        System.out.println("Кормим всех животных! Тепрь остатки еды следующие: ");
        for (Animal animal : animals) {
            animal.feed(eat);
        }
        System.out.println(eat);
        System.out.println();

        System.out.println("Заставим наших животных побегать!");
        for (Animal animal : animals) {
            animal.run();
        }
        System.out.println();

        System.out.println("Пусть Барсик (кот) и Жозеф (петух) побегают ещё раз!");
        cat.run();
        peruh.run();
        System.out.println();

        System.out.println("Отправим Барсика (кот), Рекса (собаку) спать!");
        cat.sleep();
        dog1.sleep();
    }
}
