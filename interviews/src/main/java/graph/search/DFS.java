package graph.search;

import graph.Graph;

/**
 * Depth First Search.
 */
public class DFS {

	private final boolean[] marked;
	private int count;

	public DFS(Graph g, int s) {
		marked = new boolean[g.V()];
		dfs(g, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		count++;

		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
	}

	/**
	 * Is v connected to s?
	 */
	public boolean marked(int v) {
		return marked[v];
	}

	/**
	 * How many vertices are connected to s?
	 */
	public int count() {
		return count;
	}
}