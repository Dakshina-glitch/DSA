import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "lleetcode";
        System.out.println(firstUniqueChar(s));
    }

    static public int firstUniqueChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        return solve(s, 0, freq);
    }

    static private int solve(String s, int index, Map<Character, Integer> freq) {
        if (index >= s.length()) {
            return -1;
        }

        if (isFirstUniqueCharacter(s.charAt(index), freq)) {
            return index;
        }

        return solve(s, index + 1, freq);
    }

    static private boolean isFirstUniqueCharacter(char c, Map<Character, Integer> freq) {
        return freq.get(c) == 1;
    }
}
