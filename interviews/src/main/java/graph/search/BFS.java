package graph.search;

import graph.Graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Breadth First Search.
 */
public class BFS {

	private final boolean[] marked;
	private int count;

	public BFS(Graph g, int s) {
		marked = new boolean[g.V()];
		bfs(g, s);
	}

	private void bfs(Graph g, int s) {
		marked[s] = true;
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(s);

		while (!queue.isEmpty()) {
			int v = queue.poll();
			count++;

			for (int w : g.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					queue.add(w);
				}
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