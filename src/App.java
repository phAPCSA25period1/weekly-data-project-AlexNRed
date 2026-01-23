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
        
        Scanner scan = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("Welcome to the Weekly Screen Time Tracker");
    
        System.out.println("This program will help you track your daily screen time for a week.");
        System.out.println("What is a reasonable Weekly screen time goal for you (in hours: ex. 5, 10, 15)?");
        int weeklyGoal = scan.nextInt();

        // Collect data for the week
         
            int[] dailyData = new int[7];
            for (int i = 0; i < dailyData.length; i++) {
                System.out.println("Enter your screen time for the day " + (i + 1) + " (in hours: ex. 1,2,3):");
                int dailyScreenTime = scan.nextInt();

                // Basic validation (you can expand this)
                while (dailyScreenTime < 0) {
                    System.out.println("Invalid input. You cannot have negative screen time.");
                    System.out.println("Please enter a valid screen time for day " + (i + 1) + ":");
                    dailyScreenTime = scan.nextInt();
                }
                dailyData[i] = dailyScreenTime;
            }
        
        // Create the WeeklyData object with the collected data
        WeeklyData weekData = new WeeklyData(dailyData);

        // Display the results
        displayResults(weekData, weeklyGoal);

        // Close scanner and exit
        scan.close();
    }

    public static void displayResults(WeeklyData weekData, int weeklyGoal) {
        try {
            Thread.sleep(500); // Pause for half a second for better user experience
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Here is your screen time data for the week:");
        System.out.println(weekData.toString());
        System.out.println("Total screen time for the week: " + weekData.getTotal() + " hours");
        System.out.println("Average daily screen time: " + weekData.getAverage() + " hours");
        System.out.println("Maximum screen time in a day: " + weekData.getMax() + " hours");
        System.out.println("Minimum screen time in a day: " + weekData.getMin() + " hours");
        System.out.println("Your weekly screen time goal was: " + weeklyGoal + " hours");
        System.out.println("Did you meet your goal: " + weekData.completeGoal(weeklyGoal));
    }
}