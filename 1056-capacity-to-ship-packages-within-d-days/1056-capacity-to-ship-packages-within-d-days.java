class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }
        
        int low = maxWeight, high = totalWeight, ans = totalWeight;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        
        return ans;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int currLoad = 0;
        
        for (int w : weights) {
            if (currLoad + w > capacity) {
                usedDays++;
                currLoad = 0;
            }
            currLoad += w;
            
            if (usedDays > days) return false;
        }
        
        return true;
    }
}
