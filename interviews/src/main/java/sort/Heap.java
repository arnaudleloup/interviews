package sort;

public class Heap<E extends Comparable<E>> {

	private final static int INITIAL_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private E[] t = (E[]) new Comparable[INITIAL_CAPACITY];
	private int N = 0;
	private E min;

	/**
	 * O(nlog(n)) / O(1)
	 */
	public void sort(E[] a) {
		int N = a.length;
		for (int i = N /2; i >= 0; i--) { // build heap
			sink(a, i, N);
		}

		while (N > 0) { // sort
			swap(a, 0, --N);
			sink(a, 0, N);
		}
	}

	public void insert(E e) {
		t[N] = e;
		swim(N);

		if (isEmpty()) {
			min = e;
		} else if (e.compareTo(min) < 0) {
			min = e;
		}

		if (++N	== t.length) {
			resize(2 * t.length);
		}
	}

	public E delMax() {
		E e = t[0];
		swap(0, N - 1);
		t[--N] = null;
		sink(0);


		if (N == t.length / 4) {
			resize(t.length / 2);
		}

		return e;
	}

	public E getMax() {
		return t[0];
	}

	public E getMin() {
		return isEmpty() ? null : min;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	private void swim(int i) {
		while  (i != 0 && less(getParent(i), i)) {
			swap(getParent(i), i);
			i = getParent(i);
		}
	}

	private void sink(int i) {
		sink(t, i, N);
	}

	private void sink(E[] t, int i, int N) {
		while (2 * i + 1 < N) {
			int j = 2 * i + 1;
			if (j + 1 < N && less(t, j, j + 1)) {
				j++;
			}

			if (less(t, j, i)) {
				break;
			}

			swap(t, i, j);
			i = j;
		}
	}

	private int getParent(int i) {
		if (i % 2== 0) {
			return i / 2 - 1;
		} else {
			return i / 2;
		}
	}

	private void resize(int size) {
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Comparable[size];

		for (int i = 0; i < N; i++) {
			temp[i] = t[i];
		}

		t = temp;
	}

	private boolean less(int i, int j) {
		return less(t, i, j);
	}

	private boolean less(E[] t, int i, int j) {
		return t[i].compareTo(t[j]) < 0;
	}

	private void swap(int i, int j) {
		swap(t, i, j);
	}

	private void swap(E[] t, int i, int j) {
		E temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}
}