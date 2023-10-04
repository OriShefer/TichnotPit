import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {

    private HashMap<String,CityRecords> cities;

    public Phonebook(HashMap<String, CityRecords> cities) {
        this.changeCities(cities);
    }

    public HashMap<String, CityRecords> cities() {
        return this.cities;
    }

    private void changeCities(HashMap<String, CityRecords> cities) {
        this.cities = cities;
    }

    public void addCity(String city) {
        if (!this.cities().containsKey(city)) {
            this.cities.put(city, new CityRecords(city, new ArrayList<Record>()));
        }
    }

    public void addRecord(String city, Record newRecord) {
        this.addCity(city);
        this.cities.get(city).addRecord(newRecord);
    }

    public void removeRecord(String city, Record recordToRemove){
        this.cities.get(city).deleteRecord(recordToRemove);
    }

    public CityRecords cityRecords(String cityName) {
        return this.cities.get(cityName);
    }

    public String cityRecordsToString(String cityName) {
        return this.cityRecords(cityName).toString();
    }

    public String toString() {
        String phoneString = "";

        for (CityRecords currCity : this.cities.values()) {
            phoneString += currCity.toString();
        }

        return phoneString;
    }

}
