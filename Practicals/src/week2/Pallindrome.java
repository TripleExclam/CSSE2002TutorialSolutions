package week2;

import java.util.Random;

public class Pallindrome {

    public static boolean isPalindrome1(String word) {
        // Use a for loop to detect if word is a palindrome
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome2(String word) {
        // Use a while loop to detect palindromes
        String reversedWord = "";
        int length = word.length();

        int i = 0;
        while (i < length) {
            reversedWord = reversedWord + word.charAt(length - 1 - i);
            i++;
        }

        return word.equals(reversedWord);
    }

//    public static String mattsSubstring(String word, int begin, int end) {
//        String sub = "";
//        for (int i = begin; i < end; i++) {
//            sub = sub + word.charAt(i);
//        }
//        return sub;
//    }

    public static boolean isPalindrome3(String word) {
        // check if a word is a palindrome recursively
        // base case  - When do we stop calling the function and simply return a value?
        if (word.length() <= 1) {
            return true;
        }

        // recursive call - Call the function with different arguments
        return word.charAt(0) == word.charAt(word.length() - 1)
                && isPalindrome3(word.substring(1, word.length() - 1));
    }

    public static boolean isPalindrome4(String word) {
        return helper(word, 0);
    }

    /**
     * Challenge task:
     *
     * Write a function:
     *
     * 	    public static String[] palindromeFactory(int n) {}
     *
     * that generates an arbitrary number of pallindromes.
     *
     * HINT: You will need to look up how to generate random characters in Java.
     */
    public static String[] palindromeFactory(int n) {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";

        String[] output =  new String[n];

        for(int i = 0; i < n; i++) {
            String word = "";
            int size = r.nextInt(10); // Palindromes are arbitrarily capped at a length of 26.
            
            for(int j = 0; j <= size; j++) {
                char c = (char) (alphabet.charAt(r.nextInt(alphabet.length()-1)));
                word += c;
            }

            int length = word.length();
            for (int j = length - 1; j >= 0; j--) {
                word = word + word.charAt(j);
            }

            output[i] = word;
        }

        return output;
    }


    private static boolean helper(String word, int i) {
        // base case
        if (i > word.length() / 2) {
            return true;
        }

        // recursive call - change the value of i and leave word unchanged.
        return word.charAt(i) == word.charAt(word.length() - 1 - i)
                && helper(word, ++i);
    }

    public static void main(String[] args) {
        String[] dromes = palindromeFactory(5);

        for (int i = 0; i < dromes.length; i++) {
            System.out.println(dromes[i]);
        }

        String[] palindromes = new String[] {
                "racecar", "AAaaAA", "(())", ")(()", "radar", "123", "dafdsgsfdg"
        };
        for (String item : palindromes) {
            System.out.println(item + ": " + isPalindrome4(item));
        }

    }

}
