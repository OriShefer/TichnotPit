import java.util.Objects;

public class Record {

    private Person person;
    private String phoneNumber;

    public Record(Person person, String phoneNumber) {
        this.person = person;
        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateDetails(String name, String phoneNumber){
        this.person.changeName(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + this.person.personID() +
                ", fullName='" + this.person.name() + '\'' +
                ", age=" + this.person.age() +
                ", phoneNumber=" + this.phoneNumber +
                '}';
    }

    public boolean equals(Object record) {
        boolean isEqual = true;

        if ((record == null) || !(this.getClass().equals(record.getClass()))) {
            isEqual = false;
        } else if (this != record && !this.isRecordEqual((Record) record)) {
            isEqual = false;
        }

        return isEqual;
    }

    private boolean isRecordEqual(Record recordToCompare) {
        return recordToCompare.getPerson().equals(this.getPerson()) &&
                recordToCompare.getPhoneNumber().equals(this.getPhoneNumber());
    }

}
