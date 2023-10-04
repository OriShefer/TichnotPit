public class Person {
    private long personID;
    private String name;
    private int age;

    public Person(String name, long personID, int age) {
        this.changePersonID(personID);
        this.changeName(name);
        this.changeAge(age);
    }

    public long personID() {
        return this.personID;
    }

    private void changePersonID(long personID) {
        this.personID = personID;
    }

    public String name() {
        return this.name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public int age() {
        return this.age;
    }

    private void changeAge(int age) {
        this.age = age;
    }

    public boolean equals(Object person) {
        boolean isEqual = true;

        if ((person == null) || !(this.getClass().equals(person.getClass()))) {
            isEqual = false;
        } else if (this != person && !this.isPersonEqual((Person) person)) {
            isEqual = false;
        }

        return isEqual;
    }

    private boolean isPersonEqual(Person personToCompare) {
        return (this == personToCompare
                || this.personID() == personToCompare.personID());
    }
}
