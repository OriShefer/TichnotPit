package vehicles;

import exceptions.AttackException;
import exceptions.LandException;
import exceptions.TakeOffException;
import vehicles.interfaces.Attackable;
import vehicles.interfaces.Flyable;

public class Helicopter extends Vehicle implements Flyable, Attackable {


    private int strikesCount;
    private int successfulStrikesCount;
    private int heightLevel;

    final int SUCCESSFUL_ATTACK_RANGE = 150;
    final int ACCELERATION_SPEED = 80;

    public Helicopter(String serialID){
        super(serialID);
        this.strikesCount = 0;
        this.successfulStrikesCount = 0;
        this.heightLevel = 0;
    }

    public int strikesCount() {
        return strikesCount;
    }

    public void changeStrikesCount(int strikesCount) {
        this.strikesCount = strikesCount;
    }

    public int successfulStrikesCount() {
        return successfulStrikesCount;
    }

    public void changeSuccessfulStrikesCount(int successfulStrikesCount) {
        this.successfulStrikesCount = successfulStrikesCount;
    }

    public int heightLevel() {
        return heightLevel;
    }

    public void changeHeightLevel(int heightLevel) {
        this.heightLevel = heightLevel;
    }



    @Override
    public boolean attack(int distance) throws AttackException {

        this.changeStrikesCount(this.strikesCount() + 1);

        if(!this.isFlying())
            throw new AttackException("Helicopter is not flying");

        if(distance > SUCCESSFUL_ATTACK_RANGE)
            throw new AttackException("distance is bigger then successful attack range");

        this.changeSuccessfulStrikesCount(this.successfulStrikesCount() + 1);
        return true;

    }

    @Override
    public void printAttackStats() {
        if(this.strikesCount() != 0){
            float perc = ((float) this.successfulStrikesCount / this.strikesCount()) * 100;
            System.out.println("percentage of successful attacks is: "+ perc + "%");
        }else
            System.out.println("no attacks has been made");
    }

    @Override
    public void takeOff(int height) throws TakeOffException {
        if(!this.isFlying()){
            this.changeHeightLevel(height);
            super.changeSpeed(SUCCESSFUL_ATTACK_RANGE);
        }else
            throw new TakeOffException("The Helicopter is already flying");
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
    }

    @Override
    public void accelerate() {
        super.changeSpeed(super.speed() + ACCELERATION_SPEED);
    }

        @Override
    public String toString() {
        return "Helicopter " + super.serialID();
    }
}
