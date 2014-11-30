package matrix.rain;

import java.util.Arrays;

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
		RainState[][] states = new RainState[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(states[i], RainState.INITIALIZING);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (states[i][j] == RainState.INITIALIZING) {
					dfs(heights, states, i, j, n, m);
				}
			}
		}

		return states;
	}

	private static RainState dfs(int[][] heights, RainState[][] states, int i, int j, int n, int m) {
		if (states[i][j] != RainState.INITIALIZING) {
			return states[i][j];
		}

		RainState top = null;
		if (i == 0) {
			top = RainState.PACIFIC;
		} else if (heights[i - 1][j] < heights[i][j]){
			top = dfs(heights, states, i - 1, j, n, m);
		}

		RainState right = null;
		if (j == m - 1) {
			right = RainState.ATLANTIC;
		} else if (heights[i][j + 1] < heights[i][j]){
			right = dfs(heights, states, i, j + 1, n, m);
		}

		RainState down = null;
		if (i == n - 1) {
			down = RainState.ATLANTIC;
		} else if (heights[i + 1][j] < heights[i][j]){
			down = dfs(heights, states, i + 1, j, n, m);
		}

		RainState left = null;
		if (j == 0) {
			left = RainState.PACIFIC;
		} else if (heights[i][j - 1] < heights[i][j]){
			left = dfs(heights, states, i, j - 1, n, m);
		}

		states[i][j] = RainState.NONE.add(top).add(right).add(down).add(left);
		return states[i][j];
	}
}