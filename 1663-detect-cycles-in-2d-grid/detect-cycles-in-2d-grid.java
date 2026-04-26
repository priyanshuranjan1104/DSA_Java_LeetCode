class Solution {
    int rows, cols;
    boolean[][] visited;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public boolean containsCycle(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] grid, int x, int y, int px, int py, char ch) {
        visited[x][y] = true;
        
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if (nx < 0 || ny < 0 || nx >= rows || ny >= cols)
                continue;
            
            if (grid[nx][ny] != ch)
                continue;
            
            if (nx == px && ny == py)
                continue;
            
            if (visited[nx][ny])
                return true;
            
            if (dfs(grid, nx, ny, x, y, ch))
                return true;
        }
        
        return false;
    }
}