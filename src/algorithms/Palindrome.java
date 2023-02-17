package algorithms;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        var cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        var forward = 0;
        var backward = cleanStr.length() - 1;

        while (backward > forward) {
            var forwardChar = cleanStr.charAt(forward++);
            var backwardChar = cleanStr.charAt(backward--);

            if (forwardChar != backwardChar) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "kayak";
        System.out.println("Is " + s1 + " a palindrome?: " + isPalindrome(s1));
        System.out.println("Is " + s2 + " a palindrome?: " + isPalindrome(s2));
    }
}
