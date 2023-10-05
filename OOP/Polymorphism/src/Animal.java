public class Animal {
  private String name;
  private int age;
  private int hunger;

  public Animal(String animalName) {
	this.changeName(animalName);  	
  	this.changeAge(0);
	this.changeHunger(0);
  }
  
  public String name() {
		return this.name;
  }
  
  public void changeName(String name) {
		this.name = name;
  }
  
  private void changeAge(int age){
    this.age = age;
  }
  
  private void changeHunger(int hungerLevel){
    this.hunger = hungerLevel;
  }
  
  public int age() {
		return this.age;
  }
  
  public int hunger() {
		return this.hunger;
  }
  
  public void haveABirthday() {
	this.changeAge(this.age() + 1);

	System.out.println("I had a birthday! i am " + this.age() + " years old");
  }
  
  protected void eat() {
	this.changeHunger(this.hunger() + 1);
  }

    public void speak(){
        System.out.println("Animal is speaking");
    }

    public void sleep(){
        System.out.println(this.name() + " is sleeping");
    }

    public void wakeUp(){
        System.out.println(this.name() + " is awake");
    }

}


