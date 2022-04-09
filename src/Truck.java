import java.util.Scanner;

public class Truck extends Vehicle{
    private int weight;
    private int consumption;

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void drive() {
        System.out.println("Truck is driving");
    }

    private void inputConsumption() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = true;
        int amount = 0;
        while (isIncorrect) {
            System.out.println("Enter the the truck`s consumption");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setConsumption(amount);
//        sc.close();
    }

    private void inputWeight() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = true;
        int amount = 0;
        while (isIncorrect) {
            System.out.println("Enter the the truck`s max weight");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setWeight(amount);
//        sc.close();
    }

    public Truck() {
        super();
        inputConsumption();
        inputWeight();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("\t3: The consumption is: ");
        System.out.println(getConsumption());
        System.out.print("\t3: The MAX weight is: ");
        System.out.println(getWeight());
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = false;
        int amount = 0;
        do {
            System.out.println("Enter the spec you want to edit");
            System.out.print("Input: ");
            isIncorrect = false;
            try {
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
            int specs = 4;
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
                inputConsumption();
            }
            case 4 -> {
                inputWeight();
            }
        }
    }
}
