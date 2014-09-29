package exercice;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Datastructure supporting void add(int e) and int median() method
 * in O(log n) time.
 */
public class FindMedian {

	private final Queue<Integer> lesser;
	private final Queue<Integer> greater;
	public FindMedian() {
		lesser = new PriorityQueue<>(11, Collections.reverseOrder()); // max PQ
		greater = new PriorityQueue<>(); // min PQ
	}

	public void add(int e) {
		if (greater.isEmpty()) {
			greater.add(e);
			return;
		}

		if (e >= greater.peek()) {
			greater.add(e);
			if (greater.size() > lesser.size() + 1) {
				lesser.add(greater.poll());
			}
		} else {
			lesser.add(e);
			if (lesser.size() > greater.size() + 1) {
				greater.add(lesser.poll());
			}
		}
	}

	public int median() {
		if (greater.isEmpty()) {
			throw new UnsupportedOperationException();
		}

		if (lesser.isEmpty()) {
			return greater.peek();
		}

		if ((lesser.size() + greater.size()) % 2 == 0) {
			return (lesser.peek() + greater.peek()) / 2;
		} else {
			if (lesser.size() > greater.size()) {
				return lesser.peek();
			} else {
				return greater.peek();
			}
		}
	}
}