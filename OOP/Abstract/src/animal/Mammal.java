package animal;

public abstract class Mammal extends Animal {

    private AnimalGender gender;
    public Mammal(){
        super();
        this.gender = AnimalGender.MALE;

    }
    public Mammal(String mammalName, float weight, AnimalGender gender){
        super(mammalName,weight);
        this.gender = gender;
    }

    public AnimalGender gender(){
        return this.gender;
    }
    public void changeGender(AnimalGender gender){
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        return (((super.equals(obj))) && (this.gender() == ((Mammal) obj).gender()));
    }
}
