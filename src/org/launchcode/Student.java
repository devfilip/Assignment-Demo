package org.launchcode;

public class Student {
    private String name;
    private String surname;
    private StudentsMajor major;
    private int yearOfStudy;
    private double averageGrade;

    public Student(String name, String lastName, StudentsMajor major, int yearOfStudy, double averageGrade) {
        this.name = name;
        this.surname = lastName;
        this.major = major;
        this.yearOfStudy = yearOfStudy;
        this.averageGrade = averageGrade;
    }

}