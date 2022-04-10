import io.SingletonScanner;

import java.util.Scanner;

public class Auto extends Vehicle {
    public static Scanner input = SingletonScanner.getScanner();

    private String carcase;

    public String getCarcase() {
        return carcase;
    }

    public void setCarcase(String str) {
        this.carcase = str;
    }

    @Override
    public void drive() {
        System.out.println("Auto is driving");
    }

    public Auto() {
        super();
        this.inputCarcase();
    }

    private void inputCarcase() {
        boolean isIncorrect;
        String str = "";
        do {
            System.out.println("Enter the carcase (hatchback, sedan, limousine");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                str = input.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        } while (isIncorrect);
        setCarcase(str);
//        input.close();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("\t3: Car carcase is: ");
        System.out.println(getCarcase());
    }

    public void edit() {
        boolean isIncorrect = false;
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
                inputCarcase();
            }
        }
    }
}
