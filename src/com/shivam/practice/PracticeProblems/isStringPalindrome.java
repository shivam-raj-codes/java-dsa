package com.shivam.practice.PracticeProblems;
import java.lang.String;
public class isStringPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        boolean ans = isPalindrome(str, 0, str.length() - 1);
        System.out.println(ans);
    }

    public static boolean isPalindrome(String s, int start, int end) {

        if (start >= end ) { // base case -> covers odd - length and even - length string both
            return true;
        }


        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return isPalindrome(s, start + 1, end - 1);

    }
}
