package com.shivam.hashmaps.questions;

import java.util.HashMap;

public class FirstUniqueCharacterInString {
    public static int firstUniqueChar(String s) {

        // Char, Freq
        HashMap<Character, Integer> map = new HashMap<>();

        char[] charArr = s.toCharArray();


        for (char ch : charArr) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }


        /// HashMap stores only character -> frequency, not character -> index.
        /// So traverse the original array/string to find the first unique character.
        for (int i = 0; i < charArr.length; i++) {

            int frequency = map.get(charArr[i]);

            if (frequency == 1) {
                return i;
            }
        }

        return -1; // if found no any unique character
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqueChar(s));
    }
}
