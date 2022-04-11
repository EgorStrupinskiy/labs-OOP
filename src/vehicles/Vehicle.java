package vehicles;

import io.SingletonScanner;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Vehicle implements Serializable {
    public static Scanner input = SingletonScanner.getScanner();
    private int wheels;
    private String name;

    public abstract void drive();

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int value) {
        this.wheels = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String valueStr) {
        this.name = valueStr;
    }

    public void showInfo() {
        System.out.println("\t" + this.getClass().toString());
        System.out.print("\t1: Wheels count: ");
        System.out.println(this.getWheels());
        System.out.print("\t2: Vehicle`s name: ");
        System.out.println(this.getName());
    }

    private void inputWheels() {
        boolean isIncorrect = false;
        int amount = 0;
        do {
            System.out.println("Enter the wheels amount");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                amount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        } while (isIncorrect);
        setWheels(amount);
    }

    private void inputName() {
        boolean isIncorrect = false;
        String str = "";
        do {
            System.out.println("Enter the name of the car");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                str = input.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        } while (isIncorrect);
        setName(str);
    }

    public void edit(int index) {
        switch (index) {
            case 1 -> {
                inputWheels();
            }
            case 2 -> {
                inputName();
            }
        }
    }

    public Vehicle() {
        inputWheels();
        inputName();
    }

    public abstract void edit();
}
