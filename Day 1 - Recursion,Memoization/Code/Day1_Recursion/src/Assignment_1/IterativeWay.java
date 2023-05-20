package Assignment_1;
// We start by importing the necessary tools we need to write our program
import java.util.*;

// This is our main class named IterativeWay
public class IterativeWay {

    // Inside the main method, our program starts executing
    public static void main(String[] args) {
        // We use a loop to go through each row of Pascal's triangle
        // The number 5 represents the number of rows we want to generate
        // We print each row one by one
        for (List<Integer> row: generate(5)) {
            System.out.println(row);
        }
    }

    // This method called generate creates Pascal's triangle
    // It takes the number of rows we want to generate as input
    public static List<List<Integer>> generate(int numRows) {

        // We create an empty list to store all the rows of Pascal's triangle
        List<List<Integer>> triangle = new ArrayList();

        // We start generating each row one by one
        for(int i = 0; i < numRows; i++) {

            // We create an empty list to store the current row of Pascal's triangle
            List<Integer> currentRow = new ArrayList();

            // We fill the current row with zeros initially
            // The number of zeros we add is equal to the row number plus 1
            for(int j = 0; j < i + 1; j++) {
                currentRow.add(0);
            }

            // The first and last elements of each row are always 1
            // So, we set the first and last elements of the current row to 1
            currentRow.set(0, 1);
            currentRow.set(currentRow.size() - 1, 1);

            // For rows other than the first two rows,
            // we calculate the values based on the previous row
            if(i == 0 || i == 1) {
                triangle.add(currentRow);
                continue;
            }

            // We calculate the values of the current row using the values of the previous row
            // We start from the second element and go up to the second-to-last element of the current row
            // The value of an element is the sum of the corresponding elements from the previous row
            for(int j = 1; j <= i - 1; j++) {
                int element = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                currentRow.set(j, element);
            }

            // We have completed generating the current row, so we add it to our list of rows
            triangle.add(currentRow);
        }

        // Finally, we return the complete Pascal's triangle
        return triangle;
    }
}
