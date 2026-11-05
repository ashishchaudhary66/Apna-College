
import java.util.*;

class Main {

    public static void main(String[] args) {

        SudokuGenerator generator = new SudokuGenerator();

        // Generate puzzle with 40 empty cells
        int[][] sudoku = generator.generateSudoku(40);

        generator.printBoard(sudoku);

        SudokuSolver solver = new SudokuSolver();

        boolean isSolved = solver.Sudoku(sudoku, 0, 0);

        if(isSolved){
            System.out.println();
            System.out.println("------- Soved -------");
            System.out.println();
            generator.printBoard(sudoku);
        }
        else{
            System.out.println("------- Not Soved --------");
        }
    }

    static class SudokuSolver{

        // Sudoku Solve
       public static boolean Sudoku(int[][] grid, int row, int col) {

            int n = grid.length;
    
            // All rows completed
            if (row == n) {
                return true;
            }
    
            // Calculate next cell
            int nextRow = row;
            int nextCol = col + 1;
    
            if (nextCol == n) {
                nextRow++;
                nextCol = 0;
            }
    
            // Skip already filled cells
            if (grid[row][col] != 0) {
                return Sudoku(grid, nextRow, nextCol);
            }
    
            // Try numbers from 1 to 9
            for (int num = 1; num <= n; num++) {
    
                if (isSafe(grid, row, col, num)) {
    
                    grid[row][col] = num;
    
                    if (Sudoku(grid, nextRow, nextCol)) {
                        return true;
                    }
    
                    // Backtracking
                    grid[row][col] = 0;
                }
            }
    
            return false;
        }

        
        // Helper method
        private static boolean isSafe(int[][] grid, int i, int j, int num){
            // Horizontal
            for(int col = 0; col<grid.length; col++){
                if(grid[i][col] == num){
                    return false;
                }
            }
            
            // Vertical
            for(int row = 0; row<grid.length; row++){
                if(grid[row][j] == num){
                    return false;
                }
            }
            
            // partial grid
            int[] initialIndex = getPartialGridIndex(i, j);
            int row = initialIndex[0];
            int col = initialIndex[1];
            for(int ii = 0; ii < 3; ii++){
                for(int jj = 0; jj < 3; jj++){
                    if(grid[row+ii][col+jj] == num){
                        return false;
                    }
                }
            }

            return true;
        }

        // for 9 * 9
        private static int[] getPartialGridIndex(int i, int j){
            int row = i - (i%3);
            int col = j - (j%3);

            return new int[]{row, col};
        }
    }
    
    // Sudoku Generator
    static class SudokuGenerator {

        private final int[][] board = new int[9][9];
        private final Random random = new Random();

        // Generate a Sudoku puzzle
        public int[][] generateSudoku(int cellsToRemove) {

            if (cellsToRemove < 0 || cellsToRemove > 81) {
                throw new IllegalArgumentException(
                    "Cells to remove must be between 0 and 81"
                );
            }

            for (int[] row : board) {
                Arrays.fill(row, 0);
            }

            // Generate complete Sudoku solution
            fillBoard();

            // Remove random cells
            int removed = 0;

            while (removed < cellsToRemove) {

                int row = random.nextInt(9);
                int col = random.nextInt(9);

                if (board[row][col] != 0) {
                    board[row][col] = 0;
                    removed++;
                }
            }

            // Return a copy
            int[][] result = new int[9][9];

            for (int i = 0; i < 9; i++) {
                result[i] = board[i].clone();
            }

            return result;
        }

        // Fill Sudoku board using backtracking
        private boolean fillBoard() {

            for (int row = 0; row < 9; row++) {

                for (int col = 0; col < 9; col++) {

                    if (board[row][col] == 0) {

                        int[] numbers = {
                            1, 2, 3, 4, 5, 6, 7, 8, 9
                        };

                        shuffle(numbers);

                        for (int num : numbers) {

                            if (isSafe(row, col, num)) {

                                board[row][col] = num;

                                if (fillBoard()) {
                                    return true;
                                }

                                // Backtracking
                                board[row][col] = 0;
                            }
                        }

                        return false;
                    }
                }
            }

            return true;
        }

        // Check row, column and 3x3 box
        private boolean isSafe(int row, int col, int num) {

            for (int i = 0; i < 9; i++) {

                if (board[row][i] == num ||
                    board[i][col] == num) {
                    return false;
                }
            }

            int startRow = row - row % 3;
            int startCol = col - col % 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board[startRow + i][startCol + j] == num) {
                        return false;
                    }
                }
            }

            return true;
        }

        // Shuffle numbers randomly
        private void shuffle(int[] numbers) {

            for (int i = numbers.length - 1; i > 0; i--) {

                int j = random.nextInt(i + 1);

                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        // Print Sudoku board
        public void printBoard(int[][] sudoku) {

            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {

                    System.out.print(sudoku[i][j] + " ");

                    if ((j + 1) % 3 == 0 && j != 8) {
                        System.out.print("| ");
                    }
                }

                System.out.println();

                if ((i + 1) % 3 == 0 && i != 8) {
                    System.out.println("---------------------");
                }
            }
        }
    }
}
