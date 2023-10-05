package vehicles.interfaces;

import exceptions.AttackException;

public interface Attackable {

    boolean attack(int distance) throws AttackException;

    void printAttackStats();


}
