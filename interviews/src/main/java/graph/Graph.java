package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private final int V;
	private int E;
	private final List<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		adj = new ArrayList[V];

		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<>();
		}
	}

	/**
	 * Number of vertices.
	 */
	public int V() {
		return V;
	}

	/**
	 * Number of edges.
	 */
	public int E() {
		return E;
	}

	/**
	 * Add edge v-w to this graph.
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	/**
	 * Vertices adjacent to v;
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int v =  0; v < V; v++) {
			sb.append(v + ":");

			for (int w : adj[v]) {
				sb.append(" " + w);
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}