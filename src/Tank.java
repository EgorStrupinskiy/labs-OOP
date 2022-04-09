public class Tank extends Vehicle{
    private int armor;

    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }

    private void shoot() {
        System.out.println("BANG!");
    }

    @Override
    public void drive() {
        System.out.println("Tank is driving");
    }

    @Override
    public void showInfo() {
        System.out.println("Tank`s armor thickness is");
        System.out.println(armor);
    }
}
