public class Patient {
    private int age;
    private String name;
    private String backetCase;

    public void printPatient() {
        System.out.println("name : " + this.name());
        System.out.println("age : " + this.age());
        System.out.println("backetCase : " + this.backetCase());
    }

    public int age() {
        return age;
    }

    public void changeAge(int age) {
        this.age = age;
    }

    public String name() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String backetCase() {
        return backetCase;
    }

    public void changeBacketCase(String backetCase) {
        this.backetCase = backetCase;
    }

}
