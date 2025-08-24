class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) { 
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int d : bloomDay) {
            min = Math.min(min, d);
            max = Math.max(max, d);
        }

        int low = min, high = max, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1; // try smaller day
            } else {
                low = mid + 1; // need larger day
            }
        }

        return ans;
    }

    private static boolean canMake(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0, flowers = 0;

        for (int d : bloomDay) {
            if (d <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
