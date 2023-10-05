public class Tiger extends Cat{


    public Tiger(String animalName, int moustache) {
        super(animalName, moustache);
    }

    @Override
    public void speak(){
        System.out.println("The tiger " + this.name() + ": grrrr grrrr grrrr");
    }



}
