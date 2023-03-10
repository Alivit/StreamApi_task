package by.chuiko;

import by.chuiko.model.*;
import by.chuiko.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
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
        List<House> houses = Util.getHouses();

        Stream<Stream<Person>> people1 = houses.stream()
                .filter(house -> "Hospital".equals(house.getBuildingType()))
                .map(house -> house.getPersonList().stream());

        Stream<Stream<Person>> people2 = houses.stream()
                .filter(house -> "Civil building".equals(house.getBuildingType()))
                .map(house -> house.getPersonList().stream()
                        .filter(person -> (ChronoUnit.YEARS.between((person.getDateOfBirth()), LocalDate.of(2023, 2, 14)) >= 63
                                && "Male".equals(person.getGender()))
                                || (ChronoUnit.YEARS.between((person.getDateOfBirth()), LocalDate.of(2023, 2, 14)) >= 58
                                && "Female".equals(person.getGender()))
                                || ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.of(2023, 2, 14)) <= 18));

        Stream<Stream<Person>> people3 = houses.stream()
                .filter(house -> "Civil building".equals(house.getBuildingType()))
                .map(house -> house.getPersonList().stream()
                        .filter(person -> (ChronoUnit.YEARS.between((person.getDateOfBirth()), LocalDate.of(2023, 2, 14)) >= 18
                        && ChronoUnit.YEARS.between((person.getDateOfBirth()), LocalDate.of(2023, 2, 14)) <= 58)));

        Stream<Stream<Person>> people4 = houses.stream()
                .filter(house -> "Civil building".equals(house.getBuildingType()))
                .map(house -> house.getPersonList().stream()
                        .filter(person -> (ChronoUnit.YEARS.between((person.getDateOfBirth()), LocalDate.of(2023, 2, 14)) >= 58
                                && !"Female".equals(person.getGender())
                                || ChronoUnit.YEARS.between((person.getDateOfBirth()), LocalDate.of(2023, 2, 14)) >= 63
                                && (!"Male".equals(person.getGender()) && !"Female".equals(person.getGender())))));

        Stream.concat(Stream.concat(Stream.concat(people1,people2),people3),people4)
                .limit(500)
                .forEach(personStream -> personStream.forEach(System.out::println));


    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        List<Car> turkmenistan = cars.stream()
                .filter(car -> "Jaguar".equals(car.getCarMake()) || car.getColor().equals("White")).toList();
        double turkmenistanCost = turkmenistan.stream().mapToDouble(car -> car.getMass()/1000 * 7.14).sum();
        System.out.println("Туркменистан сумм. стоимость: " + turkmenistanCost);
        cars.removeAll(turkmenistan);

        List<Car> uzbekistan = cars.stream()
                .filter(car -> car.getMass() <= 1500 || car.getCarMake().equals("BMW") || car.getCarMake().equals("Lexus")
                        || car.getCarMake().equals("Chrysler") || car.getCarMake().equals("Toyota")).toList();
        double uzbekistanCost = uzbekistan.stream().mapToDouble(car -> car.getMass()/1000 * 7.14).sum();
        System.out.println("Узбекистан сумм. стоимость: " + uzbekistanCost);
        cars.removeAll(uzbekistan);

        List<Car> kazakhstan = cars.stream()
                .filter(car -> (car.getMass() >= 4000 && car.getColor().equals("Black"))
                        || car.getCarMake().equals("GMC") || car.getCarMake().equals("Dodge") ).toList();
        double kazakhstanCost = kazakhstan.stream().mapToDouble(car -> car.getMass()/1000 * 7.14).sum();
        System.out.println("Казахстан сумм. стоимость: " + kazakhstanCost);
        cars.removeAll(kazakhstan);

        List<Car> kyrgyzstan = cars.stream()
                .filter(car -> car.getReleaseYear() < 1982
                        || car.getCarModel().equals("Civic") || car.getCarModel().equals("Cherokee") ).toList();
        double kyrgyzstanSum = kyrgyzstan.stream().mapToDouble(car -> car.getMass()/1000 * 7.14).sum();
        System.out.println("Кыргызстан сумм. стоимость: " + kyrgyzstanSum);
        cars.removeAll(kyrgyzstan);

        List<Car> russia = cars.stream()
                .filter(car -> (!car.getColor().equals("Yellow") && !car.getColor().equals("Red")
                        && !car.getCarMake().equals("Green") && !car.getCarMake().equals("Blue"))
                        || car.getPrice() > 40000).toList();
        double russiaSum = russia.stream().mapToDouble(car -> car.getMass()/1000 * 7.14).sum();
        System.out.println("Россия сумм. стоимость: " + russiaSum);
        cars.removeAll(russia);

        List<Car> mongolia = cars.stream()
                .filter(car -> car.getVin().contains("59")).toList();
        double mongoliaSum = mongolia.stream().mapToDouble(car -> car.getMass()/1000 * 7.14).sum();
        System.out.println("Монголия сумм. стоимость: " + mongoliaSum);

        System.out.format("Общую выручку логистической кампании: %f", turkmenistanCost + uzbekistanCost + kazakhstanCost
        + russiaSum + kyrgyzstanSum + mongoliaSum);

    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        System.out.println("Ответ: " + flowers.stream()
                .sorted(comparing(Flower::getOrigin).reversed().thenComparing(Flower::getPrice).reversed()
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().matches("^[C-S].*"))
                .filter(flower -> flower.isShadePreferred() && (flower.getFlowerVaseMaterial().stream()
                        .anyMatch(o -> "Glass".equals(o) || "Aluminum".equals(o) || "Steel".equals(o))))
                .mapToDouble(flower -> flower.getPrice() + ((flower.getWaterConsumptionPerDay() * 365 * 5)/1000 * 1.39)).sum());

    }
    private static void task16() throws IOException {
        List<Student> students = Util.getStudents();

        List<Student> foreigners = students.stream() //сумма оплаты иностранных студентов за общежитие 1
                .filter(student -> "Salzburg".equals(student.getCity()) || "Oklahoma".equals(student.getCity())
                        || "Sofia".equals(student.getCity()) || "Kingston".equals(student.getCity())
                        || "Porto".equals(student.getCity()) || "Jerusalem".equals(student.getCity())).toList();
        double sumDormitory1 = foreigners.stream().limit(400).mapToDouble(student -> 44.4).sum();
        students.removeAll(foreigners);

        Supplier<Stream<Student>> studentsBel = () -> students.stream() //студенты которые живут в Беларуси
                .filter(student -> !"Minsk".equals(student.getCity()) && student.getAverageRating() >= 6)
                .sorted(comparing(Student::isPrivileges).thenComparing(Student::getAverageRating).reversed());

        double sumDormitory2 = studentsBel.get() //сумма оплаты белорусских студентов за общежитие 2
                .filter(student -> ChronoUnit.YEARS.between(student.getDateOfBirth(), LocalDate.of(2023, 2, 14)) <= 18)
                .limit(100).mapToDouble(student -> 44.4).sum();

        Stream<Student> studentsOutcast = studentsBel.get() //студенты до 18 лет которые не попали в 2 общежите
                .filter(student -> ChronoUnit.YEARS.between(student.getDateOfBirth(), LocalDate.of(2023, 2, 14)) <= 18)
                .skip(100);

        Stream<Student> studentsDormitory3_4 = studentsBel.get() //студенты после 18 лет
                .filter(student -> ChronoUnit.YEARS.between(student.getDateOfBirth(), LocalDate.of(2023, 2, 14)) > 18);

        double sumDormitory3_4 = Stream.concat(studentsOutcast, studentsDormitory3_4) //сумма оплаты белорусских студентов за общежитие 3-4
                .limit(370)
                .mapToDouble(student -> 29.6).sum();
        System.out.println((sumDormitory1 + sumDormitory2 + sumDormitory3_4) * 10);
    }
}