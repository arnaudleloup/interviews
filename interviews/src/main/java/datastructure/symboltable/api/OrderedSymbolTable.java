package datastructure.symboltable.api;

public interface OrderedSymbolTable<K extends Comparable<K>, V> extends SymbolTable<K, V> {

	/**
	 * Returns the smallest key.
	 */
	public K min();

	/**
	 * Returns the largest key.
	 */
	public K max();

	/**
	 * Returns the largest key less than or equal key.
	 */
	public K floor(K key);

	/**
	 * Returns the smallest key greater than or equal to key.
	 */
	public K ceiling(K key);

	/**
	 * Returns the number of keys less than key.
	 */
	public int rank(K key);

	/**
	 * Returns the key of rank k.
	 */
	public K select(int k);

	/**
	 * Delete the smallest key.
	 */
	public void deleteMin();

	/**
	 * Delete the largest key.
	 */
	public void deleteMax();

	/**
	 * Returns the number of keys in [lo..hi].
	 */
	public int size(K lo, K hi);

	/**
	 * Returns the keys in [lo..hi] in sorted order.
	 */
	public Iterable<K> keys(K lo, K hi);
}
