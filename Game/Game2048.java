import java.util.*;

public class Game2048 {
    static int SIZE = 4;
    static int[][] board = new int[SIZE][SIZE];
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void start2048() {
        System.out.println("🎮 Welcome to 2048 Game (Console Version)!");
        addNewTile();
        addNewTile();

        while (true) {
            printBoard();
            System.out.println("Use W (Up), S (Down), A (Left), D (Right) — or Q to Quit");
            char move = sc.next().toUpperCase().charAt(0);

            if (move == 'Q') {
                System.out.println("Thanks for playing!");
                break;
            }

            boolean moved = false;
            switch (move) {
                case 'W': moved = moveUp(); break;
                case 'S': moved = moveDown(); break;
                case 'A': moved = moveLeft(); break;
                case 'D': moved = moveRight(); break;
                default: System.out.println("Invalid key! Use W/A/S/D."); continue;
            }

            if (moved) addNewTile();
            if (isGameOver()) {
                printBoard();
                System.out.println("Game Over! No more moves possible.");
                break;
            }
        }
    }

    static void printBoard() {
        System.out.println("\n-----------------------------");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0)
                    System.out.print("|     ");
                else
                    System.out.printf("|%4d ", board[i][j]);
            }
            System.out.println("|");
            System.out.println("-----------------------------");
        }
    }

    static void addNewTile() {
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == 0)
                    empty.add(new int[]{i, j});

        if (empty.isEmpty()) return;
        int[] pos = empty.get(rand.nextInt(empty.size()));
        board[pos[0]][pos[1]] = rand.nextInt(10) == 0 ? 4 : 2;
    }

    static boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int[] row = new int[SIZE];
            int index = 0;
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] != 0)
                    row[index++] = board[i][j];
            for (int j = 0; j < SIZE - 1; j++)
                if (row[j] != 0 && row[j] == row[j + 1]) {
                    row[j] *= 2;
                    row[j + 1] = 0;
                }
            int[] newRow = new int[SIZE];
            index = 0;
            for (int j = 0; j < SIZE; j++)
                if (row[j] != 0)
                    newRow[index++] = row[j];
            if (!Arrays.equals(board[i], newRow)) moved = true;
            board[i] = newRow;
        }
        return moved;
    }

    static boolean moveRight() {
        rotateBoard180();
        boolean moved = moveLeft();
        rotateBoard180();
        return moved;
    }

    static boolean moveUp() {
        rotateBoardCCW();
        boolean moved = moveLeft();
        rotateBoardCW();
        return moved;
    }

    static boolean moveDown() {
        rotateBoardCW();
        boolean moved = moveLeft();
        rotateBoardCCW();
        return moved;
    }

    static void rotateBoardCW() {
        int[][] temp = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                temp[j][SIZE - 1 - i] = board[i][j];
        board = temp;
    }

    static void rotateBoardCCW() {
        int[][] temp = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                temp[SIZE - 1 - j][i] = board[i][j];
        board = temp;
    }

    static void rotateBoard180() {
        rotateBoardCW();
        rotateBoardCW();
    }

    static boolean isGameOver() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == 0) return false;

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE - 1; j++)
                if (board[i][j] == board[i][j + 1]) return false;

        for (int j = 0; j < SIZE; j++)
            for (int i = 0; i < SIZE - 1; i++)
                if (board[i][j] == board[i + 1][j]) return false;

        return true;
    }
}
