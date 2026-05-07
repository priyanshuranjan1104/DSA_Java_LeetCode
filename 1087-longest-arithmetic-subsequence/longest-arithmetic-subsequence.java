class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int ans = 2;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;

                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), len));
                ans = Math.max(ans, dp[i].get(diff));
            }
        }

        return ans;
    }
}