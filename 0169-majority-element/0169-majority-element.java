class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // Count frequencies
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Find the majority element (> n/2)
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key; // Return the majority element
            }
        }
        return -1;
    }
}