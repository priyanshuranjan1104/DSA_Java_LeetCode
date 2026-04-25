class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];

            if (y == 0) pos[i] = x;
            else if (x == side) pos[i] = side + y;
            else if (y == side) pos[i] = 3L * side - x;
            else pos[i] = 4L * side - y;
        }

        Arrays.sort(pos);

        int low = 0, high = 2 * side, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(pos, k, mid, side)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(long[] pos, int k, int dist, int side) {
        int n = pos.length;
        long perimeter = 4L * side;

        long[] ext = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ext[i] = pos[i];
            ext[i + n] = pos[i] + perimeter;
        }

        for (int start = 0; start < n; start++) {
            int count = 1;
            long last = ext[start];
            int idx = start;

            for (int taken = 1; taken < k; taken++) {
                idx = lowerBound(ext, idx + 1, start + n, last + dist);
                if (idx == start + n) break;

                last = ext[idx];
                count++;
            }

            if (count == k && perimeter - (last - ext[start]) >= dist)
                return true;
        }

        return false;
    }

    public int lowerBound(long[] arr, int left, int right, long target) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}