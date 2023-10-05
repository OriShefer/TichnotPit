public class Cat extends Animal{

    private int moustache;

    public Cat(String animalName, int moustache){
        super(animalName);
        this.moustache = moustache;
    }

    public int moustache() {
        return moustache;
    }

    public void changeMoustache(int moustache) {
        this.moustache = moustache;
    }

    public void eatAMouse(){
        super.eat();
        System.out.printf("I ate a mouse, Now my hunger level is %s",super.hunger());
    }
}
