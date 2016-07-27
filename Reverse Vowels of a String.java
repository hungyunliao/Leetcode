public class Solution {
    public String reverseVowels(String s) {
        int length = s.length();
        boolean isLeftAtVowel = false, isRightAtVowel = false;
        char[] charArray = new char[length];
        int left = 0, right = length - 1;
        
        /*
            right index stops at right vowels, and left index stops at left vowels.
            when one stops at vowels, it will wait for the other.
            once two indece stop at vowels, switch two vowels and step forward.
        */
        
        while (left <= right) {
            
            if (s.charAt(left) != 'a' &&
                s.charAt(left) != 'e' &&
                s.charAt(left) != 'i' &&
                s.charAt(left) != 'o' &&
                s.charAt(left) != 'u' &&
                s.charAt(left) != 'A' &&
                s.charAt(left) != 'E' &&
                s.charAt(left) != 'I' &&
                s.charAt(left) != 'O' &&
                s.charAt(left) != 'U'
            ) {
                isLeftAtVowel = false;
                charArray[left] = s.charAt(left);
                left++;
            } else {
                isLeftAtVowel = true;
            }
            
            if (s.charAt(right) != 'a' &&
                s.charAt(right) != 'e' &&
                s.charAt(right) != 'i' &&
                s.charAt(right) != 'o' &&
                s.charAt(right) != 'u' &&
                s.charAt(right) != 'A' &&
                s.charAt(right) != 'E' &&
                s.charAt(right) != 'I' &&
                s.charAt(right) != 'O' &&
                s.charAt(right) != 'U'
                ) {
                isRightAtVowel = false;
                charArray[right] = s.charAt(right);
                right--;
            } else {
                isRightAtVowel = true;
            }
            
            if (isLeftAtVowel && isRightAtVowel) {
                charArray[left] = s.charAt(right);
                charArray[right] = s.charAt(left);
                left++;
                right--;
            }
            
        }
        
        String str = new String(charArray);
        
        return str;
    }
}
