public class Main {

  static RecordStore nadavStore = new RecordStore();

  public static void main(String[] args) {
    // Check for buy method
    handleBuy("Let it be", "Beatles", 5);
    handleBuy("Let it be", "Beatles", 10);
    handleBuy("Let it be", "Beatles", 5);
    handleBuy("Here comes the sun", "Beatles", 5);
    handleBuy("Winds of War", "Arik Ainshtein", 0);
    handleBuy("Frozen", "Madona", 5);
    handleBuy("Road of the peace", "Peer Tasi", 15);
    handleBuy("Mabat Koev", "Avi Bitter", 15);
    handleBuy("Ahavtiya", "Shlomo Artzi", 15);

    // Check for sell method
    handleSell("Frozen", 6);
    handleSell("Frozen", 0);
    handleSell("Frozen", -5);
    handleSell("Ahavtiya", 29);

    // Checks the printing methods
    nadavStore.print();

    handlePrintRecord("4");
    handlePrintRecord("10");
    handlePrintRecord("Oops");
  }

  public static void handleSell(String recordName, int amountOfRecords) {
    try {
      nadavStore.sell(recordName, amountOfRecords);
    } catch (OutOfStockException | InvalidInputException invalidInput) {
      System.out.println(invalidInput.getMessage());
    }
  }

  public static void handleBuy(String recordName, String singerName, int amountOfRecords) {
    try {
      nadavStore.buy(recordName, singerName, amountOfRecords);
    } catch (InvalidInputException invalidInput) {
      System.out.println(invalidInput.getMessage());
    }
  }

  public static void handlePrintRecord(String recordIndex) {
    try {
      nadavStore.printRecord(recordIndex);
    } catch (InvalidInputException invalidInput) {
      System.out.println(invalidInput.getMessage());
    }
  }
}
