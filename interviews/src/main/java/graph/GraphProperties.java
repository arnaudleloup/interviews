package graph;

import graph.connectedcomponent.ConnectedComponent;

import java.util.ArrayList;
import java.util.List;

public class GraphProperties {

	private final int[] eccentricity;
	private int diameter;
	private int radius;
	private int center;

	public GraphProperties(Graph G) throws IllegalArgumentException {
		ConnectedComponent cc = new ConnectedComponent(G);
		if (cc.count() > 1) {
			throw new IllegalArgumentException("Can not calculate properties on a disconnected graph");
		}

		eccentricity = new int[G.V()];
		diameter = Integer.MIN_VALUE;
		radius = Integer.MAX_VALUE;

		for (int v = 0; v < G.V(); v++) {
			bfs(G, v);

			if (eccentricity[v] < radius) {
				radius = eccentricity[v];
				center = v;
			}

			if (eccentricity[v] > diameter) {
				diameter = eccentricity[v];
			}
		}
	}

	private void bfs(Graph G, int v) {
		boolean[] marked = new boolean[G.V()];
		marked[v] = true;
		List<Integer> frontier =  new ArrayList<>();
		frontier.add(v);
		int i = 0;

		while (!frontier.isEmpty()) {
			List<Integer> next = new ArrayList<>();

			for (int w : frontier) {
				for (int x : G.adj(w)) {
					if (!marked[x]) {
						next.add(x);
						marked[x] = true;
					}
				}
			}

			frontier = next;
			i++;
		}

		eccentricity[v] = i;
	}

	public int diameter() {
		return diameter;
	}

	public int radius() {
		return radius;
	}

	public int center() {
		return center;
	}
}