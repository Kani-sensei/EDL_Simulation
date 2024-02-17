package org.human;

import java.time.LocalDate;

public class Human {
    private String name;
    private String gender;
    private int age;

    // Constructor


    // Methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static boolean haveBirthday(LocalDate birthdate) {
        LocalDate today = LocalDate.now();
        return today.getMonthValue() == birthdate.getMonthValue() && today.getDayOfMonth() == birthdate.getDayOfMonth();
    }

    public static LocalDate createBirthdate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Unknown month: " + month);
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Unknown day: " + day);
        }
        return LocalDate.of(year, month, day);
    }
}
