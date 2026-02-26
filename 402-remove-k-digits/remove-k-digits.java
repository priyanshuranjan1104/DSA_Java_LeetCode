class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length())
        return "0";
    char[] arr = num.toCharArray();
    int n = arr.length;
    int j = 0;
    for(int i=0;i<n;i++){
        while(k>0 && j>0 && arr[j-1]>arr[i]){
            j--;
            k--;
        }
        arr[j++] = arr[i];
    }
    j = j-k;
    int st = 0;
    while(st<j && arr[st] == '0'){
        st++;
    }    
    if(st == j)
    return "0";
    return new String(arr,st,j-st);
    }
}