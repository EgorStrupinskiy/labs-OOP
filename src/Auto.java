import java.util.Scanner;

public class Auto extends Vehicle{
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
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect;
        String str = "";
        do {
            System.out.println("Enter the carcase (hatchback, sedan, limousine");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                str = sc.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        } while (isIncorrect);
        setCarcase(str);
//        sc.close();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("\tCar carcase is: ");
        System.out.println(getCarcase());
    }
}
