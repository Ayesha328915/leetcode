class Solution {
    public long subArrayRanges(int[] nums) {
        return getContribution(nums, true) - getContribution(nums, false);
    }
    private static long getContribution(int[] nums, boolean isMax) {
        int n = nums.length;
        long sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? (isMax ? Integer.MAX_VALUE : Integer.MIN_VALUE) : nums[i];
            while (!stack.isEmpty() && 
                   (isMax ? nums[stack.peek()] < curr : nums[stack.peek()] > curr)) {
                
                int mid = stack.pop();          
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                long count = (long)(mid - left) * (right - mid);

                sum += (long) nums[mid] * count;
            }
            stack.push(i);
        }
        return sum;
        
    }
}