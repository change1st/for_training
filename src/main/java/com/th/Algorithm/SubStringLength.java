package com.th.Algorithm;

public class SubStringLength {

    /**
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int maxLen = 0;
        String subString = "";
        for (int i = 0; i < s.length(); i++) {
            String subStr1 = findSublongestPalindrome(s, i, i);
            String subStr2 = findSublongestPalindrome(s, i, i+1);
            if (subStr1.length() >= maxLen) {
                maxLen = subStr1.length();
                subString = subStr1;
            }

            if (subStr2.length() >= maxLen) {
                maxLen = subStr2.length();
                subString = subStr2;
            }
        }

        return subString;
    }

    private static String findSublongestPalindrome(String s, int centerStart, int centerEnd) {
        int start = centerStart;
        int end = centerEnd;
        int subStart = centerStart;
        int subEnd = centerEnd;
        String subString = "";
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))             {
            subStart = start;
            subEnd = end;
            start--;
            end++;
        }

        if (subStart != start) {
            subString = s.substring(subStart, subEnd + 1);
        }

        return subString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
