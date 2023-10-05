import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Restaurant {

    private HashMap<Integer, Integer> occupiedTables = new HashMap<>();

    private boolean isTableOccupied(int tableNumber) {
        return this.occupiedTables.containsKey(tableNumber);
    }

    public int dinersByTable(int tableNumber) {
        return this.occupiedTables.getOrDefault(tableNumber, 0);
    }

    public boolean occupyTable(int tableNumber, int dinersAmount) {
        if (!this.isTableOccupied(tableNumber)) {
            this.occupiedTables.put(tableNumber, dinersAmount);

            return true;
        }

        return false;
    }

    public boolean leaveTable(int tableNumber) {
        if (this.isTableOccupied(tableNumber)) {
            this.occupiedTables.remove(tableNumber);

            return true;
        }

        return false;
    }

    public void removeByDinersAmount(final int MAX_AMOUNT) {
        Iterator<Integer> iterator = this.occupiedTables.values().iterator();

        while (iterator.hasNext()) {
            int currDinersAmount = iterator.next();

            if (currDinersAmount > MAX_AMOUNT) {
                iterator.remove();
            }
        }
    }

    public void printOccupiedTables() {
        if (this.occupiedTables.isEmpty()) {
            System.out.println("\nThere are no currently occupied tables");
        } else {
            System.out.println("\nCurrently occupied tables: " + "\n-------------------");

            for (HashMap.Entry<Integer, Integer> currentTable : this.occupiedTables.entrySet()) {
                System.out.println(
                        "Table " + currentTable.getKey() + " seats " + currentTable.getValue() + " people");
            }
        }
    }
}