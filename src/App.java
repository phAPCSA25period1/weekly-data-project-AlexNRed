import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {
    private WeeklyData weeklyData;

    public App() {
        weeklyData = new WeeklyData();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Weekly Data Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel weekLabel = new JLabel("Week Number:");
        weekLabel.setBounds(10, 20, 80, 25);
        panel.add(weekLabel);

        JTextField weekText = new JTextField(20);
        weekText.setBounds(150, 20, 165, 25);
        panel.add(weekText);

        JLabel dataLabel = new JLabel("Data:");
        dataLabel.setBounds(10, 50, 80, 25);
        panel.add(dataLabel);

        JTextField dataText = new JTextField(20);
        dataText.setBounds(150, 50, 165, 25);
        panel.add(dataText);

        JButton addButton = new JButton("Add Week");
        addButton.setBounds(10, 80, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int weekNumber = Integer.parseInt(weekText.getText());
                double data = Double.parseDouble(dataText.getText());
                weeklyData.addWeek(new Week(weekNumber, data));
                JOptionPane.showMessageDialog(null, "Week added!");
            }
        });
        
        JButton graphButton = new JButton("Show Graph");
        graphButton.setBounds(10, 110, 150, 25);
        panel.add(graphButton);

        graphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame graphFrame = new JFrame("Graph");
                graphFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                graphFrame.add(new GraphPanel(weeklyData));
                graphFrame.pack();
                graphFrame.setVisible(true);
            }
        });
    }

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
        boolean isRunning = true;
        System.out.println("This program will help you track your daily screen time for a week.");
        System.out.println("What is a reasonable Weekly screen time goal for you (in hours: ex. 5, 10, 15)?");
        int weeklyGoal = scan.nextInt();

        // Collect data for the week
        while (isRunning) {
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
                displayResults(weekData, weeklyGoal);
            }
        }  
        // Create the WeeklyData object with the collected data
        WeeklyData weekData = new WeeklyData(dailyData);

        // Display the results
        public void displayResults(WeeklyData weekData , int weeklyGoal) {
            System.out.println("Here is your screen time data for the week:");
            System.out.println(weekData.toString());
            System.out.println("Total screen time for the week: " + weekData.getTotal() + " hours");
            System.out.println("Average daily screen time: " + weekData.getAverage() + " hours");
            System.out.println("Maximum screen time in a day: " + weekData.getMax() + " hours");
            System.out.println("Minimum screen time in a day: " + weekData.getMin() + " hours");
            System.out.println("Your weekly screen time goal was: " + weeklyGoal + " hours");
            System.out.println("Did you meet your goal: " + weekData.completeGoal(weeklyGoal));
        }

        // Close scanner and exit
        scan.close();
    }
}
