package by.chuiko;

import by.chuiko.model.Animal;
import by.chuiko.model.Flower;
import by.chuiko.model.House;
import by.chuiko.model.Person;
import by.chuiko.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) throws IOException {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        //task7();
        //task8();
        //task9();
        //task10();
        //task11();
        //task12();
        //task13();
        //task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .forEach(System.out::println);
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> "Japanese".equals(animal.getOrigin()) && "Female".equals(animal.getGender()))
                .peek(animal -> animal.setBread(animal.getBread().toUpperCase(Locale.ROOT)))
                .forEach(System.out::println);

    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().charAt(0) == 'A')
                .map(Animal::getOrigin)
                .distinct()
                .forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .filter(animal -> "Female".equals(animal.getGender()))
                .count());

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> "Hungarian".equals(animal.getOrigin())));
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .allMatch(animal -> "Male".equals(animal.getGender()) && "Female".equals(animal.getGender())));
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .noneMatch(animal -> "Oceania".equals(animal.getOrigin())));
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .sorted(comparing(Animal::getGender))
                .limit(100)
                .map(Animal::getAge)
                .max(Integer::compare).get());
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .map(animal -> animal.getBread().toCharArray().length)
                .max(Integer::compare).get());

    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .mapToInt(Animal::getAge).sum());
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        System.out.println("Ответ: " + animals.stream()
                .filter(animal -> "Indonesian".equals(animal.getOrigin()))
                .mapToInt(Animal::getAge).average().getAsDouble());
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
        people.stream()
                .filter(person -> "Male".equals(person.getGender()))
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.of(2023, 2, 14)) >= 18)
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.of(2023, 2, 14)) <= 27)
                .sorted(comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    private static void task13() throws IOException {
//        List<House> houses = Util.getHouses();
//        Stream<Stream<Person>> people1 = houses.stream()
//                .filter(house -> "Hospital".equals(house.getBuildingType()))
//                .map(house -> house.getPersonList().stream());
//        Stream<Stream<Person>> people2 = houses.stream()
//                .filter(house -> "Civil building".equals(house.getBuildingType()))
//                .map(house -> house.getPersonList().stream());
//        people2.map(personStream -> personStream
//                        .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.of(2023, 2, 14)) <= 18))
//                .forEach(person -> person.forEach(System.out::println));
//        Stream<Person> peopleNew = people1;
//        Stream.concat(people1,people2).forEach(personStream1 -> personStream1.forEach(System.out::println));


    }

    private static void task14() throws IOException {
//        List<Car> cars = Util.getCars();
//        Stream<Car> turk = cars.stream()
//                .filter(car -> "Jaguar".equals(car.getCarMake()) || car.getColor().equals("White"));
//        turk.forEach(System.out::println);
//        Stream<Car> usb = cars.stream()
//                .filter(car -> !"Jaguar".equals(car.getCarMake()) && car.getColor().equals("White"))
//                .filter(car -> car.getMass() <= 1500 || car.getCarMake().equals("BMW"))

    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        System.out.println("Ответ: " + flowers.stream()
                .sorted(comparing(Flower::getOrigin).reversed().thenComparing(Flower::getPrice).reversed()
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().charAt(0) >= 'C' && flower.getCommonName().charAt(0) <= 'S')
                .filter(flower -> flower.isShadePreferred() && (flower.getFlowerVaseMaterial().stream()
                        .anyMatch(o -> "Glass".equals(o) || "Aluminum".equals(o) || "Steel".equals(o))))
                .mapToDouble(flower -> flower.getPrice() + ((flower.getWaterConsumptionPerDay() * 365 * 5)/1000 * 1.39)).sum());

    }
}