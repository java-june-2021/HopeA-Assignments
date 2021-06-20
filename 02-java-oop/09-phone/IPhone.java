public class IPhone extends Phone implements Ringable {

    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return this.getRingTone();
    }

    @Override
    public String unlock() {
        return "This phone is now unlocked. Welcome!";
    }

    @Override
    public void displayInfo() {
        System.out.println("The version number for this phone is: " + this.getVersionNumber());
        System.out.println("The battery percentage is currently at: " + this.getBatteryPercentage());
        System.out.println("The carrier is: " + this.getCarrier());
        System.out.println("The ringtone is set to: " + this.getRingTone());
    }
}