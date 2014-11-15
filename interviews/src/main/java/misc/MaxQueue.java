package misc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * FIFO queue which can return the max element.
 * Time complexity of add, pop, and max methods: O(1)
 */
public class MaxQueue {

	private final Deque<Integer> queue = new ArrayDeque<>();
	private final Deque<Integer> maxs = new ArrayDeque<>();

	public void add(int e) {
		queue.addFirst(e);

		while (!maxs.isEmpty() && e > maxs.peekFirst()) {
			maxs.removeFirst();
		}

		maxs.addFirst(e);
	}

	public void pop() {
		if (!queue.isEmpty()) {
			int e = queue.removeLast();

			if (maxs.getLast() == e) {
				maxs.removeLast();
			}
		}
	}

	public Integer max() {
		if (maxs.isEmpty()) {
			return null;
		}

		return maxs.getLast();
	}
}