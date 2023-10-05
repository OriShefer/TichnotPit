import exceptions.*;
import vehicles.Airplane;
import vehicles.Helicopter;
import vehicles.Tank;
import vehicles.interfaces.Attackable;
import vehicles.interfaces.Drivable;
import vehicles.interfaces.Flyable;

public class Main {
    public static void main(String[] args) {
        final int HELICOPTER_HEIGHT = 15000;
        final int AIRPLANE_HEIGHT = 25000;
        final int SUCCESS_HELICOPTER_DISTANCE = 140;
        final int FAILURE_HELICOPTER_DISTANCE = 250;
        final int SUCCESS_TANK_DISTANCE = 40;
        final int FAILURE_TANK_DISTANCE = 160;
        final int INVALID_TANK_DISTANCE = 290;
        final String AIRPLANE_ID = "#111";
        final String HELICOPTER_ID = "#222";
        final String TANK_ID = "#333";

        Airplane airplane = new Airplane(AIRPLANE_ID);
        Helicopter helicopter = new Helicopter(HELICOPTER_ID);
        Tank tank = new Tank(TANK_ID);

        drive(airplane);

        fly(airplane, AIRPLANE_HEIGHT);
        fly(helicopter, HELICOPTER_HEIGHT);

        try {
            helicopter.takeOff(HELICOPTER_HEIGHT);
        } catch (TakeOffException e) {
            System.out.println(e.getMessage());
        }
        attack(helicopter, SUCCESS_HELICOPTER_DISTANCE);
        attack(helicopter, FAILURE_HELICOPTER_DISTANCE);
        try {
            helicopter.land();
        } catch (FlyException e) {
            throw new RuntimeException(e);
        }
        attack(helicopter, SUCCESS_HELICOPTER_DISTANCE);
        // expect an error to be thrown here, helicopter is not flying

        attack(tank, SUCCESS_TANK_DISTANCE);
        attack(tank, FAILURE_TANK_DISTANCE);
        attack(tank, INVALID_TANK_DISTANCE); // expect an error to be thrown here

        printAttackerStats(helicopter);
        printAttackerStats(tank);
    }

    public static void fly(Flyable flyer, int height) {
        try {

            flyer.takeOff(height);
            System.out.println(flyer + " is up in the air");
            flyer.land();
            System.out.println(flyer + " is down on earth");

        } catch (FlyException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void attack(Attackable attacker, int distance) {
        try {
            boolean isAttackSucceeded = attacker.attack(distance);
            System.out.println("Attack " + (isAttackSucceeded ? "succeeded" : "failed"));
        } catch (AttackException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void printAttackerStats(Attackable attacker) {
        System.out.println(attacker + " stats: ");
        attacker.printAttackStats();
    }

    public static void drive(Drivable driver) {
        driver.drive();
    }
}