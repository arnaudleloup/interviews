package misc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack which can return the max element.
 * Time complexity of add, pop, and max methods: O(1)
 */
public class MaxStack {

	private final Deque<Integer> stack = new ArrayDeque<>();
	private final Deque<Integer> maxs = new ArrayDeque<>();

	public void add(int e) {
		stack.addLast(e);

		if (maxs.isEmpty() || maxs.getLast() <= e) {
			maxs.addLast(e);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int e = stack.removeLast();

			if (maxs.getLast() == e) {
				maxs.removeLast();
			}
		}
	}

	public int max() {
		if (maxs.isEmpty()) {
			throw new UnsupportedOperationException();
		}

		return maxs.getLast();
	}
}