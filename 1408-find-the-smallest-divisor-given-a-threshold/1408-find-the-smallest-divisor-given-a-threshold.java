class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        int low = 1, high = max, ans = max;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canDivide(nums, mid, threshold)) {
                ans = mid;         
                high = mid - 1;  
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean canDivide(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; 
            if (sum > threshold) return false; 
        }
        return sum <= threshold;
    }
}
