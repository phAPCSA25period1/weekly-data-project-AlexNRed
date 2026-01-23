

/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 */
public class WeeklyData {



    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    // TODO: Declare a private array to store the week’s data
    //       Choose an appropriate type (double[] or int[])
    //       Create other instance variables as necessary

    private int[] data;
    private int length;



    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     */
    public WeeklyData(int[] input) {
        // TODO: (Optional) Check if input is null and handle appropriately
        // TODO: Create a new array with the same length as input
        // TODO: Copy each value from input into the internal data array
        // NOTE: Do NOT do this.data = input; (that would create aliasing)
        this.length = input.length;
        this.data = new int[length];
        for (int i = 0; i < length; i++) {
            this.data[i] = (int) input[i];
        }
    }

    public String compareWeeks(WeeklyData otherWeek) {
        if (this.getTotal() > otherWeek.getTotal()) {
            return "Current week has more total data.";
        } else if (this.getTotal() < otherWeek.getTotal()) {
            return "Other week has more total data.";
        } else {
            return "Both weeks have the same total data.";
        }
    }


    public boolean completeGoal(int goal) {
        if (getTotal() <= goal) {
            return true;
        } else {
            return false;
        }
    }

    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        // TODO: Create a variable to store the running total
        double total = 0.0;
        // TODO: Use a loop to add each value in the array to the total
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        // TODO: Return the total
        return total; // replace with your calculated total
    }   


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        double sum = getTotal();
        double average = sum / data.length;
        // TODO: If the array length is 0, return 0.0
        // TODO: Otherwise, divide the total by the number of elements
        // Hint: You may call getTotal()
        return average; // replace with your calculated average
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        // TODO: Assume the first value is the current maximum
        // TODO: Loop through the rest of the array and update max as needed
        // TODO: Return the maximum value found
        return max; // replace with the maximum value
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < data.length; x++) {
            if (data[x] < min) {
                min = data[x];
            }
        }
        // TODO: Assume the first value is the current minimum
        // TODO: Loop through the rest of the array and update min as needed
        // TODO: Return the minimum value found
        return min; // replace with the minimum value
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day’s data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week’s data
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append("Day ").append(i + 1).append(": ").append(data[i]).append("\n");
        }
        // TODO: Create a StringBuilder
        // TODO: Loop through the data array
        // TODO: Append each value with a day label (Day 1, Day 2, etc.)
        // TODO: Return the completed String
        return sb.toString(); // replace with your formatted output
    }
}

class Week {
    private int weekNumber;
    private double data; // Example metric, can be modified as needed

    public Week(int weekNumber, double data) {
        this.weekNumber = weekNumber;
        this.data = data;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public double getData() {
        return data;
    }
}
