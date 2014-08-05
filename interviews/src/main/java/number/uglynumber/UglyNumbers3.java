package number.uglynumber;

import java.util.LinkedList;
import java.util.List;

public class UglyNumbers3 {

	/**
	 * Numbers whose only prime factors are 2, 3, 5 or 7 are called ugly numbers.
	 * Generate the first k ugly numbers (in increasing order).
	 * 1 is considered the first.
	 * So the sequence starts with 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14...
	 */
	public static int[] f(int k) {
		int[] t = new int[k];
		t[0] = 1;

		LinkedList<Integer> two = new LinkedList<>();
		two.add(2);

		LinkedList<Integer> three = new LinkedList<>();
		three.add(3);

		LinkedList<Integer> five = new LinkedList<>();
		five.add(5);


		LinkedList<Integer> seven = new LinkedList<>();
		seven.add(7);

		int i = 1;
		while (i < k) {
			int min = 0;

			if(two.getFirst() < three.getFirst()
					&& two.getFirst() < five.getFirst()
					&& two.getFirst() < seven.getFirst()) {
				min = two.poll();
				add(two, min * 2);
				add(two, min * 3);
				add(two, min * 5);
				add(two, min * 7);
			} else if(three.getFirst() < five.getFirst() && three.getFirst() <seven.getFirst()) {
				min = three.poll();
				add(three, min * 3);
				add(three, min * 5);
				add(three, min * 7);
			} else if(five.getFirst() < seven.getFirst()) {
				min = five.poll();
				add(five, min * 5);
				add(five, min * 7);
			} else {
				min = seven.poll();
				seven.add(min * 7);
			}

			t[i] = min;
			i++;
		}

		return t;
	}

	/**
	 * Add an element to the linked list and maintains the order by binary search.
	 * 
	 * O(log(n)) time, O(1) space
	 */
	private static void add(LinkedList<Integer> lnk, int e) {
		int index = BS(lnk, 0, lnk.size(), e);
		if (index != -1) {
			lnk.add(index, e);
		}
	}

	private static int BS(List<Integer> list, int min, int max, int e) {
		if (min == max) {
			return min;
		}

		int m = (min + max) / 2;

		if (list.get(m) == e) {
			return -1;
		}
		if (list.get(m) < e) {
			if (m == list.size() - 1 || list.get(m + 1) > e) {
				return m + 1;
			}

			return BS(list, m, max, e);
		}

		if (m == 0 || list.get(m - 1) < e) {
			return m;
		}

		return BS(list, min, m, e);
	}
}