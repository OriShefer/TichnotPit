import java.util.ArrayList;

public class CityRecords {

    private ArrayList<Record> records;
    private String cityName;

    public CityRecords(String cityName, ArrayList<Record> records) {
        this.changeCityName(cityName);
        this.changeRecords(records);
    }

    public String cityName() {
        return this.cityName;
    }

    private void changeCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<Record> records() {
        return this.records;
    }

    private void changeRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public int recordsAmount(){
        return records.size();
    }

    public Record getResidentRecord(long id){

        for (Record record :this.records){
            if(record.getPerson().personID() == id)
                return record;
        }

        return null;

    }

    public void addRecord(Record newRecord){
        Record residentRecord = getResidentRecord(newRecord.getPerson().personID());
        if(residentRecord != null)
            residentRecord.updateDetails(newRecord.getPerson().name(), newRecord.getPhoneNumber());
        else
            this.records.add(newRecord);
    }

    public void deleteRecord(Record recordToRemove){

        this.records.remove(recordToRemove);

    }
    public void deleteAllRecords(){
        this.records.clear();
    }

    public String toString() {
        String cityString =   "-------------------------------------------------" + "\n" +
                "|\t\t\t"
                + this.cityName()
                + (this.cityName().length() > 6 ? "\t\t|" : "\t\t\t|") + "\n" +
                "-------------------------------------------------" + "\n";

        for (Record currRecord : this.records()) {
            cityString += currRecord.toString() + "\n";
        }

        return cityString;
    }

    public boolean equals(Object cityRecords) {
        boolean isEqual = true;

        if ((cityRecords == null) || !(this.getClass().equals(cityRecords.getClass()))) {
            isEqual = false;
        } else if (this != cityRecords && !this.isCityRecordEqual((CityRecords) cityRecords)) {
            isEqual = false;
        }

        return isEqual;
    }

    public boolean isCityRecordEqual(CityRecords cityRecordsToCompare) {
        return ((this.cityName().equals(cityRecordsToCompare.cityName()))
                && (this.records().equals(cityRecordsToCompare.records())));
    }

    public int calculateAgeAverage() {
        int ageSum = 0;

        for (Record currRecord : this.records()) {
            ageSum += currRecord.getPerson().age();
        }

        return ageSum / this.recordsAmount();
    }


}
