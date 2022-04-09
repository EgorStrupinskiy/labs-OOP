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
        System.out.println("Wheels count:");
        System.out.println("\t" + this.getWheels());
        System.out.println("Vehicle`s name:");
        System.out.println("\t" + this.getName());
    }

    private void inputWheels() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = false;
        int amount = 0;
        while (isIncorrect) {
            System.out.println("Enter the the wheels amount");
            isIncorrect = false;
            try {
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setWheels(amount);
        sc.close();
    }

    private void inputName() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = false;
        String str = "";
        while (isIncorrect) {
            System.out.println("Enter the name of the car");
            isIncorrect = false;
            try {
                str = sc.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setName(str);
        sc.close();
    }

    public Vehicle() {
        inputWheels();
        inputName();
    }
}
