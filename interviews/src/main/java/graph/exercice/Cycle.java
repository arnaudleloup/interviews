package graph.exercice;

import graph.Graph;

public class Cycle {

	private final boolean[] marked;
	private boolean hasCycle;

	public Cycle(Graph G) {
		marked = new boolean[G.V()];

		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s, s);
			}
		}
	}

	private void dfs(Graph G, int u, int v) {
		marked[v] = true;

		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, v, w);
			} else if (u != w) {
				// w is a child of v.
				// u is the parent of v.
				// If w is already marked and w is not v parent
				// then there is a cycle.
				hasCycle = true;
			}
		}
	}

	public boolean hasCycle() {
		return hasCycle;
	}
}