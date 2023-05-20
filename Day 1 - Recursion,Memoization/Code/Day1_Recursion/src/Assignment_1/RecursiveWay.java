package Assignment_1;
// We start by creating our class called RecursiveWay
public class RecursiveWay {
    public static void main(String[] args) {
        int numRows = 5; // Number of rows in Pascal's triangle
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(generate(i, j) + " ");
            }
            System.out.println();
        }
    }

    // This is our recursive method to calculate the value at a specific position in Pascal's triangle
    public static int generate(int row, int column) {
        if (column == 0 || column == row) {
            return 1; // The first and last elements in each row are always 1
        } else {
            return generate(row - 1, column - 1) + generate(row - 1, column);
            // To calculate any other element, we sum the elements above and to the left and right of it in the previous row
        }
    }
}
