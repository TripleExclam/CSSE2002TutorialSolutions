package week2;

/**
 * A palindrome is a string which reads the same forwards as backwards, such as "AaaA" or "madamimadam".
 * Before attempting to write code, work out on paper how you would check if a string is a palindrome,
 * then write the following methods. All four methods check whether a string is a palindrome, however
 * each uses a different technique. You will need a main method in your class in order to test that they
 * work. You should test at least the following strings: "AaA", "A", "" (should return true) and
 * "Abbb" (should return false).
 */
public class Palindrome {

    public static boolean isPalindrome1(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            // Check that word[i] == word[j] otherwise return false
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String word) {
        // Reverse the word, check it matched the original
        String reversed = "";
        int length = word.length();
        int i = 0;
        while (i < length) {
            // reverse the word in here
            reversed += word.charAt(length - 1 - i);
            i++;
        }

        return word.equals(reversed);
    }

    public static boolean isPalindrome3(String word) {
        // Use recursion to check if word is a palindrome

        // Base case - Case that returns a boolean on a particular value of word
        if (word.length() <= 1) {
            return true;
        }

        // Recursive call - Call the function (isPalindrome3),
        // but with different values for the argument
        return word.charAt(0) == word.charAt(word.length() - 1)
                && isPalindrome3(word.substring(1, word.length() - 1));
    }

    public static boolean isPalindrome4(String word) {
        return helper(word, 0);
    }

    private static boolean helper(String word, int i) {
        // Keep word the same, but change i
        // Base case - Case that returns a boolean on a particular value of word
        if (i >= word.length()) {
            return true;
        }

        // Recursive call - Call the function (isPalindrome3),
        // but with different values for the argument
        return word.charAt(i) == word.charAt(word.length() - 1 - i)
                && helper(word, ++i);
    }

    /**
     * Write a method to count how many opposing characters are matching.
     */
    public static int opposingCount(String word) {
        int length = word.length();
        int count = 0;
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) == word.charAt(length - 1 - i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 	Write a method to output which characters are not matching. For example,
     */
    public static String notMatching(String word) {
        int length = word.length();
        StringBuilder mismatches1 = new StringBuilder();
        StringBuilder mismatches2 = new StringBuilder();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                mismatches1.append(word.charAt(i));
                mismatches2.append(word.charAt(length - 1 - i));
            }
        }
        return mismatches1.toString() + mismatches2.reverse().toString();
    }

    public static void main(String[] args) {
        String[] palindromes = new String[] {
          "AdadaA", "AaA", ")(()", "LOL", "QAQ",
                "(())", "-|--|-", "Not a Palindrome", ":(", ""
        };

        // Write a method to call `isPalindrome1` and print the string tested and the result.
        for (String element : palindromes) {
            System.out.println(element + ": " + isPalindrome4(element));
        }
    }

}
