package org.human;

import java.time.LocalDate;

public class Human {
    private String name;
    private String gender;
    private static int age;

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

    public static void haveBirthday(LocalDate birthdate) {
        LocalDate today = LocalDate.now();
        if (today.getMonthValue() == birthdate.getMonthValue() && today.getDayOfMonth() == birthdate.getDayOfMonth()) {
            age++;
            System.out.println("Happy birthday! You are now " + age + " years old!");
        }
        else {
            System.out.println("Sorry, it's not your birthday!");
            int untilBirthdayMonth = birthdate.getDayOfMonth() - today.getDayOfMonth();
            int untilBirthdayDay = birthdate.getDayOfMonth() - today.getDayOfMonth();
            if (untilBirthdayMonth < 1 || untilBirthdayMonth > 12 ) {
                throw new IllegalArgumentException("Unknown number of Month: " + untilBirthdayMonth);
            }
            else if (untilBirthdayDay < 1) {
                throw new IllegalArgumentException("It must above 1 and not " + untilBirthdayDay);
            }
            else {
                System.out.println("You have " + untilBirthdayMonth + " Months and " + untilBirthdayDay + " Days until your birthday!");
            }
        }

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
