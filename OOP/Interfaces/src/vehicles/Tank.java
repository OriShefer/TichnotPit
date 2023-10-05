package vehicles;

import exceptions.AttackException;
import vehicles.interfaces.Attackable;
import vehicles.interfaces.Drivable;

public class Tank extends Vehicle implements Drivable, Attackable {

    private int strikesCount;
    private int successfulStrikesCount;

    final int UNSUCCESSFUL_ATTACK_RANGE = 250;
    final int SUCCESSFUL_ATTACK_RANGE = 60;
    final int DRIVING_SPEED = 25;
    final int ACCELERATION_SPEED = 15;

    public Tank(String serialID){
        super(serialID);
        this.strikesCount = 0;
        this.successfulStrikesCount = 0;
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

    @Override
    public void accelerate() {
        super.changeSpeed(super.speed() + ACCELERATION_SPEED);
    }

    @Override
    public boolean attack(int distance) throws AttackException {
        this.changeStrikesCount(this.strikesCount() + 1);

        if(distance > UNSUCCESSFUL_ATTACK_RANGE)
            throw new AttackException("distance is bigger then successful attack range");

        if(distance < SUCCESSFUL_ATTACK_RANGE){
            this.changeSuccessfulStrikesCount(this.successfulStrikesCount() + 1);
            return true;
        }
        return false;
    }

    @Override
    public void printAttackStats() {
        System.out.println("Number of attacks: " + this.strikesCount() + "\n"+
                            "Number of successful attacks: " + this.successfulStrikesCount());
    }

    @Override
    public void drive() {
        super.changeSpeed(DRIVING_SPEED);
    }

    @Override
    public void brake() {
        super.changeSpeed(0);
    }

    @Override
    public boolean isDriving() {
        return super.speed() > 0;
    }

    @Override
    public String toString() {
        return "Tank " + super.serialID();
    }
}
