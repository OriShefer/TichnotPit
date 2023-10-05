public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String hobbies;

    public Person(String firstName, String lastName, int age, String hobbies) {
        this.changeFirstName(firstName);
        this.changeLastName(lastName);
        this.changeAge(age);
        this.changeHobbies(hobbies);
    }

    private String firstName() {
        return this.firstName;
    }

    public void changeFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName() {
        return this.lastName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }

    private int age() {
        return this.age;
    }

    public void changeAge(int age) {
        this.age = age;
    }

    private String hobbies() {
        return this.hobbies;
    }

    public void changeHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String fullName() {
        return this.firstName() + " " + this.lastName();
    }

    public void print() {
        System.out.println(
                fullName() + ", " + this.age() + ", hobbies: " + this.hobbies());
    }

    public boolean equals(Object object) {
        boolean isEqual = true;

        if ((object == null) || (this.getClass() != object.getClass())) {
            isEqual = false;
        } else if (this != object) {
            Person person = (Person) object;
            isEqual = ((this.firstName().equalsIgnoreCase(person.firstName()))
                    && (this.lastName().equalsIgnoreCase(person.lastName()))
                    && (this.age() == person.age())
                    && (this.hobbies().equalsIgnoreCase(person.hobbies())));
        }

        return isEqual;
    }

    public boolean doesHobbyExist(String hobby) {
        return this.hobbies().contains(hobby);
    }

    public void addHobby(String hobby) {
        if (!doesHobbyExist(hobby)) {
            this.changeHobbies(this.hobbies() + ", " + hobby);
        }
    }

    public void correctHobby() {
        this.changeHobbies(this.hobbies().replace('r', 'b'));
    }

    public String initials() {
        return (this.firstName().charAt(0) + "." + this.lastName().charAt(0)).toUpperCase();
    }

    public void updateMarriedName(Person spouse) {
        if (this.lastName().compareTo(spouse.lastName()) < 0) {
            this.changeLastName(spouse.lastName());
        } else if (this.lastName().compareTo(spouse.lastName()) > 0) {
            spouse.changeLastName(this.lastName());
        }
    }
}