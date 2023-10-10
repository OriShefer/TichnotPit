public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.signIn(new Solider(18,"ori","22","shahar"));
        clinic.signIn(new Solider(18,"ori2","This backet case is very very critical","shahar"));
        clinic.signIn(new Solider(18,"ori3","1","shahar"));
        clinic.signIn(new Solider(18,"ori4","4444","shahar"));

        clinic.signIn(new Citizen(40,"ori","22","google"));
        clinic.signIn(new Citizen(40,"ori2","333","google"));
        clinic.signIn(new Citizen(40,"ori3","This backet case is very very very very critical","google"));
        clinic.signIn(new Citizen(40,"ori4","This backet case is very very very critical","google"));
        clinic.signIn(new Citizen(40,"ori5","This backet case is very critical","google"));


        clinic.sortCritical();
        clinic.printClinic();
        clinic.runClinic();

    }
}