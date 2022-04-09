import java.util.Scanner;

public abstract class Vehicle{
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
        System.out.print("\tWheels count: ");
        System.out.println(this.getWheels());
        System.out.print("\tVehicle`s name: ");
        System.out.println(this.getName());
    }

    private void inputWheels() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = false;
        int amount = 0;
        do {
            System.out.println("Enter the wheels amount");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        } while (isIncorrect);
        setWheels(amount);
//        sc.close();
    }

    private void inputName() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = false;
        String str = "";
        do {
            System.out.println("Enter the name of the car");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                str = sc.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        } while (isIncorrect);
        setName(str);
//        sc.close();
    }

    public Vehicle() {
        inputWheels();
        inputName();
    }
}
