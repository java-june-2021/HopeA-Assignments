public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double c = 0.0;
        c = Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
        
        return c;
    }
}