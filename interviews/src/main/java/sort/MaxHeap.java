package sort;

public class MaxHeap<E extends Comparable<E>> extends AbstractHeap<E> {

	public E delMax() {
		return delFirst();
	}

	public E getMax() {
		return getFirst();
	}

	@Override
	protected boolean less(E[] t, int i, int j) {
		return t[i].compareTo(t[j]) < 0;
	}
}