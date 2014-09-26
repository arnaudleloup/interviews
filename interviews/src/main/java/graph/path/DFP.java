package graph.path;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Depth First Path.
 */
public class DFP {

	private final boolean[] marked;
	private final int[] edgeTo;
	private final int s;

	public DFP(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;

		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	/**
	 * Is there a path from s to v?
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	/**
	 * Path from s to v. Return null if no such path.
	 */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}

		Deque<Integer> deque = new ArrayDeque<>();

		int w = v;
		while (w != s) {
			deque.addFirst(w);
			w = edgeTo[w];
		}

		if (deque.isEmpty()) {
			deque.add(w);
		}

		return deque;
	}
}