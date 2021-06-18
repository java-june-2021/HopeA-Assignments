public class Samurai extends Human {

    static int numOfSamurai;

    public Samurai() {
        this.health = 200;
        numOfSamurai++;
    }

    public void deathBlow(Human target) {
        target.health = 0;
        this.health -= (this.health/2);
    }

    public void meditate() {
        this.health += (this.health/2);
    }

    public static void howMany() {
        System.out.println(numOfSamurai);
    }


}