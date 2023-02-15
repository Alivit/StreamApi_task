package by.chuiko.model;

import java.time.LocalDate;

public class Student {

    private int id;
    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;

    private String gender;
    private String city;
    private double averageRating;
    private boolean privileges;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, LocalDate dateOfBirth, String gender,
                   String city, double averageRating, boolean privileges) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.city = city;
        this.averageRating = averageRating;
        this.privileges = privileges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isPrivileges() {
        return privileges;
    }

    public void setPrivileges(boolean privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", firstName='" + firstName + ", lastName='" + lastName + ", dateOfBirth="
                + dateOfBirth + ",  gender='" + gender + ", city='" + city + ", averageRating=" + averageRating
                + ", privileges=" + privileges;
    }
}
