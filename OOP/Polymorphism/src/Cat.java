public class Cat extends Animal {
	private int moustache;

	public Cat(String animalName, int moustache) {
		super(animalName);
                this.changeMoustache(moustache);
	}

	public int moustache() {
		return this.moustache;
	}

	public void changeMoustache(int moustache) {
		this.moustache = moustache;
	}
	
	public void eatAMouse() {
		super.eat();

		System.out.println("I ate a mouse. Now my hunger level is " +
            	super.hunger());
	}

	@Override
	public void speak(){
		System.out.println("The cat " + this.name() + ": meow meow meow");
	}
}
