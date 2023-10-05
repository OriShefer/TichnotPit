public class Sheep extends Animal {

    public Sheep(String animalName) {
        super(animalName);
    }

    @Override
    public void speak(){
        System.out.println("The sheep " + this.name() + ": meee meee meee");
    }


}
