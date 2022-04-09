import java.io.IOException;
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
        boolean isIncorrect = false;
        String str = "";
        while (isIncorrect) {
            System.out.println("Enter the carcase (hatchback, sedan, limousine");
            isIncorrect = false;
            try {
                str = sc.nextLine();
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setCarcase(str);
        sc.close();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Car carcase is:");
        System.out.println(getCarcase());
    }
}
