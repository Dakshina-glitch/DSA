public class PalindromeString {
    public static void main(String[] args) {
        String s = "bdc";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
        String s1 = "aabcaa";
        System.out.println(isPalindrome(s1, 0, s1.length()-1));
    }

    static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length()-1));
    }

    static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        return s.charAt(left) == s.charAt(right) && isPalindrome(s, left+1, right-1);
    }
}
