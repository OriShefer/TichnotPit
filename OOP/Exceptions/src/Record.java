public class Record {
  private String recordName;
  private String singerName;
  private int count;

  public Record(String name, String singerName, int recordCount) throws InvalidInputException {
    this.updateRecordName(name);
    this.updateSingerName(singerName);

    if (recordCount < 0) {
      throw new InvalidInputException("Records count must be greater or equal to 0");
    }

    this.updateCount(recordCount);
  }

  public Record(Record record) throws InvalidInputException {
    this(record.name(), record.singerName(), record.count());
  }

  public String name() {
    return this.recordName;
  }

  public String singerName() {
    return this.singerName;
  }

  public int count() {
    return this.count;
  }

  public void updateRecordName(String strName) {
    this.recordName = strName;
  }

  public void updateSingerName(String singerName) {
    this.singerName = singerName;
  }

  public void updateCount(int count) {
    this.count = count;
  }

  public void add(int amountOfRecordsToAdd) throws InvalidInputException {
    if (amountOfRecordsToAdd <= 0) {
      throw new InvalidInputException("Addition count must be positive");
    }

    this.updateCount(this.count() + amountOfRecordsToAdd);
  }

  public void remove(int amountOfRecordsToRemove)
          throws InvalidInputException, OutOfStockException {
    if (amountOfRecordsToRemove <= 0) {
      throw new InvalidInputException("You can't remove nothing or a negative amount...");
    } else if (amountOfRecordsToRemove > this.count) {
      throw new OutOfStockException("Can't remove "
              + amountOfRecordsToRemove
              + "There are only "
              + this.count
              + " records in stock.");
    }

    this.updateCount(this.count() - amountOfRecordsToRemove);
  }

  public void print() {
    System.out.println(this.name() + ", by " + this.singerName() + ": " + this.count());
  }
}