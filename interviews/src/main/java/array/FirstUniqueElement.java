package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Given a stream of elements, find in a single pass the first unique element.
 */
public class FirstUniqueElement {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int f(int[] a) {
		Node first = null;
		Node last = null;
		Map<Integer, Node> map = new HashMap<>();
		Set<Integer> seen = new HashSet<>();

		for (int e : a) {
			if (map.containsKey(e)) {
				Node node = map.get(e);
				if (node.previous != null) {
					node.previous.next = node.next;
				} else {
					first = first.next;
				}

				map.remove(e);
			} else if (!seen.contains(e)) {
				Node node = new Node(e);

				if (first == null) {
					first = node;
					last = node;
				} else {
					last.next = node;
					last = node;
				}
				map.put(e, node);

				seen.add(e);
			}
		}

		return first == null ? - 1 : first.value;
	}

	private static class Node {
		int value;
		Node previous;
		Node next;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result
					+ ((previous == null) ? 0 : previous.hashCode());
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Node other = (Node) obj;
			if (next == null) {
				if (other.next != null) {
					return false;
				}
			} else if (!next.equals(other.next)) {
				return false;
			}
			if (previous == null) {
				if (other.previous != null) {
					return false;
				}
			} else if (!previous.equals(other.previous)) {
				return false;
			}
			if (value != other.value) {
				return false;
			}
			return true;
		}
	}
}