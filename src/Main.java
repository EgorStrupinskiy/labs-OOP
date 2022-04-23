import by.egorstrupinski.bsuir.CryptService;
import by.egorstrupinski.serializer.BinaryDeserializer;
import by.egorstrupinski.serializer.BinarySerializer;
import vehicles.*;
import io.SingletonScanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main {
    public static Scanner input = SingletonScanner.getScanner();
    static List<Vehicle> cars = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello\n");
        start();
        input.close();
    }

    public static void start() {
        boolean isIncorrect;
        int choice = 0;
        do {
            showStartMenuList();
            isIncorrect = false;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            if (!isIncorrect && ((choice < 0) || (choice > 2))) {
                System.out.println("There is no such points");
                isIncorrect = true;
            }
        } while (isIncorrect);
        switch (choice) {
            case 1 -> {
                menu();
            }
            case 2 -> {
                loadFromFile();
                printList();
                menu();
            }
        }
    }

    public static void showStartMenuList() {
        System.out.println("\nActivities:");
        System.out.println("\t1.Create new list");
        System.out.println("\t2.Download from file");
        System.out.print("Your input: ");
    }

    public static void menu() {
        boolean isIncorrect;
        int choice = 0;
        do {
            showMenuList();
            isIncorrect = false;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            if (!isIncorrect && ((choice < 0) || (choice > 6))) {
                System.out.println("There is no such points");
                isIncorrect = true;
            }
        } while (isIncorrect);
        switch (choice) {
            case 1 -> {
                addCar();
                printList();
            }
            case 2 -> {
                printList();
                deleteCar();
            }
            case 3 -> {
                printList();
            }
            case 4 -> {
                printList();
                carsEdit();
            }
            case 5 -> {
                saveFile();
            }
            case 6 -> {
                return;
            }
        }
        menu();
    }

    private static void showMenuList() {
        System.out.println("\nActivities:");
        System.out.println("\t1.Add new vehicle");
        System.out.println("\t2.Delete vehicle");
        System.out.println("\t3.Show vehicle`s list");
        System.out.println("\t4.Edit vehicle");
        System.out.println("\t5.Save to file");
        System.out.println("\t6.Exit");
        System.out.print("Your input: ");
    }

    public static void printList() {
        int count = 1;
        if (cars.size() == 0)
            System.out.println("\nThe cars list is empty");
        else {
            for (Vehicle car : cars) {
                System.out.println("\nCar number " + count);
                car.showInfo();
                count++;
            }
        }
    }

    private static void addCar() {
        boolean isIncorrect = false;
        int choice = 0;
        do {
            System.out.println("Enter the vehicle type: ");
            System.out.println("\t1: Vehicles.Auto");
            System.out.println("\t2: Vehicles.Bus");
            System.out.println("\t3: Vehicles.Truck");
            System.out.println("\t4: Vehicles.Tank");
            System.out.print("Your input: ");
            try {
                choice = Integer.parseInt(input.nextLine());
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
            case 1 -> {
                cars.add(new Auto());
            }
            case 2 -> {
                cars.add(new Bus());
            }
            case 3 -> {
                cars.add(new Truck());
            }
            case 4 -> {
                cars.add(new Tank());
            }
        }
    }

    public static void deleteCar() {
        if (cars.size() == 0) {
            return;
        }
        boolean isIncorrect;
        int amount = 0;
        do {
            System.out.println("Enter the car`s number");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                amount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            if ((amount < 1) || (amount > cars.size())) {
                isIncorrect = true;
                System.out.println("Incorrect input, choose the number" +
                        "between 1 and " + cars.size());
            }
        } while (isIncorrect);
        cars.remove(amount - 1);
//        input.close();
    }

    public static void carsEdit() {
        boolean isIncorrect = false;
        int amount = 0;
        do {
            System.out.println("Enter the car`s number");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                amount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            if ((amount < 1) || (amount > cars.size())) {
                isIncorrect = true;
                System.out.println("Incorrect input, choose the number" +
                        "between 1 and " + cars.size());
            }
        } while (isIncorrect);
        cars.get(amount - 1).edit();
    }

    public static String getFileName() {
        boolean isIncorrect;
        String str = "";
        do {
            System.out.println("Enter the filePath");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                str = input.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }

            File tmp = new File(str);
            if (!isIncorrect && !tmp.exists()) {
                System.out.println("File doesnt exist");
                isIncorrect = true;
            }
        } while (isIncorrect);
        return (str);
    }


    private static String getSecretKey() {
        boolean isIncorrect;
        String str = "";
        do {
            System.out.println("Enter the secret key to decrypt data \n");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                str = input.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            if (!isIncorrect && str.length() == 0) {
                System.out.println("Enter the key!!!!!!");
                isIncorrect = true;
            }
        } while (isIncorrect);
        return str;
    }

    public static void saveFile() {
        try {
            BinarySerializer binarySerializer = new BinarySerializer();
            byte[] data = binarySerializer.serialize(cars);
            CryptService crService = new CryptService();
            byte[] cryptedData = crService.encrypt(data);
            FileOutputStream fileOutputStream = new FileOutputStream(getFileName());
            fileOutputStream.write(cryptedData);
        } catch (IOException e) {
            System.out.println("Cars list serialization failed");
        }
    }

    public static void loadFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(getFileName());
            byte[] encryptedData = fileInputStream.readAllBytes();
            CryptService crService = new CryptService();
            byte[] decryptedData = crService.decrypt(encryptedData, getSecretKey());
            BinaryDeserializer binaryDeserializer = new BinaryDeserializer();
            cars = (List<Vehicle>)binaryDeserializer.deserialize(decryptedData);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cars list deserialization failed");
        }
    }
}
