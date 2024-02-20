package org.human;

import java.time.LocalDate;
import java.util.Scanner;

public class controller {
    private static String name;
    private static String gender;
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

    public void haveBirthday(LocalDate birthdate) {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birth year: ");
        year = scanner.nextInt();
        System.out.println("Enter your birth month: ");
        month = scanner.nextInt();
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Unknown month: " + month);
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Unknown day: " + day);
        }
        return LocalDate.of(year, month, day);
    }

    public class CreateHuman{
        Scanner scanner = new Scanner(System.in);
        public void main(String[] args) {
            System.out.println("Enter your name: ");
            System.out.println("Enter your age: ");
            System.out.println("Enter your gender: ");
            System.out.println("Enter your birth year: ");
            System.out.println("Enter your birth month: ");
            System.out.println("Enter your birth day: ");
            try {
                String name = scanner.nextLine();
                int age = scanner.nextInt();
                String gender = scanner.nextLine();
                int year = scanner.nextInt(); 
                int month = scanner.nextInt(); 
                int day = scanner.nextInt(); 
                LocalDate birthdate = createBirthdate(year, month, day);

                haveBirthday(birthdate);
            } catch (Exception e) {
                System.out.println("Error: " + e);
                System.out.println("Enter valid attributes! ");
            }
        }

    public class ViewHuman {
        public void main(String[] args) {
            System.out.println("Name: " + name + "\nGender: " + gender + "\nAge: " + age);
        }
    }

    public class AddHuman {
        public static void main(String[] args) {
            controller human = new controller();
            human.setName(name);
            human.setGender(gender);
            human.setAge(age);
            int year = 0; // Declare the variable year
            int month = 0; // Declare the variable month
            int day = 0; // Declare the variable day
            human.haveBirthday(createBirthdate(year, month, day)); // Fix: Pass the required arguments for the createBirthdate() method.
        }
    }
}

           

