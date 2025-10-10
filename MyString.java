 /**
  *@filename- MyString.java
  *@description -This will perform most of the string operation
  *@author - Fatimi Bee
  */

import java.util.*;
// MyString class
class MyString {
    String value = "Hello" ;
    MyString(String value) {
       this.value = value ;
    }


    // 1. Append function
    public String appendFunc(String append_str){
        String result = this.value +" "+ append_str ;
        return result ;
    }


    // 2. count words function
    public int count(){
       int result = 1;
       for(int i = 0 ; i < this.value.length() ; i++){
        if (this.value.charAt(i) == ' ') {
                result++ ;
           }
       }
      return result ;
    }


    // 3. replace function
    public void replaceFunc( char oldChar, char newChar){
         for(int i = 0 ; i < this.value.length() ; i++){
            if(this.value.charAt(i) == oldChar){
                this.value = this.value.substring(0,i)+newChar+this.value.substring(i+1,this.value.length()) ;
            }
         }
         
    }


    // 4. chk is string palindrom or not
    public boolean isPalindrom(){
        String str=this.value ;
        int i = 0 ;
        int j = str.length() - 1 ;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false ;
            }
            i++ ;
            j-- ;
        }

        return true ;
    }


    // 5. splice function
    public String spliceFunc(int start, int length){
       if(start < 0 || start >= this.value.length()  || length < 0 || start + length > this.value.length()){
        return this.value ;
       }
       String result = this.value.substring(0 , start) + this.value.substring(start + length , this.value.length()) ;
       return result ;
    }


    // 6. split function
    public void splitFunc(String pattern){
        String str=this.value ;
        ArrayList<String> words = new ArrayList<>();
        String answer = "" ;
        for(int i = 0 ; i < str.length() ; i++){
            // check if the pattern matches at the current position (supports multi-char pattern)
            if(pattern != null && pattern.length() > 0 && i + pattern.length() <= str.length()
               && str.substring(i, i + pattern.length()).equals(pattern)){
                if(!answer.isEmpty()){
                    words.add(answer) ;
                    answer = "" ;
                }
                i += pattern.length() ;
            } else {
                answer += str.charAt(i) ;
                i++ ;
            }
        }

        if(!answer.isEmpty()){
            words.add(answer) ;
        }

        System.out.println("Result after splitting : ") ;
        for(String word: words){
            System.out.print(word + "\t") ;
        }

    }


    // 7. max repeating char function
    public void  getMaxRepeatingChar(){
        int[] count = new int[256] ;
        String str = this.value ;
        for(int i = 0 ; i < str.length() ; i++){
            count[str.charAt(i)]++ ;
        }
        int max = 0 ;
        char result = ' ' ;
        for (int i = 0 ; i < 256 ; i++) {
            if (count[i] > max) {
            max = count[i] ;
            result = (char) i ;
            }
        }
        System.out.println("Max Repeating character in String is : "+result+" with frequency :"+max) ;

    }


    // 8. sort function
    public String sortFunc() {
        String str=this.value ;
        
    char[] arr = str.toCharArray() ; 
    
    for (int i = 0 ; i < arr.length - 1 ; i++) {
        for (int j = i + 1 ; j < arr.length ; j++) {
            if (arr[i] > arr[j]) {
                char temp = arr[i] ;
                arr[i] = arr[j] ;
                arr[j] = temp ;
            }
        }
    }
    String sortedStr = new String(arr) ;
    return sortedStr ;
    }


    // 9. shift function
    public String shiftFunc(int n){
    String str=this.value ;
    n = n % str.length() ;
    if(n == 0) {
       
        return str ;
    }
    String result = str.substring(str.length() - n , str.length()) + str.substring(0 , str.length() - n) ;
    return result ;
    }


    // 10. reverse function
    public String reverseFunc(){
        String str = this.value ;
        String result = "" ;
        for(int i = str.length()-1 ; i >= 0 ; i--){
            result += str.charAt(i) ;
        }

        return result ;
    }

};