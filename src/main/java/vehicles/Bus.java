package vehicles;

import io.SingletonScanner;

import java.util.Scanner;

public class Bus extends Vehicle {
    public static Scanner input = new SingletonScanner().getScanner();
    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void drive() {
        System.out.println("Bus is driving");
    }


    private void inputSeats() {
        boolean isIncorrect = true;
        int amount = 0;
        while (isIncorrect) {
            System.out.println("Enter the the seats amount");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                amount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setSeats(amount);
//        input.close();
    }

    public Bus() {
        super();
        inputSeats();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("\t3: Seats amount is: ");
        System.out.println(getSeats());
    }

    public void edit() {
        boolean isIncorrect;
        int amount = 0;
        do {
            System.out.println("Enter the spec you want to edit");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                amount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            int specs = 3;
            if ((amount < 1) || (amount > specs)) {
                isIncorrect = true;
                System.out.println("Incorrect input, choose the number" +
                        "between 1 and " + specs);
            }
        } while (isIncorrect);
        switch (amount) {
            case 1 -> {
                super.edit(1);
            }
            case 2 -> {
                super.edit(2);
            }
            case 3 -> {
                inputSeats();
            }
        }
    }
}
