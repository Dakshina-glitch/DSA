public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        String reverse = reverse(s);
        System.out.println(reverse);
    }

    static String reverse(String s) {
        if (s.isEmpty()) {
            return "";
        }

        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
