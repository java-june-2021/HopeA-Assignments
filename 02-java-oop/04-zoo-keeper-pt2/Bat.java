public class Bat extends Mammal {

    public Bat(int energyLevel) {
        super(energyLevel);
    }

    public void fly() {
        System.out.println("WOOSH!");
        this.energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("So-well, nevermind. It's eating humans!");
        this.energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("The town's on FIRE!!");
        this.energyLevel -= 100;
    }
}