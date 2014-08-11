package sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import datastructure.heap.MaxHeap;
import datastructure.heap.MinHeap;

public class HeapTest {
	private final Random r = new Random();

	@Test
	public void testBuildMaxHeap() {
		MaxHeap<Integer> heap = new MaxHeap<>();

		for (int i = 0; i < 200; i++) {
			heap.insert(nextRandom());
		}

		int p = heap.delMax();
		while (!heap.isEmpty()) {
			int c = heap.delMax();
			assertTrue(p >= c);
			p = c;
		}
	}

	@Test
	public void testBuildMinHeap() {
		MinHeap<Integer> heap = new MinHeap<>();

		for (int i = 0; i < 200; i++) {
			heap.insert(nextRandom());
		}

		int p = heap.delMin();
		while (!heap.isEmpty()) {
			int c = heap.delMin();
			assertTrue(p <= c);
			p = c;
		}
	}

	@Test
	public void testMaxHeapSort() {
		Integer[] t = new Integer[100];
		for (int i = 0; i < t.length; i++) {
			t[i] = nextRandom();
		}

		new MaxHeap<Integer>().sort(t);

		for (int i = 1; i < t.length; i++) {
			assertTrue(Arrays.toString(t), t[i] >= t[i - 1]);
		}
	}

	@Test
	public void testMinHeapSort() {
		Integer[] t = new Integer[100];
		for (int i = 0; i < t.length; i++) {
			t[i] = nextRandom();
		}

		new MinHeap<Integer>().sort(t);

		for (int i = 1; i < t.length; i++) {
			assertTrue(Arrays.toString(t), t[i] <= t[i - 1]);
		}
	}

	private int nextRandom() {
		return r.nextInt(100);
	}
}
