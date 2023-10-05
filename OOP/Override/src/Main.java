public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("z","orange1",20,false);
        Course course2 = new Course("h","orange2",30,false);
        Course course3 = new Course("t","orange3",50,true);

        System.out.println(course1);
        System.out.println(course1.equals("null"));
    }
}