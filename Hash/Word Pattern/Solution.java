import java.util.*;

class Solution {
    public static boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if (sArray.length != pattern.length())
            return false;

        // To check each letter is mapped to exactly one word.
        HashMap<Character, String> hm1 = new HashMap<>();

        // To check each word is mapped to exactly one letter.
        HashMap<String, Character> hm2 = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {

            hm1.putIfAbsent(pattern.charAt(i), sArray[i]);
            if (!hm1.get(pattern.charAt(i)).equals(sArray[i]))
                return false;

            hm2.putIfAbsent(sArray[i], pattern.charAt(i));
            if (hm2.get(sArray[i]) != pattern.charAt(i))
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}