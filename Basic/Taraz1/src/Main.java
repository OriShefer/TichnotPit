import java.util.Scanner;

public class Main {

    //1
    public static void upside(){
        Scanner io = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            System.out.println("Enter num:");
            arr[i] = io.nextInt();
        }

        for (int i = arr.length - 1; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }

    //3
    public static void flipArr(){
        Scanner io = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};



        for (int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        for (int i : arr) {
            System.out.println(i);
        }

    }

    //3
    public static void flipArr(){
        Scanner io = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};



        for (int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        for (int i : arr) {
            System.out.println(i);
        }

    }




    public static void main(String[] args) {

        flipArr();
    }
}