import java.util.HashMap;

public class StringUtils {

    // checks if a string has all its characters unique
    public static boolean checkIfUniqueChars(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        return !map.values().contains(2);
    }
}
