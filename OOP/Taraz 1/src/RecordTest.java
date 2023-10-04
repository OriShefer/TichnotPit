import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTest {

    Record firstRecord;

    @Before
    public void createInitialRecord() {
        this.firstRecord = new Record(new Person("ori", 213749914, 20),"123");
    }

    @Test
    public void equals_equalRecords() {
        Record secondRecord = new Record(new Person("ori", 213749914, 20),"123");

        assertEquals(this.firstRecord, secondRecord);
    }

    @Test
    public void equals_notEqualRecords() {
        Record secondRecord = new Record(new Person("ori", 213749914, 10),"123");

        assertNotEquals(this.firstRecord, secondRecord);
    }

    @Test
    public void equals_sameRecord() {
        assertEquals(this.firstRecord, this.firstRecord);
    }

    @Test
    public void equal_differentObjects() {
        assertNotEquals(this.firstRecord, "Check");
    }
}