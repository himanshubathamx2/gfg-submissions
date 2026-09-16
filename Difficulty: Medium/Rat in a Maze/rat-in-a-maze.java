class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, -1, 1, 0};
        int n = maze.length;
        int m = maze[0].length;
        int[][] vis = new int[n][m];
        ArrayList<String> ans = new ArrayList<>();
        if(maze[0][0] == 0)
            return ans;
        f(0,0, drow, dcol, ans, "", n, m, maze, vis);
        return ans;
    }
    
    public void f(int row, int col, int[] drow, int[] dcol, ArrayList<String> ans, String move, int n, int m, int[][] maze, int[][] vis){
        if(row==n-1 && col==m-1){
            ans.add(move);
            return;
        }
        String dxn = "DLRU";
        vis[row][col] = 1;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && maze[nrow][ncol]==1 && vis[nrow][ncol]==0){
                f(nrow, ncol, drow, dcol, ans, move + dxn.charAt(i), n, m, maze, vis);
            } 
        }
        vis[row][col] = 0;
    }
    
}