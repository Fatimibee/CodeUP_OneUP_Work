import java.util.Scanner;

public class MainGameMenu {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        while (true) {
            System.out.println("\n🎯 Select a Game to Play:");
            System.out.println("1  Cricket Game");
            System.out.println("2  2048 Game");
            System.out.println("3  Exit");
            System.out.print("Enter your choice: ");

            int choice = scannerObject.nextInt();
            scannerObject.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    CricketGame.startCricketGame();
                    break;
                case 2:
                    Game2048.start2048();
                    break;
                case 3:
                    System.out.println("Goodbye 👋");
                    scannerObject.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
