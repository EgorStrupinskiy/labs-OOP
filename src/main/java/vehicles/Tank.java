package vehicles;

import io.SingletonScanner;

import java.util.Scanner;

public class Tank extends Vehicle {


    public static Scanner input = new SingletonScanner().getScanner();

    private int armor;

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void drive() {
        System.out.println("Tank is driving");
    }

    private void inputArmor() {
        boolean isIncorrect = true;
        int amount = 0;
        while (isIncorrect) {
            System.out.println("Enter the the tank`s armor thickness");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                amount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setArmor(amount);
//        input.close();
    }

    public Tank() {
        super();
        inputArmor();
    }

    public static Tank getTank() {
        return Tank.builder().setWheels().setArmor().setName().build();
    }

    public static TankBuilder builder() {
        return new TankBuilder();
    }

    public Tank(int armor,int wheels, String name) {
        super(wheels, name);
        this.armor = armor;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("\t3: Tank`s armor thickness is: ");
        System.out.println(getArmor());
    }

    public void edit() {
        boolean isIncorrect = false;
        int amount = 0;
        int specs = 3;
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
                inputArmor();
            }
        }
    }


    private static class TankBuilder {
        private int wheels;
        private String name;
        private int armor;

        public TankBuilder setWheels() {
            boolean isIncorrect = true;
            int amount = 0;
            while (isIncorrect) {
                System.out.println("Enter the the tank`s wheels amount");
                System.out.print("Input: ");

                isIncorrect = false;
                try {
                    amount = Integer.parseInt(input.nextLine());
                } catch (Exception e) {
                    isIncorrect = true;
                    System.out.println("Incorrect input");
                }
            }
            this.wheels = amount;
            return this;
        }

        public TankBuilder setArmor() {
            boolean isIncorrect = true;
            int amount = 0;
            while (isIncorrect) {
                System.out.println("Enter the the tank`s armor thickness");
                System.out.print("Input: ");

                isIncorrect = false;
                try {
                    amount = Integer.parseInt(input.nextLine());
                } catch (Exception e) {
                    isIncorrect = true;
                    System.out.println("Incorrect input");
                }
            }
            this.armor = amount;
            return this;
        }

        public TankBuilder setName() {
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
            this.name = str;
            return this;
        }

        public Tank build() {
            return new Tank(armor, wheels, name);
        }
    }
}
