package datastructure.symboltable.api;

public interface SymbolTable<K, V> {

	/**
	 * Put key-value pair into the table (remove key from table if value is null)
	 */
	public void put(K key, V value);

	/**
	 * Returns the value paired with key.
	 */
	public V get(K key);

	/**
	 * Removes key (and its value) from table.
	 */
	public void delete(K key);

	/**
	 * Is there a value paired with key?
	 */
	public boolean contains(K key);

	/**
	 * Is the table empty?
	 */
	public boolean isEmpty();

	/**
	 * Number of key-value pairs in the table.
	 */
	public int size();

	/**
	 * All the keys in the table.
	 */
	public Iterable<K> keys();
}