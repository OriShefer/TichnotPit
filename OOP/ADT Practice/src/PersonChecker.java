public class PersonChecker {
    public static void main(String[] args) {


        Person noga = new Person("noga", "cohen", 12, "baking, surfing, dancing");

        //Testing the first name setter method.
        noga.changeFirstName("Noa");
        System.out.println("Checking the first name setter method");
        System.out.println("=============================");
        System.out.println("		Wanted result: Noa cohen, 12, hobbies: baking, surfing, dancing");
        System.out.print  ("		Actual result: ");
        noga.print();
        System.out.println();
        System.out.println();
        System.out.println();

        //Testing the last name setter method.
        noga.changeLastName("simchi");
        System.out.println("Checking the last name setter method");
        System.out.println("=============================");
        System.out.println("		Wanted result: Noa simchi, 12, hobbies: baking, surfing, dancing");
        System.out.print  ("		Actual result: ");
        noga.print();
        System.out.println();
        System.out.println();
        System.out.println();

        //Testing the age setter method.
        noga.changeAge(19);
        System.out.println("Checking the age setter method");
        System.out.println("=============================");
        System.out.println("		Wanted result: Noa simchi, 19, hobbies: baking, surfing, dancing");
        System.out.print  ("		Actual result: ");
        noga.print();
        System.out.println();
        System.out.println();
        System.out.println();

        //Testing the hobbies setter method.
        noga.changeHobbies("Reading, Coding");
        System.out.println("Checking the hobbies setter method");
        System.out.println("=============================");
        System.out.println("		Wanted result: Noa simchi, 19, hobbies: Reading, Coding");
        System.out.print  ("		Actual result: ");
        noga.print();
        System.out.println();
        System.out.println();
        System.out.println();

        //Testing equals.
        Person noa = new Person("Noa", "simchi", 19, "Reading, Coding");

        System.out.println("Checking equals method");
        System.out.println("=============================");
        System.out.println("		Wanted result: true");
        System.out.print  ("		Actual result: " + noga.equals(noa));
        System.out.println();
        System.out.println();
        System.out.println();

        //Testing doesHobbyExist.
        System.out.println("Checking doesHobbyExist method");
        System.out.println("=============================");
        System.out.println("		Wanted result: false");
        System.out.print  ("		Actual result: " + noa.doesHobbyExist("baking"));
        System.out.println();
        System.out.println();
        System.out.println();


        //Testing addHobby
        noa.addHobby("hiking");
        System.out.println("Checking addHobby");
        System.out.println("=============================");
        System.out.println("		Wanted result: noa simchi, 19, hobbies: reading, coding, hiking");
        System.out.print  ("		Actual result: ");
        noa.print();
        System.out.println();
        System.out.println();

        //Testing correctHobby
        noa.correctHobby();
        System.out.println("Checking correctHobby");
        System.out.println("=============================");
        System.out.println("		Wanted result: noa simchi, 19, hobbies: beading, coding, hiking");
        System.out.print  ("		Actual result: ");
        noa.print();
        System.out.println();
        System.out.println();

        //Testing initials
        System.out.println("Checking initials");
        System.out.println("=============================");
        System.out.println("		Wanted result: N.S");
        System.out.print  ("		Actual result: " + noa.initials());
        System.out.println();
        System.out.println();

        //Testing updateMarriedName
        Person lihi = new Person("lihi", "zohar", 19, "gardening, crocheting");

        System.out.println("Checking updateMarriedName");
        System.out.println("=============================");
        noa.updateMarriedName(lihi); //spouse's name comes before alphabetically
        System.out.println("Wanted result: noa zohar, lihi zohar");
        System.out.println  ("Actual result: " + noa.fullName() + ", " + lihi.fullName() );
        

    }
}
