/**
 * @filename - Main.java
 * @description - This is the  file which contains the all functions
 * related to string and number operations.
 * @author - Fatimi Bee
 */


public class MyOperation {
    String value ;
    int number ;

    // Constructor for String value
    public MyOperation(String value) {
        this.value = value ;
    }

    // Constructor for int number
    public MyOperation(int number) {
        this.number = number ;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1 ;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false ;
        }
        return true ;
    }

    // 1. Count Unique Palindromes in a string
    public int countUniquePalindromes() {
        int palindromes = 0 ;
        int n = value.length() ;
        for (int i = 0; i < n; i++) {
            for (int j = i + 3; j <= n; j++) {
                String sub = value.substring(i, j);
                if (isPalindrome(sub)) {
                    palindromes++ ;
                }
            }
        }
        return palindromes ;
    }

    // 2. Nth Fibonacci Number
    public int fibonacciNth() {
        int n = this.number;
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        int first = 1, second = 1, third = 0;
        for (int i = 3 ; i <= n ; i++) {
            third = first + second ;
            first = second;
            second = third ;
        }
        return third;
    }

    // 3. Snake to camel
    public String snakeToCamel() {
        String result = "";
        boolean capitalizeNext = false;

        for (int i = 0 ; i < value.length() ; i++) {
            char ch = value.charAt(i);

            if (ch == '_') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result += (Character.toUpperCase(ch));
                    capitalizeNext = false;
                } else {
                    result += (ch);
                }
            }
        }
        return result;
    }

    // 4. Count consonants in the string
    public int countConsonants() {
        int count = 0;
        for (char c : value.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }

    // 5. Binary → Decimal conversion
    public int binaryToDecimal() {
        String binary = this.value;
        int decimal = 0;
        int base = 1;
        for (int i = binary.length() - 1 ; i >= 0 ; i--) {
            if (binary.charAt(i) == '1') {
                decimal += base;
            }
            base *= 2;
        }
        return decimal;
    }

    // 6. Display character based on number
    public String displayCharacters() {
        String input = this.value;
        String outputString = "";

        int i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            i++;

            // Read the number (may have multiple digits)
            String numStr = "";
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                numStr = numStr + input.charAt(i); // concatenate digits
                i++;
            }

            if (!numStr.equals("")) {
                int count = Integer.parseInt(numStr);
                for (int j = 0 ; j < count ; j++) {
                    outputString = outputString + ch; // repeat character
                }
            } else {
                outputString = outputString + ch; // no number, just append
            }
        }

        return outputString;
    }


    // 7. Character Frequency in a string (compressed)
    public String characterFrequencyCompressed() {
        String input = this.value;
        String result = "";

        int count = 1;
        for (int i = 0 ; i < input.length() ; i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                result += (input.charAt(i)) + (count);
                count = 1;
            }
        }

        return result;
    }

    // 8. Prime number checker
    public boolean isPrime() {
        int num = this.number;
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3 ; i <= Math.sqrt(num) ; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 9. Number to word conversion
    public String numberToWords() {
        int num = this.number;
        if (num == 0) return "zero";

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                         "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                         "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String words ="";

        if (num >= 1000) {
            words += (ones[num / 1000]) + (" thousand ");
            num %= 1000;
        }
        if (num >= 100) {
            words += (ones[num / 100]) + (" hundred ");
            num %= 100;
        }
        if (num >= 20) {
            words += (tens[num / 10]) + (" ");
            num %= 10;
        }
        if (num > 0) {
            words += (ones[num]) + (" ");
        }

        return words;
    }

    // 10. Length of longest substring without repeating characters
    public int longestSubstringWithoutRepeat() {
        int maxLen = 0;
        String s = this.value;

        for (int i = 0 ; i < s.length() ; i++) {
            String substring = "";
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (substring.indexOf(String.valueOf(c)) != -1) {
                    break;
                } else {
                    substring += (c);
                    if (substring.length() > maxLen) {
                        maxLen = substring.length();
                    }
                }
            }
        }

        return maxLen;
    }
}
