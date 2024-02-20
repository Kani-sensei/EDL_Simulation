package org.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class controller {
    private static String name;
    private static String gender;
    private static int age;

    // Constructor

    // Methods
    public void setName(String name) {
        controller.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        controller.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        controller.age = age;
    }

    public void birthday(LocalDate birthdate) {
        LocalDate today = LocalDate.now();
        if (today.getMonthValue() == birthdate.getMonthValue() && today.getDayOfMonth() == birthdate.getDayOfMonth()) {
            age++;
            System.out.println("Happy birthday! You are now " + age + " years old!");
        } else {
            System.out.println("Sorry, it's not your birthday!");
            int untilBirthdayMonth = birthdate.getMonthValue() - today.getMonthValue();
            int untilBirthdayDay = birthdate.getDayOfMonth() - today.getDayOfMonth();
            if (untilBirthdayMonth < 1 || untilBirthdayMonth > 12) {
                throw new IllegalArgumentException("Unknown number of Month: " + untilBirthdayMonth);
            } else if (untilBirthdayDay < 1) {
                throw new IllegalArgumentException("It must be above 1 and not " + untilBirthdayDay);
            } else {
                System.out.println("You have " + untilBirthdayMonth + " Months and " + untilBirthdayDay + " Days until your birthday!");
            }
        }
    }

    public static LocalDate createBirthdate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
        return LocalDate.of(year, month, day);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Enter your gender: ");
        String gender = scanner.next();

        System.out.println("Enter your birth year: ");
        int year = scanner.nextInt();

        System.out.println("Enter your birth month: ");
        int month = scanner.nextInt();

        System.out.println("Enter your birth day: ");
        int day = scanner.nextInt();

        controller human = new controller();
        human.setName(name);
        human.setAge(age);
        human.setGender(gender);
        human.birthday(createBirthdate(year, month, day));

        List<controller> humans = new ArrayList<>();
        humans.add(human);

        for (controller h : humans) {
            System.out.println("Name: " + h.getName());
            System.out.println("Age: " + h.getAge());
            System.out.println("Gender: " + h.getGender());
            System.out.println("Birthdate: " + createBirthdate(year, month, day));
        }

        System.out.println("Enter name: ");
        String newName = scanner.nextLine();

        System.out.println("Enter new age: ");
        int newAge = scanner.nextInt();

        System.out.println("Enter new gender: ");
        String newGender = scanner.next();

        if (newName.equals(human.getName()) && newAge == human.getAge() && newGender.equals(human.getGender())) {
            System.out.println("Values are the same!");
        } else {
            System.out.println("Human updated!");
            human.setName(newName);
            human.setAge(newAge);
            human.setGender(newGender);
            human.birthday(createBirthdate(year, month, day));
        }
    }
}