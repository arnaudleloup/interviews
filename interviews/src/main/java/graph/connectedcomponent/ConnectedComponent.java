package graph.connectedcomponent;

import graph.Graph;

public class ConnectedComponent {

	private final boolean[] marked;
	private final int[] id;
	private int count;

	public ConnectedComponent(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];

		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;

		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	/**
	 * Are v and w connected?
	 */
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	/**
	 * Number of connected components.
	 */
	public int count() {
		return count;
	}

	/**
	 * Component identifier for v.
	 */
	public int id(int v) {
		return id[v];
	}
}