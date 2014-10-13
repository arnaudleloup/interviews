package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import lib.Pair;
/**
 * Given a BST and a value x, find two nodes in the tree whose sum is equal to x.
 * It is not allowed to modify the tree.
 * 
 * Time complexity : O(n)
 * Space complexity : O(height(tree))
 */
public class BSTSum {
	private Node root;

	public BSTSum(int[] values) {
		for (int e : values) {
			add(e);
		}
	}

	public Pair<Integer, Integer> sum(int x) {
		Deque<Node> lo = new ArrayDeque<>();
		addLeft(root, lo);

		Deque<Node> hi = new ArrayDeque<>();
		addRight(root, hi);

		// used to know if a right branch or a left branch has already been visited
		Map<Node, Boolean> rightDone = new HashMap<>();
		Map<Node, Boolean> leftDone = new HashMap<>();

		while (lo.peekLast().value <= hi.peekLast().value) {
			int currentValue = lo.peekLast().value + hi.peekLast().value;

			if (currentValue < x) {
				Node currentNode = lo.peekLast();

				if (!rightDone.containsKey(currentNode) && currentNode.right != null) {
					addLeft(currentNode.right, lo);
					rightDone.put(currentNode, true);
				} else {
					lo.pollLast();
					rightDone.remove(currentNode);
				}
			} else if (currentValue == x) {
				return new Pair<Integer, Integer>(lo.peekLast().value, hi.peekLast().value);
			} else {
				Node currentNode = hi.peekLast();

				if (!leftDone.containsKey(currentNode) && currentNode.left != null) {
					addRight(currentNode.left, hi);
					leftDone.put(currentNode, true);
				} else {
					hi.pollLast();
					leftDone.remove(currentNode);
				}
			}
		}

		return null;
	}

	/**
	 * Add a value to this BST.
	 */
	public void add(int value) {
		root = add(root, value);
	}

	private Node add(Node node, int value) {
		if (node == null) {
			return new Node(value, null, null);
		}

		if (node.value < value) {
			node.right = add(node.right, value);
		} else if (node.value > value) {
			node.left = add(node.left, value);
		}

		return node;
	}

	/**
	 * Add recursively all nodes to the right to the given deque
	 */
	private void addRight(Node node, Deque<Node> deque) {
		if (node != null) {
			deque.add(node);
			addRight(node.right, deque);
		}
	}

	/**
	 * Add recursively all nodes to the left to the given deque
	 */
	private void addLeft(Node node, Deque<Node> deque) {
		if (node != null) {
			deque.add(node);
			addLeft(node.left, deque);
		}
	}

	private class Node {
		int value;
		Node right;
		Node left;

		public Node(int value, Node right, Node left) {
			this.value = value;
			this.right = right;
			this.left = left;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", right=" + right + ", left=" + left + "]";
		}
	}
}