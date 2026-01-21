import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        boolean isRunning = true;
        Scanner scan = new Scanner(System.in);
        int[] weekData = new int[7];

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("Welcome to the Weekly Screen Time Tracker");
        System.out.println("This program will help you track your daily screen time for a week.");
        System.out.println("What is a reasonable Weekly screen time goal for you (in hours: ex. 5, 10, 15)?");
        int dailyGoal = scan.nextInt();

        while (isRunning) {
            for (int i = 0; i < weekData.length; i++){
                System.out.println("Enter your screen time for the day " + (i + 1) + " (in hours: ex. 1,2,3):");
                int dailyScreenTime = scan.nextInt();

                if (!(dailyScreenTime instanceof Integer)){
                    System.out.println("Invalid input. Please enter a integer value for screen time.");
                }   

                if (dailyScreenTime < 0) {
                    System.out.println("Invalid input. You can not have a negative screen time.");
                    System.out.println("Please enter a valid screen time for day " + (i + 1) + ":");
                    dailyScreenTime = scan.nextInt();
                }
                weekData[i] = dailyScreenTime;
            }
            isRunning = false;
        }
        




        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------


        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------


        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------


        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------


        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------


        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------


    }
}
