import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CityRecordsTest {

    CityRecords cityRecords;

    @Before
    public void initCityRecordsObject() {
        ArrayList<Record> records = new ArrayList<Record>();
        records.add(new Record(new Person("First", 12345, 14) , "54321"));
        records.add(new Record(new Person("Second" , 23456,  14) , "65432"));
        records.add(new Record(new Person("Third", 34567,  14), "76543"));
        this.cityRecords = new CityRecords("Jerusalem", records);
    }

      @Test
    public void getResidentRecord_existingID() {
        Record expectedRecord = new Record(new Person("Second" , 23456,  14) , "65432");
        assertEquals(expectedRecord, cityRecords.getResidentRecord(23456));
    }

    @Test
    public void getResidentRecord_notExistingID() {
        assertNull(cityRecords.getResidentRecord(123456));
    }


    @Test
    public void addRecord_existingRecordIdentical() {
        ArrayList<Record> newRecords = new ArrayList<Record>();
        newRecords.add(new Record(new Person("First", 12345, 14) , "54321"));
        newRecords.add(new Record(new Person("Second" , 23456,  14) , "65432"));
        newRecords.add(new Record(new Person("Third", 34567,  14), "76543"));

        this.cityRecords.addRecord(new Record(new Person("First", 12345, 14) , "54321"));
        assertEquals(newRecords, cityRecords.records());
    }

    @Test
    public void addRecord_notExistingRecord() {
        ArrayList<Record> newRecords = new ArrayList<Record>();
        newRecords.add(new Record(new Person("First", 12345, 14), "54321"));
        newRecords.add(new Record(new Person("Second", 23456, 14), "65432"));
        newRecords.add(new Record(new Person("Third", 34567, 14), "76543"));
        newRecords.add(new Record(new Person("Fourth", 87654, 14), "76113"));

        this.cityRecords.addRecord(new Record(new Person("Fourth", 87654, 14), "76113"));
        assertEquals(newRecords, cityRecords.records());

    }

    @Test
    public void equals_equalCityRecords() {
        ArrayList<Record> records = new ArrayList<Record>();
        records.add(new Record(new Person("First", 12345, 14) , "54321"));
        records.add(new Record(new Person("Second" , 23456,  14) , "65432"));
        records.add(new Record(new Person("Third", 34567,  14), "76543"));
        CityRecords secondCityRecords = new CityRecords("Jerusalem", records);

        assertEquals(cityRecords,secondCityRecords);

    }

    @Test
    public void equals_notEqualCityRecords() {
        ArrayList<Record> records = new ArrayList<Record>();
        records.add(new Record(new Person("first", 11111111, 14) , "54321"));
        records.add(new Record(new Person("Second" , 23456,  14) , "65432"));
        records.add(new Record(new Person("Third", 34567,  14), "76543"));
        CityRecords secondCityRecords = new CityRecords("Jerusalem", records);

        assertNotEquals(cityRecords,secondCityRecords);

    }

    @Test
    public void equals_sameCityRecords() {
        assertEquals(cityRecords,cityRecords);
    }

    @Test
    public void equals_differentObject() {
        assertNotEquals(cityRecords,"sadasd");
    }
}