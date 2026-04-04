class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarysearch(nums, target, true);
        int last = binarysearch(nums, target, false);
        return new int[] {first, last};
    }

    public int binarysearch(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;

                if (findFirst) {
                    right = mid - 1;   
                } else {
                    left = mid + 1;  
                }

            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}