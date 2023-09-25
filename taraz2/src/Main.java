import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }
    public static String subStringUntilFirstInt(String str){
        String newStr = "";
        for (char c : str.toCharArray()) {
            if(!Character.isDigit(c)){
                newStr+=c;
            }else{
                return newStr;
            }
        }
        return newStr;
    }

    public static void initializeRoads(String[] roadsNames, int[] roadsLength,Double[] roadsTime){

        for (int i = 0; i < roadsNames.length; i++) {
            String input = getInput("Please enter the name coding for road #" + (i+1));
            input = input.toLowerCase();

            while(input.contains("-") || input.contains(".")){
                input = getInput("Please enter the name coding for road #" + (i+1) +"again with a positing and complete number of length and avg speed");
                input = input.toLowerCase();
            }


            roadsNames[i] = subStringUntilFirstInt(input);
            roadsLength[i] = Integer.parseInt(input.substring(roadsNames[i].length(), input.length() - 2));
            roadsTime[i] = (double) roadsLength[i] / Integer.parseInt(input.substring(input.length() - 2));

        }
    }

    public static void sortRoads(String[] roadNames, int[] roadsLength, Double[] roadsTime) {
        boolean swapped = true;

        for (int roadsIndex = 0; roadsIndex < roadNames.length && swapped; roadsIndex++) {
            swapped = false;

            for (int currentRoadName = 0; currentRoadName < roadNames.length - roadsIndex - 1; currentRoadName++) {
                if (roadNames[currentRoadName].compareTo(roadNames[currentRoadName + 1]) > 0) {
                    swapRoads(roadNames, roadsLength, roadsTime, currentRoadName, currentRoadName + 1);
                    swapped = true;
                }
            }
        }
    }

    public static void swapRoads(String[] roadNames, int[] roadsLength, Double[] roadsTime, int firstRoadIndex, int secondRoadIndex) {
        String tempName = roadNames[firstRoadIndex];
        Double tempTime = roadsTime[firstRoadIndex];
        int tempLength = roadsLength[firstRoadIndex];

        roadNames[firstRoadIndex] = roadNames[secondRoadIndex];
        roadsTime[firstRoadIndex] = roadsTime[secondRoadIndex];
        roadsLength[firstRoadIndex] = roadsLength[secondRoadIndex];

        roadNames[secondRoadIndex] = tempName;
        roadsTime[secondRoadIndex] = tempTime;
        roadsLength[secondRoadIndex] = tempLength;
    }

    private static int findRouteIndex(String[] roadNames, int minIndex, int maxIndex,String roadName){
        int currentIndex = (minIndex + maxIndex) / 2;

        if(minIndex > maxIndex)
            return -1;

        if(roadNames[currentIndex].compareTo(roadName) == 0)
            return currentIndex;

        if (roadNames[currentIndex].compareTo(roadName) > 0) {
            return findRouteIndex(roadNames,minIndex,maxIndex - 1,roadName);
        }

        if (roadNames[currentIndex].compareTo(roadName) < 0) {
            return findRouteIndex(roadNames,minIndex + 1,maxIndex,roadName);
        }

        return -1;

    }

    public static int findRouteIndex(String[] roadNames, String roadName){
        return findRouteIndex(roadNames, 0 , roadNames.length - 1, roadName);
    }



    public static void main(String[] args) {

        final int NUM_OF_ROADS = 6;
        final int BEST_DISTANCE_CODE = 1;
        final int BEST_TIME_CODE = 2;
        final int NUM_OF_ROADS_IN_ROUTE = 3;

        String[] roadsNames = new String[NUM_OF_ROADS];
        int[] roadsLength = new int[NUM_OF_ROADS];
        Double[] roadsTime = new Double[NUM_OF_ROADS];

        initializeRoads(roadsNames, roadsLength, roadsTime);
        sortRoads(roadsNames, roadsLength, roadsTime);

        System.out.println(Arrays.toString(roadsNames));
        System.out.println(Arrays.toString(roadsLength));
        System.out.println(Arrays.toString(roadsTime));

        int amount = Integer.parseInt(getInput("Enter the amount of routes for comparison:"));

        int userChoice = Integer.parseInt(getInput("What do you want to check?\n"
                + BEST_DISTANCE_CODE + ". preferred length\n"
                + BEST_TIME_CODE + ". preferred time"));
        int bestResult = Integer.MAX_VALUE;
        String bestRoute = "";

        for (int i = 0; i < amount; i++) {
            System.out.println("Route "+(i+1));
            String currentRoute = "";
            int currentResult = Integer.MAX_VALUE;

            for (int j = 0; j < NUM_OF_ROADS_IN_ROUTE; j++) {
                String road = getInput("Enter road #"+ (j+1));
                int index = findRouteIndex(roadsNames,road);

                if(index != -1 && userChoice == BEST_DISTANCE_CODE){
                    currentResult += roadsLength[index];
                    currentRoute += road + ",";
                }

                if(index != -1 && userChoice == BEST_TIME_CODE){
                    currentResult += roadsTime[index];
                    currentRoute += road + ",";

                }

            }

            if(currentResult <= bestResult){
                bestResult = currentResult;
                bestRoute = currentRoute;
            }
        }

        System.out.println("Best route is:\n" + bestRoute);





    }
}