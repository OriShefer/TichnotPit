public class Solider extends Patient {
    private String unitName;

    public String unitName() {
        return unitName;
    }

    public void changeUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Solider(int age,String name, String backetCase, String unitName) {
        this.changeAge(age);
        this.changeName(name);
        this.changeBacketCase(backetCase);
        this.changeUnitName(unitName);
    }
}
