package datastructure.heap;

public class MinHeap<E extends Comparable<E>> extends AbstractHeap<E> {

	public E delMin() {
		return delFirst();
	}

	public E getMin() {
		return getFirst();
	}

	@Override
	protected boolean less(E[] t, int i, int j) {
		return t[i].compareTo(t[j]) > 0;
	}
}