import java.util.Arrays;

/*
 * link : https://leetcode.com/problems/valid-anagram/
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray,tArray);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(sol.isAnagram(s,t));
    }
}