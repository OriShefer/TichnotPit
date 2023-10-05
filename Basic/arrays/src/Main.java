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

    //4
    public static void arr2InArr1(){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {8};
        boolean inside = true;
        int j = 0;

        for (int i = 0; i < arr1.length; i++){
            if(arr1[i] == arr2[j]){
                j++;

            }else{
                j=0;
            }

            if(j == arr2.length - 1){
                System.out.println("yes");
                break;
            }
        }

    }

    //6
    public static int closeToAvg(){
        int[] arr = {2,4,9,1,5,3,8,1};
        int sum = 0;

        for(int num : arr){
            sum+=num;
        }
        float avg = (float)sum / arr.length;

        double minDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if(Math.abs(arr[i] - avg) < minDiff){
                minDiff = Math.abs(arr[i] - avg);
                result = i;
            }
        }
        return result;

    }

    //6
    public static int longestSeries(){
        int[] arr = {6,4,5,1,2,-1,0,1};
        int indexOfSeries = -1;
        int lengthOfSeries = 1;
        int maxIndexOfSeries =-1;
        int maxLength = 0;
        boolean startedSeries = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] > arr[i]){
                if(startedSeries){
                    indexOfSeries = i;
                    startedSeries = false;
                }
                lengthOfSeries ++;

            }else{
                if(lengthOfSeries > maxLength){
                    maxLength = lengthOfSeries;
                    maxIndexOfSeries = indexOfSeries;
                }
                startedSeries = true;
                lengthOfSeries = 1;

            }
        }

        if(lengthOfSeries > maxLength)
            maxIndexOfSeries = indexOfSeries;


        return maxIndexOfSeries;

    }


    //9
    public static void moveArrRight(int step){
        int[] arr = {1,2,3,4};
        for (int i = 0; i < step; i++)
            moveArrRightSingleStep(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ",");

    }

    public static void moveArrRightSingleStep(int[] arr)
    {
        for (int i = arr.length - 1; i > 0; i--){
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
        }
    }




    public static void main(String[] args) {

        moveArrRight(5);
    }
}