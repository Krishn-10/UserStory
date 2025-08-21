import java.util.Scanner;

public class longetPalSubstr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int n = s.length();
        String longest = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    // Helper method to check if a string is palindrome
    private static boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
