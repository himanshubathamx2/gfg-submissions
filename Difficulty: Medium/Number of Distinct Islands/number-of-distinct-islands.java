class Solution {
	public int countDistinctIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] drow = {1, -1, 0, 0};
		int[] dcol = {0, 0, 1, -1};
		int[][] vis = new int[n][m];
		List<int[]> coordinates = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if (vis[i][j] == 0 && grid[i][j] == 'L') {
					dfs(i, j, grid, drow, dcol, vis, n, m, coordinates);
					// Adding in set
					StringBuilder sb = new StringBuilder();
					for (int[] coor : coordinates) {
						sb.append(coor[0] - i);
						sb.append(coor[1] - j);
					}
					set.add(sb.toString());
					coordinates = new ArrayList<>();
				}
				
			}
		}
		return set.size();
	}
	
	public void dfs(int i, int j, char[][] grid, int[] drow, int[] dcol, int[][] vis, int n, int m, List<int[]> coordinates) {
		vis[i][j] = 1;
		coordinates.add(new int[] {i, j});
		for (int k = 0; k<4; k++) {
			int nrow = i + drow[k];
			int ncol = j + dcol[k];
			if (nrow >= 0 && nrow<n && ncol >= 0 && ncol<m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'L') {
				dfs(nrow, ncol, grid, drow, dcol, vis, n, m, coordinates);
			}
		}
	}
}
