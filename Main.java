/**
 * @filename - Main.java
 * @description - This is the main file which contains the main function 
 *                and menu to call different functions of MyString class.
 * @author - Fatimi Bee
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);

        try {
            // String input
            System.out.println("Enter a String:");
            String str = scannerObj.nextLine();

            MyString objMyString = new MyString(str);

            // menu
            System.out.println("Choices:");
            System.out.println(" 1. Append a string"
                    + "\n 2. Count words"
                    + "\n 3. Replace"
                    + "\n 4. Is palindrome"
                    + "\n 5. Splice"
                    + "\n 6. Split"
                    + "\n 7. Max Repeating Character"
                    + "\n 8. Sort"
                    + "\n 9. Shift"
                    + "\n 10. Reverse"
                    + "\n 11. Exit");

            // choice enter
            System.out.println("Enter your choice:");
            int choice = scannerObj.nextInt();
            scannerObj.nextLine(); // consume newline

            // calling function based on user choice
            switch (choice) {

                case 1:
                    System.out.println("Enter a string to append:");
                    String append_str = scannerObj.nextLine();
                    String ans = objMyString.appendFunc(append_str);
                    System.out.println("Result after appending: " + ans);
                    break;

                case 2:
                    int words = objMyString.count();
                    System.out.println("Number of words in String: " + words);
                    break;

                case 3:
                    System.out.println("Enter old character: ");
                    char oldChar = scannerObj.next().charAt(0);
                    System.out.println("Enter new character: ");
                    char newChar = scannerObj.next().charAt(0);
                    objMyString.replaceFunc(oldChar, newChar);
                    System.out.println("Result after replacing: " + objMyString.value);
                    break;

                case 4:
                    boolean isPal = objMyString.isPalindrom();
                    if (isPal) {
                        System.out.println("String is palindrome");
                    } else {
                        System.out.println("String is not palindrome");
                    }
                    break;

                case 5:
                    System.out.println("Enter start index:");
                    int start = scannerObj.nextInt();
                    System.out.println("Enter length of splice:");
                    int length = scannerObj.nextInt();
                    String spliced = objMyString.spliceFunc(start, length);
                    System.out.println("Result after splicing: " + spliced);
                    break;

                case 6:
                    System.out.println("Enter pattern to split:");
                    String pattern_Str = scannerObj.nextLine();
                    objMyString.splitFunc(pattern_Str);
                    break;

                case 7:
                    objMyString.getMaxRepeatingChar();
                    break;

                case 8:
                    String sorted = objMyString.sortFunc();
                    System.out.println("Result after sorting: " + sorted);
                    break;

                case 9:
                    System.out.println("Enter number of elements to shift at end:");
                    int n = scannerObj.nextInt();
                    String shifted = objMyString.shiftFunc(n);
                    System.out.println("Result after shifting: " + shifted);
                    break;

                case 10:
                    String reversed = objMyString.reverseFunc();
                    System.out.println("Result after reversing: " + reversed);
                    break;

                case 11:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("You entered an invalid choice");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number for your choice.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scannerObj.close();
        }
    }
}
