class Solution200 {

	int[][] checkedTiles;

	public int numIslands(char[][] grid) {
		checkedTiles = new int[grid.length][grid[0].length];

		int numIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				char t = grid[i][j];
				if (verifyIsland(i, j, grid)) numIslands++;
			}
		}

		return numIslands;
	}

	public boolean verifyIsland(int i, int j, char[][] grid) {
		if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return false;
		if (checkedTiles[i][j] == 1) return false;

		char t = grid[i][j];
		checkedTiles[i][j] = 1;
		if (t == '1') {
			verifyIsland(i + 1, j, grid);
			verifyIsland(i - 1, j, grid);
			verifyIsland(i, j + 1, grid);
			verifyIsland(i, j - 1, grid);
			return true;
		}

		return false;
	}
}