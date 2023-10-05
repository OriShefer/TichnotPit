import java.util.ArrayList;

public class SafariMain {

        public static void main(String[] args) {

            ArrayList<Animal> animals = new ArrayList<Animal>();

            animals.add(new Cat("cat",1));
            animals.add(new Dog("dog"));
            animals.add(new Sheep("sheep"));
            animals.add(new Tiger("tiger",2));

            for(Animal animal : animals){
                animal.sleep();
            }

            for(Animal animal : animals){
                animal.wakeUp();
            }
            System.out.println();

            for(Animal animal : animals){
                if(animal instanceof Tiger)
                    animal.haveABirthday();
            }
            System.out.println();

            for(Animal animal : animals){
                animal.speak();
            }
            System.out.println();

            for(Animal animal : animals){
                if(!(animal instanceof Sheep))
                    animal.sleep();
            }

        }
    }

