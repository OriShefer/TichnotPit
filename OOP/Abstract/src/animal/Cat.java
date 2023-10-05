package animal;

public class Cat extends Mammal {

    private float milkPercentage;
    public Cat(){
        super();
        this.milkPercentage = 0;
    }
    public Cat (String catName, float weight, AnimalGender gender, float milkPercentage){
        super(catName, weight, gender);
        this.milkPercentage = milkPercentage;
    }
    public float milkPercentage(){
        return this.milkPercentage;
    }
    public void changeMilkPercentage(float milkPercentage){
        this.milkPercentage = milkPercentage;
    }
    @Override
    public void eat(){
        super.eat();
        super.changeWeight(super.weight() + super.weight() * this.milkPercentage());
    }

    @Override
    public void sound(){
        System.out.println("Miau Miau!!!");
    }

    @Override
    public boolean equals(Object obj) {
        return ((super.equals(obj)) && (this.milkPercentage() == ((Cat) obj).milkPercentage()));
    }
}
