import java.util.Scanner;

public class Bus extends Vehicle{
    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void drive() {
        System.out.println("Bus is driving");
    }



    private void inputSeats() {
        Scanner sc = new Scanner(System.in);
        boolean isIncorrect = true;
        int amount = 0;
        while (isIncorrect) {
            System.out.println("Enter the the seats amount");
            System.out.print("Input: ");

            isIncorrect = false;
            try {
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.out.println("Incorrect input");
            }
        }
        setSeats(amount);
//        sc.close();
    }

    public Bus() {
        super();
        inputSeats();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("\tSeats amount is: ");
        System.out.println(getSeats());
    }
}
