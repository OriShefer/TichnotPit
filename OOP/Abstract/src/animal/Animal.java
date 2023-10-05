package animal;

public abstract class Animal {
    private String name;
    private float weight;
    public Animal(){
        this.name = "";
        this.weight = 0;
    }
    public Animal(String animal, float weight){
        this.name = animal;
        this.weight = weight;
    }
    public String name(){
        return this.name;
    }
    public float weight(){
        return this.weight;
    }
    public void changeName(String name){
        this.name = name;
    }
    public void changeWeight(float weight){
        this.weight = weight;
    }
    public void eat(){
        this.changeWeight(this.weight() * 2);
    }
    public abstract void sound();

    @Override
    public boolean equals(Object obj) {
        boolean isValid = true;

        if ((obj == null) || (this.getClass() != obj.getClass())) {
            isValid = false;
        } else if (this != obj) {
            Animal amlAnimal = (Animal) obj;

            isValid = ((this.name() == amlAnimal.name()) && (this.weight() == amlAnimal.weight()));
        }

        return (isValid);
    }
}