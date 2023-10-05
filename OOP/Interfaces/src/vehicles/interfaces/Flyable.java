package vehicles.interfaces;

import exceptions.FlyException;
import exceptions.LandException;
import exceptions.TakeOffException;

public interface Flyable {

    void takeOff(int height) throws TakeOffException;

    boolean isFlying();

    void land() throws LandException;
}
