/**
 * @filename - Main.java
 * @description - This is the main file which contains the main function 
 * and a menu to call different functions of the MyOperation class.
 * @author - Fatimi Bee 
 */

import java.util.*;

public class MainOperation {

    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        int choice;

        MyOperation stringObj = null; // For string-based operations
        MyOperation numberObj = null; 

        // Loop until user chooses to exit
        
        while (true) {
            // Display menu
            System.out.println("\n========= MENU =========");
            System.out.println("1. Count Unique Palindromes");
            System.out.println("2. Fibonacci Sequence - Nth Number");
            System.out.println("3. Snake Case to Camel Case Conversion");
            System.out.println("4. Count Consonants in a String");
            System.out.println("5. Binary to Decimal Conversion");
            System.out.println("6. Characters in a String");
            System.out.println("7. Character Frequency in a String");
            System.out.println("8. Prime Number Checker");
            System.out.println("9. Number to Words Converter");
            System.out.println("10. Longest Substring Without Repeating Characters");
            System.out.println("11. Exit");
            System.out.println("=========================");
            System.out.print("Enter your choice: ");
        
            choice = scannerObj.nextInt();
            scannerObj.nextLine(); // consume newline

            // Handle inputs and object creation per chosen operation
            switch (choice) {
                case 1: {
                    System.out.print("Enter a string: ");
                    String strInput = scannerObj.nextLine();
                    stringObj = new MyOperation(strInput);

                    int count = stringObj.countUniquePalindromes();
                    System.out.println("Unique Palindromes Count: " + count);
                    break;
                }

                case 2: {
                    System.out.print("Enter N for Fibonacci: ");
                    int n = scannerObj.nextInt();
                    scannerObj.nextLine();
                    numberObj = new MyOperation(n);

                    int fib = numberObj.fibonacciNth();
                    System.out.println("The " + n + "th Fibonacci number is: " + fib);
                    break;
                }

                case 3: {
                    System.out.print("Enter a string: ");
                    String strInput = scannerObj.nextLine();
                    stringObj = new MyOperation(strInput);
                    String camelCase = stringObj.snakeToCamel();
                    System.out.println("Camel Case: " + camelCase);
                    break;
                }

                case 4: {
                    System.out.print("Enter a string: ");
                    String strInput = scannerObj.nextLine();
                    stringObj = new MyOperation(strInput);
                    int consonants = stringObj.countConsonants();
                    System.out.println("Number of consonants: " + consonants);
                    break;
                }

                case 5: {
                    System.out.print("Enter a binary number: ");
                    String binary = scannerObj.nextLine();
                    stringObj = new MyOperation(binary);
                    int decimal = stringObj.binaryToDecimal();
                    System.out.println("Decimal Value: " + decimal);
                    break;
                }

                case 6: {
                    System.out.print("Enter a string: ");
                    String strInput = scannerObj.nextLine();
                    stringObj = new MyOperation(strInput);
                    String outputString=stringObj.displayCharacters();
                    System.out.println("Characters in the string : " + outputString) ;
                    break;
                }

                case 7: {
                    System.out.print("Enter a string: ");
                    String strInput = scannerObj.nextLine();
                    stringObj = new MyOperation(strInput);
                    String outputString = stringObj.characterFrequencyCompressed();

                    System.out.println("Characters frequency in the string : " + outputString) ;
                    break;
                }

                case 8: {
                    System.out.print("Enter a number to check for prime: ");
                    int num = scannerObj.nextInt();
                    scannerObj.nextLine();
                    numberObj = new MyOperation(num);
                    boolean isPrime = numberObj.isPrime();
                    System.out.println(num + (isPrime ? " is a Prime Number." : " is not a Prime Number."));
                    break;
                }

                case 9: {
                    System.out.print("Enter a number to convert to words: ");
                    int number = scannerObj.nextInt();
                    scannerObj.nextLine();
                    numberObj = new MyOperation(number);
                    String words = numberObj.numberToWords();
                    System.out.println("Number in words: " + words);
                    break;
                }

                case 10: {
                    System.out.print("Enter a string: ");
                    String strInput = scannerObj.nextLine();
                    stringObj = new MyOperation(strInput);
                    int length = stringObj.longestSubstringWithoutRepeat();
                    System.out.println("Length of Longest Substring Without Repeating Characters: " + length);
                    break;
                }

                case 11:
                    System.out.println("Exiting program... Goodbye!");
                    scannerObj.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
