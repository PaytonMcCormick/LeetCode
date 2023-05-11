import java.util.HashSet;

/*
 * link : https://leetcode.com/problems/contains-duplicate/
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        //Keeps track of the numbers that have been seen
        HashSet<Integer> numList = new HashSet<Integer>();

        //Iterate through the array and check if the number has been seen
        for(int i = 0; i < nums.length; i++){

            //Duplicate found
            if(numList.contains(nums[i])){
                return true;
            }
            
            //Add the number to the list
            else{
                numList.add(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,1};
        System.out.println(sol.containsDuplicate(nums));
    }
}
