import java.util.*;

class Solution {

    public static void subsetfunc(int[] nums, int index, List<Integer> subList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subList)); 

        for (int i = index; i < nums.length; i++) {
            subList.add(nums[i]);                  
            subsetfunc(nums, i + 1, subList, ans); 
            subList.remove(subList.size() - 1);   
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetfunc(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}