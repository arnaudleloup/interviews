package number.uglynumber;

import java.util.HashSet;
import java.util.Set;

import sort.MinHeap;

/**
 * Numbers whose only prime factors are 2, 3, 5 or 7 are called ugly numbers.
 * Generate the first k ugly numbers (in increasing order).
 * 1 is considered the first.
 * So the sequence starts with 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14...
 * 
 * O(klog(k)) / O(k)
 */
public class UglyNumbers2 {

	public static long[] f(int k) {
		long[] t = new long[k];
		int index = 0;
		Set<Long> done = new HashSet<>(); // O(k) space
		MinHeap<Tuple> heap = new MinHeap<>(); // O(k) space
		heap.insert(new Tuple(0, 0, 0, 0));

		while (index < k) { // O(klog(k)) time
			Tuple tuple = heap.delMin(); // O(1)

			Tuple t1 = new Tuple(tuple.i + 1, tuple.j, tuple.k, tuple.l);
			Tuple t2 = new Tuple(tuple.i, tuple.j + 1, tuple.k, tuple.l);
			Tuple t3 = new Tuple(tuple.i, tuple.j, tuple.k + 1, tuple.l);
			Tuple t4 = new Tuple(tuple.i, tuple.j, tuple.k, tuple.l + 1);

			if (!done.contains(t1.v)) {
				heap.insert(t1); // O(log(n)) time
				done.add(t1.v);
			}

			if (!done.contains(t2.v)) {
				heap.insert(t2);
				done.add(t2.v);
			}

			if (!done.contains(t3.v)) {
				heap.insert(t3);
				done.add(t3.v);
			}

			if (!done.contains(t4.v)) {
				heap.insert(t4);
				done.add(t4.v);
			}

			t[index++] = tuple.v;
		}

		return t;
	}

	private static class Tuple implements Comparable<Tuple> {
		long v;
		int i;
		int j;
		int k;
		int l;

		public Tuple(int i, int j, int k, int l) {
			this.v = (long) (Math.pow(2, i) * Math.pow(3, j) * Math.pow(5,  k) * Math.pow(7, l));
			this.i = i;
			this.j = j;
			this.k = k;
			this.l = l;
		}

		@Override
		public int compareTo(Tuple o) {
			return Long.valueOf(v).compareTo(Long.valueOf(o.v));
		}

		@Override
		public String toString() {
			return "Tuple [v=" + v + ", i=" + i + ", j=" + j + ", k=" + k
					+ ", l=" + l + "]";
		}
	}
}