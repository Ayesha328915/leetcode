class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;     // to count current streak of 1s
        int maxi = 0;      // to store maximum streak of 1s
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++; // increase streak
                maxi = Math.max(maxi, count); 
            } else {
                count = 0; // reset when 0 encountered
            }
        }
        return maxi;
        
    }
}