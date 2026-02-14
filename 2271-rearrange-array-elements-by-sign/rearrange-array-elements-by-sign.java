class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n=nums.length;

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        
        for(int num : nums){
            if(num>0)
            positive.add(num);
            else
            negative.add(num);
        }
    
        int[] arr = new int[n];
        int i=0,j=0,k=0;

        while(i<n){
            arr[i++]=positive.get(j++);
            arr[i++]=negative.get(k++);
        }
        return arr;
    }
}