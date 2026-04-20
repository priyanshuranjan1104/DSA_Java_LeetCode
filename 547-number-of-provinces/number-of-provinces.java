class Solution {
    public void dfs(int city, int[][] isConnected, boolean[] visited){
        visited[city] = true;
        for(int i = 0; i<isConnected.length; i++){
            if(isConnected[city][i] == 1 && !visited[i]){
                dfs(i,isConnected,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
       boolean[] visited = new boolean[n];
       int provinces = 0;

       for(int j=0;j<n;j++){
        if(!visited[j]){
            dfs(j,isConnected,visited);
            provinces++;
        }
       } 
       return provinces;
    }
}