class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    private boolean canEat(int[] piles, int k, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
        
    }
}