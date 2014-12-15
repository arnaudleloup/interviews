package number;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
	 * Time complexity: O(n^2)
	 * Space complexity: O(n^2)
	 */
	public static int[] f(int n) {
		int[] a = new int[(n + 1) * (n + 2) / 2];
		int index = 0;
		for(int i = 0; i <= n; i++) {
			int p = i * i * i;
			for (int j = 0; j <= i; j++) {
				int q = j * j * j;
				a[index++] = p + q;
			}
		}

		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		return a;
	}

	/**
	 * Time complexity: O(n^2 * log(n))
	 * Space complexity: O(n)
	 */
	public static int[] f2(int n) {
		PriorityQueue<Element> pq = new PriorityQueue<>(n, new Element.Comp());
		for (int i = 0; i <= n; i++) {
			pq.add(new Element(i * i * i, i, 0));
		}

		int[] a = new int[(n + 1) * (n + 2) / 2];
		int index = 0;
		while (!pq.isEmpty()) {
			Element e = pq.poll();
			System.out.println(e.value);
			a[index++] = e.value;
			int i = e.i;
			int j = e.j;
			if (j < i) {
				int newValue = i * i * i + (j + 1) * (j + 1) * (j + 1);
				pq.add(new Element(newValue, i, j + 1));
			}
		}

		return a;
	}

	private static class Element {
		int value;
		int i;
		int j;

		public Element(int value, int i, int j) {
			this.value = value;
			this.i = i;
			this.j = j;
		}

		private static class Comp implements Comparator<Element> {

			@Override
			public int compare(Element e1, Element e2) {
				if (e1.value < e2.value) {
					return -1;
				} else if (e1.value == e2.value) {
					return 0;
				} else {
					return 1;
				}
			}
		}
	}
}