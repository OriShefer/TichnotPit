public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("ori",3);
        Dog dog = new Dog("toto");

        System.out.println(cat.hunger());
        cat.eatAMouse();
        cat.changeName("lolo");
        System.out.println(dog.age());
        dog.haveABirthday();
        dog.bark();



    }
}