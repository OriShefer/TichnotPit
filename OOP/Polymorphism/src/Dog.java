public class Dog extends Animal {
	public Dog(String animalName) {
		super(animalName);
	}

	@Override
	public void speak(){
		System.out.println("The dog " + this.name() + ": woof woof woof");
	}
}
