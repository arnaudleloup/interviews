package matrix.rain;

/**
 * Given a matrix of heights representing the US, first row and first column touching the Pacific
 * and last row and last column touching the Atlantic, return the cells for which a rain drop would
 * fall in both oceans.
 * 
 * A rain drop can only fall from one cell to another cell of height strictly less.
 */
public class Rain {

	public static RainState[][] f(int[][] heights) {
		int n = heights.length;
		int m = heights[0].length;
		RainState[][] states = initStates(n, m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (states[i][j] == RainState.DEFAULT) {
					dfs(heights, states, i, j, n, m);
				}
			}
		}

		return states;
	}

	private static RainState dfs(int[][] heights, RainState[][] states, int i, int j, int n, int m) {
		if (i == -1) {
			if (j == m) {
				return RainState.BOTH;
			}

			return RainState.PACIFIC;
		}

		if (j == m) {
			return RainState.ATLANTIC;
		}

		if (i == n) {
			if (j == -1) {
				return RainState.BOTH;
			}

			return RainState.ATLANTIC;
		}

		if (j == -1) {
			return RainState.PACIFIC;
		}

		if (states[i][j] == RainState.VISITING) {
			return null;
		}

		states[i][j] = RainState.VISITING;

		RainState top = null;
		if (i == 0) {
			top = dfs(heights, states, i - 1, j, n, m);
		} else if (heights[i - 1][j] < heights[i][j]) {
			top = dfs(heights, states, i - 1, j, n, m);
		}

		RainState right = null;
		if (j == m - 1) {
			right = dfs(heights, states, i, j + 1, n, m);
		} else if (heights[i][j + 1] < heights[i][j]) {
			right = dfs(heights, states, i, j + 1, n, m);
		}

		RainState down = null;
		if (i == n - 1) {
			down = dfs(heights, states, i + 1, j, n, m);
		} else if (heights[i + 1][j] < heights[i][j]) {
			down = dfs(heights, states, i + 1, j, n, m);
		}

		RainState left = null;
		if (j == 0) {
			left = dfs(heights, states, i, j - 1, n, m);
		} else if (heights[i][j - 1] < heights[i][j]) {
			left = dfs(heights, states, i, j - 1, n, m);
		}

		states[i][j] = RainState.NONE.add(top).add(right).add(down).add(left);
		return states[i][j];
	}

	private static RainState[][] initStates(int n, int m) {
		RainState[][] states = new RainState[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				states[i][j] = RainState.DEFAULT;
			}
		}

		return states;
	}
}