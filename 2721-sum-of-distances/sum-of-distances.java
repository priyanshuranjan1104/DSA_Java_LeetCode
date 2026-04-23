class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (ArrayList<Integer> list : map.values()) {
            int m = list.size();

            if (m == 1) continue;

            long total = 0;

            for (int idx : list) total += idx;

            long leftSum = 0;

            for (int i = 0; i < m; i++) {
                int idx = list.get(i);

                total -= idx;

                long left = (long) i * idx - leftSum;
                long right = total - (long)(m - i - 1) * idx;

                ans[idx] = left + right;

                leftSum += idx;
            }
        }

        return ans;
    }
}