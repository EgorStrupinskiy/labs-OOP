import java.util.Scanner;

public class Tank extends Vehicle{
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
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = true;
        int amount = 0;
        while (isIncorrect) {
            System.out.println("Enter the the tank`s armor");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setArmor(amount);
//        sc.close();
    }

    public Tank() {
        super();
        inputArmor();
    }

    @Override
    public void showInfo() {
        System.out.print("\t3: Tank`s armor thickness is: ");
        System.out.println(getArmor());
    }

    public void edit() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = false;
        int amount = 0;
        int specs = 3;
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
}
