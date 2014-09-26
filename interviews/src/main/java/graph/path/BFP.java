package graph.path;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Breadth First Path.
 */
public class BFP {

	private final boolean[] marked;
	private final int[] edgeTo;
	private final int s;

	public BFP(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfp(G, s);
	}

	private void bfp(Graph G, int s) {
		marked[s] = true;

		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(s);

		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					queue.add(w);
				}
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


		deque.add(w);
		return deque;
	}
}