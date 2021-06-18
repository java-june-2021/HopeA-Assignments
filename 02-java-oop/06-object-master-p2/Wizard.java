public class Wizard extends Human {

    public Wizard() {
        this.health = 50;
        this.intelligence = 8;
    }

    public void heal(Human target) {
        this.health += this.intelligence;
    }

    public void fireBall(Human target) {
        this.health -= (this.intelligence*3);
    }
}