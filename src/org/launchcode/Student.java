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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentsMajor getMajor() {
        return major;
    }

    public void setMajor(StudentsMajor major) {
        this.major = major;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}