import java.util.*;
// MyString class
class MyString {


    // 1. Append function
    static void append_func(String append_str,String str){
        String result=str+""+append_str;
        System.out.println("Result after appending: "+result);
    }


    // 2. count words function
    static void count(String str){
       int result=1;
       for(int i=0;i<str.length();i++){
        if (str.charAt(i) == ' ') {
                result++;
           }
       }
       System.out.println(str + " has "+(result)+" words ");
    }


    // 3. replace function
    static void replace_func(String str, char oldChar, char newChar){
         for(int i=0;i<str.length();i++){
            if(str.charAt(i)==oldChar){
                str=str.substring(0,i)+newChar+str.substring(i+1,str.length());
            }
         }
         System.out.println("Result after replacing : " +str);
    }


    // 4. chk is string palindrom or not
    static void is_palindrom(String str){
        int i=0;
        int j=str.length()-1;
        boolean flag =true;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                flag=false;
                break;
            }
            i++;
            j--;
        }
        if(flag){
            System.out.println("The string is palindrome");
        }
        else{
            System.out.println("The string is not palindrome");
        }

    }


    // 5. splice function
    static void splice_func(String str, int start, int length){
       if(start<0 || start>=str.length()  || length<0 || start+length>str.length()){
        System.out.println("Invalid start index or length");
        return;
       }
       String res=str.substring(0,start)+str.substring(start+length,str.length());
       System.out.println("Result after splicing : "+res);
    }


    // 6. split function
    static void  split_func(String str){
        ArrayList<String> words = new ArrayList<>();
        String ans="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                if(!ans.isEmpty()){
                words.add(ans);
                ans="";
                }
            }

            ans+=str.charAt(i);
        }

        if(!ans.isEmpty()){
        words.add(ans);
        }

        System.out.println("Result after splitting :");
        for(String word: words){
            System.out.print(word + "\t");
        }

    }


    // 7. max repeating char function
    static void max_repeating_char(String str){
        int[] count=new int[256];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        int max=0;
        char result=' ';
        for(int i=0;i<256;i++){
            if(count[i]>max){
                max=count[i];
                result=(char)i;
            }
        }
        System.out.println("Max repeating character is : "+result +" ---> "+max+" times");

    }


    // 8. sort function
    static void sort_func(String str) {
    char[] arr = str.toCharArray(); 
    
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    String sortedStr = new String(arr);
    System.out.println("Sorted string: " + sortedStr);
    }


    // 9. shift function
    static void shift_func(String str, int n){
    n= n % str.length();
    if(n==0) {
        System.out.println("Result after shifting: "+str);
        return;
    }
    String result=str.substring(str.length()-n,str.length())+str.substring(0,str.length()-n);
    System.out.println("Result after shifting : "+result);
    }


    // 10. reverse function
    static void reverse_func(String str){
        String result="";
        for(int i=str.length()-1;i>=0;i--){
            result+=str.charAt(i);
        }

        System.out.println("Result after reversing : "+result);
    }


    // main function
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // String input
        System.out.println("Enter a String:");
        String str=sc.nextLine();

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
                append_func(append_str,str);
                break;


            // count word choice
            case 2:
                count(str);
                break;


            // replace choice
            case 3:
               System.out.println("Enter old character: ");
               char oldChar=sc.next().charAt(0);

               System.out.println("Enter new character: ");
               char newChar=sc.next().charAt(0);

                replace_func(str, oldChar, newChar);
                break;


            // is palindrom choice
            case 4:
               is_palindrom(str);
               break;


            // spice choice
            case 5:
                System.out.println("Enter start index: ");
                int start=sc.nextInt();

                System.out.println("Enter length of splice : ");
                int length=sc.nextInt();

                splice_func(str,start,length);
                break;


            // split choice
            case 6:
                split_func(str);
                break;



            // max repeating char choice
            case 7:
                max_repeating_char(str);
                break;


            // sort choice
            case 8:
                sort_func(str);
                break;


            // shift choice
            case 9:
               System.out.println("Enter number of elements to shift at end: ");
               int n=sc.nextInt();
               shift_func(str,n);
                break;


            // reverse choice
            case 10:
                reverse_func(str);
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
}