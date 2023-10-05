package vehicles;

import exceptions.FlyException;
import exceptions.LandException;
import exceptions.TakeOffException;
import vehicles.interfaces.Drivable;
import vehicles.interfaces.Flyable;

public class Airplane extends Vehicle implements Drivable, Flyable {

    private int heightLevel;

    final int TAKEOFF_SPEED = 200;
    final int FLYING_SPEED = 100;
    final int DRIVING_SPEED = 50;
    final int STARTING_SPEED = 120;

    public Airplane(String serialID) {
        super(serialID);
        changeHeightLevel(0);
    }

    public int heightLevel() {
        return heightLevel;
    }

    public void changeHeightLevel(int heightLevel) {
        this.heightLevel = heightLevel;
    }

    @Override
    public void accelerate() {
        if(this.isFlying())
            super.changeSpeed(super.speed() + FLYING_SPEED);
        else
            super.changeSpeed(super.speed() + DRIVING_SPEED);

    }

    @Override
    public void drive() {
        super.changeSpeed(STARTING_SPEED);
    }

    @Override
    public void brake() {
        super.changeSpeed(0);
    }

    @Override
    public boolean isDriving() {
        return super.speed() > 0 && !this.isFlying();
    }

    @Override
    public void takeOff(int height) throws TakeOffException {
        if(!this.isDriving())
            throw new TakeOffException("The airplane is not driving");
        if(this.isFlying())
            throw new TakeOffException("The airplane is already flying");

        this.changeHeightLevel(height);
        super.changeSpeed(TAKEOFF_SPEED);
    }

    @Override
    public boolean isFlying() {
        return this.heightLevel() > 0;
    }

    @Override
    public void land() throws LandException {
        if(!this.isFlying())
            throw new LandException("The airplane is not flying");

        this.changeHeightLevel(0);
        this.drive();
        this.brake();
    }

    @Override
    public String toString() {
        return "Airplane " + super.serialID();
    }


}
