import java.util.*;

public class RecordStore {
  private HashMap<String, Record> records;

  public RecordStore() {
    this.records = new HashMap<>();
  }

  public HashMap<String, Record> records() {
    return (this.records);
  }

  public void buy(String recordName, String singerName, int amountOfRecords)
          throws InvalidInputException {
    Record wantedRecord = this.records().get(recordName);

    if (wantedRecord == null) {
      this.records().put(recordName, new Record(recordName, singerName, amountOfRecords));
    } else {
      wantedRecord.add(amountOfRecords);
    }
  }

  public void sell(String recordName, int recordsNum)
          throws InvalidInputException, OutOfStockException {
    Record wantedRecord = this.records().get(recordName);

    if (wantedRecord != null) {
      wantedRecord.remove(recordsNum);
    }
  }

  public void printRecord(String recordIndex) throws InvalidInputException {
    try {
      int recordInArrayIndex = Integer.parseInt(recordIndex);
      ((Record)this.records().values().toArray()[recordInArrayIndex]).print();
    } catch (NumberFormatException exception) {
      throw new InvalidInputException("The record index must to be numeric...");
    } catch (IndexOutOfBoundsException exception) {
      throw new InvalidInputException("Your index is out of the records range (Maximum " + this.records.size() + ")");
    }
  }


  public void print() {
    for (Map.Entry<String, Record> entry : this.records().entrySet()) {
      entry.getValue().print();
    }
  }
}