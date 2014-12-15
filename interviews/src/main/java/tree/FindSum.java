package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;

import lib.Pair;

/**
 * Given a BST and a value x, find two nodes in the tree whose sum is equal to x.
 * It is not allowed to modify the tree
 */
public class FindSum {

	/**
	 * Time complexity: O(n * log(n))
	 * Space complexity: O(1)
	 */
	public static Pair<Integer, Integer> f(NavigableSet<Integer> t, int x) {
		Pair<Integer, Integer> pair = null;

		int lo = t.first();
		int hi = t.last();

		while (lo <= hi) {
			if (lo + hi == x) {
				pair = new Pair<>(lo, hi);
				break;
			} else if (lo + hi < x) {
				Integer higher = t.higher(lo);
				if (higher == null) {
					break;
				}
				lo = higher;
			} else {
				Integer lower = t.lower(hi);
				if (lower == null) {
					break;
				}
				hi = lower;
			}
		}

		return pair;
	}

	private Node root;

	public FindSum(int[] a) {
		for (int e : a) {
			add(e);
		}
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public Pair<Integer, Integer> find(int x) {
		Deque<Node> loStack = new ArrayDeque<>();
		Node lo = min(root, loStack);
		Deque<Node> hiStack = new ArrayDeque<>();
		Node hi = max(root, hiStack);

		Set<Node> rightSeen = new HashSet<>();
		Set<Node> leftSeen = new HashSet<>();

		while (lo.val <= hi.val) {
			if (lo.val + hi.val == x) {
				return new Pair<Integer, Integer>(lo.val, hi.val);
			}

			if (lo.val + hi.val < x) {
				if (lo.right == null || rightSeen.contains(lo)) {
					lo = loStack.removeLast();
				} else {
					rightSeen.add(lo);
					lo = min(lo.right, loStack);
				}
			} else {
				if (hi.left == null || leftSeen.contains(hi)) {
					hi = hiStack.removeLast();
				} else {
					leftSeen.add(hi);
					hi = max(hi.left, hiStack);
				}
			}
		}

		return null;
	}

	private Node min(Node x, Deque<Node> stack) {
		Node t = x;
		while (t.left != null) {
			stack.addLast(t);
			t = t.left;
		}
		stack.addLast(t);

		return t;
	}

	private Node max(Node x, Deque<Node> stack) {
		Node t = x;
		while (t.right != null) {
			stack.addLast(t);
			t = t.right;
		}
		stack.addLast(t);

		return t;
	}

	private void add(int v) {
		root = add(root, v);
	}

	private Node add(Node x, int v) {
		if (x == null) {
			return new Node(v);
		}

		if (x.val < v) {
			x.right = add(x.right, v);
		} else if (x.val > v) {
			x.left = add(x.left, v);
		}

		return x;
	}

	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}
}