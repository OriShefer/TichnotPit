public class Citizen extends Patient {

    private String company;

    public String company() {
        return company;
    }

    public void changeCompany(String company) {
        this.company = company;
    }

    public Citizen(int age,String name, String backetCase, String company) {
        this.changeAge(age);
        this.changeName(name);
        this.changeBacketCase(backetCase);
        this.changeCompany(company);
    }

}
