package week5;

import week2.Pallindrome;

public class PallindromCounter
        extends DistinctCounter {
    private DistinctCounter nonPalindromes
            = new DistinctCounter();

    @Override
    public void add(String s) {
        if (Pallindrome.isPalindrome1(s)) {
            super.add(s);
        } else {
            nonPalindromes.add(s);
        }
    }

    public int getPalindromeCount() {
        return super.getDistinctCount();
    }

    public  String[] getPalindromes() {
        return super.getStrings();
    }

    public String[] getNonPalindromes() {
        return nonPalindromes.getStrings();
    }
}
