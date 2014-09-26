package graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphPropertiesTest {

	@Test
	public void test() {
		Graph G = buildGraph();
		GraphProperties GP = new GraphProperties(G);
		int expectedDiameter = 5;
		int expectedRadius = 3;
		int expectedCenter = 3;

		assertEquals(expectedDiameter, GP.diameter());
		assertEquals(expectedRadius, GP.radius());
		assertEquals(expectedCenter, GP.center());
	}


	private Graph buildGraph() {
		Graph G = new Graph(8);

		G.addEdge(0, 1);
		G.addEdge(1, 2);
		G.addEdge(1, 3);
		G.addEdge(3, 4);
		G.addEdge(4, 5);
		G.addEdge(5, 6);
		G.addEdge(6, 7);
		G.addEdge(7, 3);

		return G;
	}
}
