
import java.util.Random;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {

        SudokuGenerator generator = new SudokuGenerator();

        // Generate puzzle with 40 empty cells
        int[][] sudoku = generator.generateSudoku(40);

        generator.printBoard(sudoku);
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
