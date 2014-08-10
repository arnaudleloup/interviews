package number;

import java.util.Arrays;

import sort.MinHeap;

/**
 * Write a program that prints out all integers of the form a^3 + b^3 where a and b are integers
 * between 0 and n in sorted order, wihtout using excessive space.
 * That is, instead of computing an array of the N² sums and sorting them, build a
 * minimum-oriented priority queue, initially containing (0^3, 0, 0), (1^3, 1, 0),
 * (2^3, 2, 0), ..., (n^3, n, 0). Then, while the priority queue is nonempty,
 * remove the smallest item (i^3 + j^3, i, j), print it, and then, if j < n insert the item
 * (i^3 + (i + j)^3, i, j + 1).
 *
 */
public class ComputeCube {

	/**
	 * O(n²) / O(n²)
	 */
	public static void f(int n) {
		int[] t = new int[(n + 1) * (n + 2) / 2];
		int index = 0;
		for (int i = 0; i <= n; i++) {
			int a = i * i * i;
			for (int j = 0; j <=i; j++) {
				t[index++] = a + j * j * j;
			}
		}

		Arrays.sort(t);
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + " ");
		}

		System.out.println();
	}

	/**
	 * O(n²log(n)) / O(n)
	 */
	public static void f2(int n) {
		MinHeap<Tuple> heap = new MinHeap<>();

		for (int i = 0; i <= n; i++) {
			heap.insert(new Tuple(i, 0));
		}

		while (!heap.isEmpty()) { // O(n²) numbers
			Tuple t = heap.delMin();
			if (t.j < t.i) {
				heap.insert(new Tuple(t.i, t.j + 1)); // O(log(n)) to insert
			}

			System.out.print(t.v + " ");
		}

		System.out.println();
	}

	private static class Tuple implements Comparable<Tuple> {
		int v;
		int i;
		int j;

		public Tuple(int i, int j) {
			this.v = i * i * i + j * j * j;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Tuple o) {
			return Integer.valueOf(v).compareTo(Integer.valueOf(o.v));
		}
	}
}