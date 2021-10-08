package algorithms;

public class Palindrome {
	public static boolean isPalindrome(String s){
		if (s.length()%2 != 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[(n-1) - i]) {
                return false;
            }
        }

		return true;
	}

	public static void main(String[] args){
		String s1 = "abc";
		String s2 = "kayak";
		System.out.println("Is " + s1 + " a palindrome?: " + isPalindrome(s1));
		System.out.println("Is " + s2 + " a palindrome?: " + isPalindrome(s2));
		//System.out.println("Is " + s1 + " a palindrome?: " + isPalindrome(s2));
	}
}
