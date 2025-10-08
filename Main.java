 /**
  *@filename- Main.java
  *@description -This is main file which contain main function and menu to call different functions of MyString class.
  *@author - Fatimi Bee
  */


import java.util.*;

public class Main {

      public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // String input
        System.out.println("Enter a String:");
        String str=sc.nextLine();
        
        MyString s=new MyString(str);
        

        // menu
        System.out.println("Choices:");
        System.out.println(" 1. Append a string \n 2. Count words \n 3. Replace \n 4. Is palindrome \n 5. Splice \n 6. Split \n 7. Max Reapeting Character \n 8. Sort \n 9. Shift \n 10. Reverse \n 11. Exit");
        
        // choice enter
        System.out.println("Enter your choice:");
        int choice=sc.nextInt();

        sc.nextLine();


        // calling function based on user choice
        switch(choice){
            
            // append choice
            case 1:
                System.out.println("Enter a string to append:");
                String append_str=sc.nextLine();
                String ans=s.append_func(append_str);
                System.out.println("Result after appending : " +ans);
                break;


            // count word choice
            case 2:
                int words=s.count();
                System.out.println("Number of words in String : "+words);
                break;


            // replace choice
            case 3:
               System.out.println("Enter old character: ");
               char oldChar=sc.next().charAt(0);

               System.out.println("Enter new character: ");
               char newChar=sc.next().charAt(0);

                s.replace_func(oldChar, newChar);
                System.out.println("Result after replacing :"+s.value);
                break;


            // is palindrom choice
            case 4:
            boolean isPal = s.is_palindrom();
                if(isPal){
                    System.out.println("String is palindrom");
                }
                else{
                    System.out.println("String is not palindrom");
                }
               break;


            // spice choice
            case 5:
                System.out.println("Enter start index: ");
                int start=sc.nextInt();

                System.out.println("Enter length of splice : ");
                int length=sc.nextInt();

                String spliced=s.splice_func(start,length);
                System.out.println("Result after splicing : "+spliced);
                break;


            // split choice
            case 6:
                s.split_func();
                break;


            // max repeating char choice
            case 7:
                s.max_repeating_char();
                break;


            // sort choice
            case 8:
                String Sorted=s.sort_func();
                System.out.println("Result after sorting : "+Sorted);
                break;


            // shift choice
            case 9:
               System.out.println("Enter number of elements to shift at end: ");
               int n=sc.nextInt();
               String shifted=s.shift_func(n);
               System.out.println("Result after shifting : "+shifted);
                break;


            // reverse choice
            case 10:
                String reversed=s.reverse_func();
                System.out.println("Result after reversing : "+reversed);
                break;


            // exit choice
            case 11:
                System.exit(0);
                break;

                
            // default case
            default:
                 System.out.println("You entered invalid choice");
                 break;
        }
        sc.close();

    }
};
