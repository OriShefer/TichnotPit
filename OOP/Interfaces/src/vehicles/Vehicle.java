package vehicles;

public abstract class Vehicle {

    private int speed;
    private String serialID;

    public Vehicle(String serialID){
        this.speed = 0;
        this.serialID = serialID;
    }

    public int speed() {
        return speed;
    }

    public void changeSpeed(int speed) {
        this.speed = speed;
    }

    public String serialID() {
        return serialID;
    }

    public void changeSerialID(String serialID) {
        this.serialID = serialID;
    }

    public abstract void accelerate();



}
