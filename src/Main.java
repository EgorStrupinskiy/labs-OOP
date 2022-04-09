import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Vehicle> cars = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello\n");
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect;
        int choice = 0;
        do {
            showMenuList();
            isIncorrect = false;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            if (!isIncorrect && ((choice < 0) || (choice > 5))) {
                System.out.println("There is no such points");
                isIncorrect = true;
            }
        } while (isIncorrect);
        switch (choice) {
            case 1: {
                addCar();
                printList();
                break;
            }
            case 3: {
                printList();
                break;
            }
            case 5: {
                return;
            }
        }
            menu();
//        sc.close();
    }

    private static void showMenuList() {
        System.out.println("\nActivities:");
        System.out.println("\t1.Add new vehicle");
        System.out.println("\t2.Delete vehicle");
        System.out.println("\t3.Show vehicle`s list");
        System.out.println("\t4.Edit vehicle");
        System.out.println("\t5.Exit");
        System.out.print("Your input: ");
    }

    private static void addCar() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = false;
        int choice = 0;
        do {
            System.out.println("Enter the vehicle type: ");
            System.out.println("\t1: Auto");
            System.out.println("\t2: Bus");
            System.out.println("\t3: Truck");
            System.out.println("\t4: Tank");
            System.out.print("Your input: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                isIncorrect = false;
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            if (!isIncorrect && ((choice < 0) || (choice > 4))) {
                System.out.println("There is no such points");
                isIncorrect = true;
            }
        } while (isIncorrect);
        switch (choice) {
            case 1: {
                Vehicle auto = new Auto();
                cars.add(auto);
                break;
            }
            case 2: {
                Vehicle auto = new Bus();
                cars.add(auto);
                break;
            }
            case 3: {
                Vehicle auto = new Truck();
                cars.add(auto);
                break;
            }
            case 4: {
                Vehicle auto = new Tank();
                cars.add(auto);
                break;
            }
        }
//        sc.close();
    }

    public static void printList() {
        int count = 1;
        if (cars.size() == 0)
            System.out.println("\nThe cars list is empty");
        else
            for (Vehicle car : cars) {
                System.out.println("\nCar number " + count);
                car.showInfo();
                count++;
            }
    }
}
