class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        long gainSum = 0;
        int count = 0;
        int minLoss = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int xorVal = num ^ k;
            int gain = xorVal - num;
            
            total += num;
            
            if (gain > 0) {
                gainSum += gain;
                count++;
            }
            
            minLoss = Math.min(minLoss, Math.abs(gain));
        }

        if (count % 2 == 1) {
            gainSum -= minLoss;
        }
        
        return total + gainSum;
    }
}