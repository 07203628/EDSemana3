public class App {

// Calcula el n-ésimo número de Fibonacci usando recursión.

    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser mayor o igual a cero");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

// Determina si puede alcanzarse el objetivo incluyendo o excluyendo cada elemento.

    public static boolean subsetSum(int[] numbers, int target) {
        return subsetSum(numbers, numbers.length, target);
    }

    private static boolean subsetSum(int[] numbers, int size, int target) {
        if (target == 0) {
            return true;
        }
        if (size == 0) {
            return false;
        }

        return subsetSum(numbers, size - 1, target)
                || subsetSum(numbers, size - 1, target - numbers[size - 1]);
    }

// Resuelve el tablero probando valores validos y retrocediendo cuando una eleccion falla.

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 0) {
                    for (int value = 1; value <= 9; value++) {
                        if (isValid(board, row, column, value)) {
                            board[row][column] = value;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][column] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int column, int value) {
        for (int index = 0; index < 9; index++) {
            if (board[row][index] == value || board[index][column] == value) {
                return false;
            }
        }

        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for (int currentRow = boxRow; currentRow < boxRow + 3; currentRow++) {
            for (int currentColumn = boxColumn; currentColumn < boxColumn + 3; currentColumn++) {
                if (board[currentRow][currentColumn] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(10): " + fibonacci(10));

        int[] numbers = {3, 34, 4, 12, 5, 2};
        System.out.println("Subset Sum (objetivo 9): " + subsetSum(numbers, 9));

        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Sudoku resuelto:");
        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("El Sudoku no tiene solucion.");
        }
    }
}
