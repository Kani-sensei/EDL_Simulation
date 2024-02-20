package org.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private String name;
    private String gender;
    private int age;
    private LocalDate birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public class CreateHuman {
        public static void main(String[] args) {
            List<Controller> humans = new ArrayList<>(); 
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter age: ");
            int newAge = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Enter gender: ");
            String newGender = scanner.nextLine();
            System.out.println("Enter birth year: ");
            int year = scanner.nextInt();
            System.out.println("Enter birth month: ");
            int month = scanner.nextInt();
            System.out.println("Enter birth day: ");
            int day = scanner.nextInt();
            scanner.nextLine(); 
            try {
                LocalDate birthdate = Controller.createBirthdate(year, month, day);
                Controller newHuman = new Controller();
                newHuman.setName(newName);
                newHuman.setAge(newAge);
                newHuman.setGender(newGender);
                newHuman.setBirthdate(birthdate);
                humans.add(newHuman);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid attributes: " + e.getMessage());
                System.out.println("Please enter valid attributes!");
            }
            scanner.close();
        }
    }

    public class ViewHuman {
        public static void main(String[] args) {
            List<Controller> humans = new ArrayList<>(); 

            for (Controller human : humans) {
                System.out.println(human);
            }
        }
    }

    public class UpdateHuman {
        public static void main(String[] args) {
            List<Controller> humans = new ArrayList<>(); 
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the human you want to update: ");
            String name = scanner.nextLine();

            for (Controller human : humans) {
                if (human.getName().equals(name)) {
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new age: ");
                    int newAge = scanner.nextInt();
                }
            }
            scanner.close();
        }
    }

    public class DeleteHuman {
        public static void main(String[] args) {
            List<Controller> humans = new ArrayList<>(); 
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the human you want to delete: ");
            String name = scanner.nextLine();
            scanner.close();

            for (Controller human : humans) {
                if (human.getName().equals(name)) {
                    humans.remove(human);
                }

                else {
                    System.out.println("Human not found");
                    return;
                }
            }
            scanner.close();
        }
    }
}
