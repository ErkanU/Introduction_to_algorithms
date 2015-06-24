import java.util.HashMap;
import java.util.Arrays;

public class StringUtils {

    // checks if a string has all its characters unique
    public static boolean checkIfUniqueChars(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
               return false;
            }
        }
        return true;
    }

    // delete duplicate characters of a string
    public static String deleteDuplicates(String s) {

        if (s.length() < 2) return s;

        char[] array = s.toCharArray();
        Arrays.sort(array);
        String sorted = String.valueOf(array);
        Character currChar = sorted.charAt(0);
        int i = 1;
        while (i < sorted.length()) {
            if (sorted.charAt(i) == currChar) {
                sorted = deleteCharAt(sorted, i);
            } else {
                currChar = sorted.charAt(i);
                i++;
            }
        }
        return sorted;
    }

    // check if anagram
    public static boolean checkIfAnagrams(String s1) {
        char[] a1 = s1.toCharArray();
        for (int i = 0; i < s1.length()/2; i++) {
            System.out.println(a1[i] + " " + a1[s1.length()- i - 1]);
            if (a1[i] != a1[s1.length()- i - 1]) {
                return false;
            }
        }
        return true;
    }

    // delete character at position i
    public static String deleteCharAt(String s, int i) {
        return s.substring(0,i) + s.substring(i+1);
    }


}
