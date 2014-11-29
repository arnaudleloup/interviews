package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a set of Strings, return a set grouping all anagrams.
 * Example:
 * Input: {"cat", "dog", "tac", "god", "car"}
 * Output: {{"cat", "tac"}, {"dog", "god"}, {"car"}}
 */
public class AnagramsSet {

	/**
	 * n = set.size
	 * L = string average length
	 * 
	 * Time complexity: O(n * L * R)
	 * Space complexity: O(n)
	 */
	public static Set<Set<String>> f(Set<String> set, int R) {
		Map<CharFrequency, Set<String>> freqs = new HashMap<>();

		for (String s : set) {
			int L = s.length();
			CharFrequency freq = new CharFrequency(R);
			for (int i = 0; i < L; i++) {
				char c = s.charAt(i);
				freq.a[c]++;
			}

			if (!freqs.containsKey(freq)) {
				freqs.put(freq, new HashSet<String>()); // hashCode computation time complexity: O(R)
			}

			freqs.get(freq).add(s);
		}


		Set<Set<String>> anagrams = new HashSet<>();

		for (Set<String> s : freqs.values()) {
			anagrams.add(s);
		}

		return anagrams;
	}

	private static Map<Character, Integer> MAP = new HashMap<>();

	static {
		MAP.put('c', 2);
		MAP.put('a', 3);
		MAP.put('t', 5);
		MAP.put('d', 7);
		MAP.put('o', 11);
		MAP.put('g', 13);
		MAP.put('e', 17);
		MAP.put('z', 19);
	}

	/**
	 * n = set.size
	 * L = string average length
	 * 
	 * Time complexity: O(n * L)
	 * Space complexity: O(n)
	 */
	public static Set<Set<String>> f2(Set<String> set) {
		Map<Integer, Set<String>> anagrams = new HashMap<>();

		for(String s : set) {
			int hash = 1;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				hash *= MAP.get(c);
			}

			if (!anagrams.containsKey(hash)) {
				anagrams.put(hash, new HashSet<String>());
			}

			anagrams.get(hash).add(s);
		}

		Set<Set<String>> toRet = new HashSet<>();
		for (Set<String> s : anagrams.values()) {
			toRet.add(s);
		}

		return toRet;
	}

	/**
	 * n = set.size
	 * L = string average length
	 * 
	 * Time complexity: O(n * L)
	 * Space complexity: O(n)
	 */
	public static Set<Set<String>> f3(Set<String> set) {
		Map<String, Set<String>> anagrams = new HashMap<>();

		for(String s : set) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);

			if (!anagrams.containsKey(sorted)) {
				anagrams.put(sorted, new HashSet<String>());
			}

			anagrams.get(sorted).add(s);
		}

		Set<Set<String>> toRet = new HashSet<>();
		for (Set<String> s : anagrams.values()) {
			toRet.add(s);
		}

		return toRet;
	}

	private static class CharFrequency {

		int[] a;
		public CharFrequency(int R) {
			a = new int[R];
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(a);
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
			CharFrequency other = (CharFrequency) obj;
			if (!Arrays.equals(a, other.a)) {
				return false;
			}
			return true;
		}
	}
}