class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = obstacles[i];
            int l = 0, r = list.size();

            while (l < r) {
                int m = (l + r) / 2;

                if (list.get(m) <= x) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }

            if (l == list.size()) {
                list.add(x);
            } else {
                list.set(l, x);
            }

            ans[i] = l + 1;
        }

        return ans;
    }
}