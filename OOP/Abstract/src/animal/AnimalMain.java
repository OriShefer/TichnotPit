package animal;
import java.util.ArrayList;

public class AnimalMain {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog("Dingo", 12, AnimalGender.MALE, 24));
        animals.add(new Cat("Smifty", 15, AnimalGender.MALE, (float) 0.6));
        animals.add(new Dog("Lassy", 9, AnimalGender.FEMALE, 2));

        System.out.println("Animals Weight Before Eating");
        System.out.println(" --------------------------");

        for (Animal currAnimal : animals) {
            System.out.println(currAnimal.name() + ":");
            System.out.println("------------");
            System.out.println("Weight before eating: " + currAnimal.weight());
            currAnimal.eat();
            System.out.println("Weight after eating: " + currAnimal.weight());
            System.out.println("Sound: ");
            currAnimal.sound();
            System.out.println();
        }
    }
}