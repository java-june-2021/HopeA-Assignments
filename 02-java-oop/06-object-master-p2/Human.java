public class Human {
    
    protected int strength;
    protected int stealth;
    protected int intelligence;
    protected int health;

    public Human() {
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
    }

    public void attack(Human target) {
        target.health -= this.strength;
        System.out.println("The human attacked the target human by " + this.strength + ". The target's new health is " + target.health);
    }
}