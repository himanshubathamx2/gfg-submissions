
class Triplet{
    int i;
    int j;
    int level;
    Triplet(int i, int j, int level){
        this.i = i;
        this.j = j;
        this.level = level;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] matrix = new int[n][m];
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        int[][] vis = new int[n][m];
        
        
        Queue<Triplet> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    q.offer(new Triplet(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        
        while(!q.isEmpty()){
            Triplet popped = q.poll();
            int i = popped.i;
            int j = popped.j;
            int level = popped.level;
            matrix[i][j] = level;
            for(int k=0; k<4; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                vis[nrow][ncol]==0 && grid[nrow][ncol]==0){
                    q.offer(new Triplet(nrow, ncol, level + 1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                row.add(matrix[i][j]);
            }
            list.add(row);
        }
        
        return list;
        
        
        
    }
}