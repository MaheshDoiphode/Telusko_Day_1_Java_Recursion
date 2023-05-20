package Assignment_1;
import java.util.HashMap;
import java.util.Map;

public class RecursiveMemoizationWay {
    // Create a memoization map to store calculated values
    private static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int numRows = 5; // Number of rows in Pascal's triangle
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(generate(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int generate(int row, int column) {
        // Create a unique key for the current position
        String key = row + "," + column;

        // Check if the value is already calculated and stored in the memoization map
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int value;
        if (column == 0 || column == row) {
            value = 1; // The first and last elements in each row are always 1
        } else {
            value = generate(row - 1, column - 1) + generate(row - 1, column);
            // To calculate any other element, we sum the elements above and to the left and right of it in the previous row
        }

        // Store the calculated value in the memoization map for future use
        memo.put(key, value);

        return value;
    }
}
