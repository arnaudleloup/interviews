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
	 * R = alphabet radix
	 * 
	 * Time complexity: O(n * L * R)
	 * Space complexity: O(n * L)
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

			if (!freqs.containsKey(freq)) { // time complexity: O(R)
				freqs.put(freq, new HashSet<String>());
			}

			freqs.get(freq).add(s);
		}


		Set<Set<String>> anagrams = new HashSet<>();

		for (Set<String> s : freqs.values()) {
			anagrams.add(s);
		}

		return anagrams;
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