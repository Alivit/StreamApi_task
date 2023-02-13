package by.chuiko;

import by.chuiko.model.Animal;
import by.chuiko.model.Car;
import by.chuiko.model.Flower;
import by.chuiko.model.House;
import by.chuiko.model.Person;
import by.chuiko.util.Util;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) throws IOException {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .forEach(s -> System.out.println(s));
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese") && animal.getGender().equals("Female"))
                .map(m -> "порода: " + m.getBread().toUpperCase(Locale.ROOT) + " страна: "
                        + m.getOrigin() + " пол: " + m.getGender())
                .forEach(s -> System.out.println(s));

    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().charAt(0) == 'A')
                .map(m -> m.getOrigin())
                .distinct()
                .forEach(s -> System.out.println(s));
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count());

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian")));
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") && animal.getGender().equals("Female")));
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania")));
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
//        Продолжить...
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        //        Продолжить...
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}