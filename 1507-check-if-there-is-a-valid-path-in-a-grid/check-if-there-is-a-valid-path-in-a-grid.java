class Solution {

    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            
            if (r == m - 1 && c == n - 1)
                return true;
            
            for (int[] next : getNext(grid[r][c], r, c)) {
                int nr = next[0];
                int nc = next[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    
                    for (int[] back : getNext(grid[nr][nc], nr, nc)) {
                        if (back[0] == r && back[1] == c) {
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                            break;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public List<int[]> getNext(int type, int r, int c) {
        List<int[]> list = new ArrayList<>();
        
        if (type == 1) { 
            list.add(new int[]{r, c - 1});
            list.add(new int[]{r, c + 1});
        } 
        else if (type == 2) { 
            list.add(new int[]{r - 1, c});
            list.add(new int[]{r + 1, c});
        } 
        else if (type == 3) { 
            list.add(new int[]{r, c - 1});
            list.add(new int[]{r + 1, c});
        } 
        else if (type == 4) { 
            list.add(new int[]{r, c + 1});
            list.add(new int[]{r + 1, c});
        } 
        else if (type == 5) { 
            list.add(new int[]{r, c - 1});
            list.add(new int[]{r - 1, c});
        } 
        else if (type == 6) { 
            list.add(new int[]{r, c + 1});
            list.add(new int[]{r - 1, c});
        }
        
        return list;
    }
}