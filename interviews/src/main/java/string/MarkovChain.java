package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * Markov chain to predict the next word based on a training corpus.
 * 
 * For example, based on the text "it was the best of times it was the worst of times",
 * then we would have the following model:
 * it -> was (100%)
 * was -> the (100%)
 * the -> best (50%), worst (50%)
 * best -> of (100%)
 * etc.
 *
 * The public API should look like:
 * class MarkovChain
 *   void addWord(String word);
 *   String nextWord(String word);
 *
 * And will be used in training as follows:
 *   mc = new MarkovChain();
 *   mc.addWord("it");
 *   mc.addWord("was");
 *   mc.addWord("the");
 *   mc.addWord("best");
 *   mc.addWord("of");
 *   mc.addWord("times");
 *   mc.addWord("it");
 *   mc.addWord("was");
 *   ...
 *
 * And at run time as follows:
 * mc.nextWord("it") -> "was"  // always
 * mc.nextWord("the") -> "best" OR "worst"  // distributed evenly
 */
public class MarkovChain {

	private String last;
	private final Map<String, Map<String, Integer>> nodes = new HashMap<>();

	/**
	 * Time complexity : O(1)
	 */
	public void addWord(String word) {
		if (last == null) {
			last = word;
			return;
		}

		if (!nodes.containsKey(last)) {
			nodes.put(last, new HashMap<String, Integer>());
		}

		if (!nodes.get(last).containsKey(word)) {
			nodes.get(last).put(word, 1);
		} else {
			Map<String, Integer> next = nodes.get(last);
			next.put(word, next.get(word) + 1);
		}

		last = word;
	}

	/**
	 * Time complexity : O(n)
	 */
	public String nextWord(String word) {
		if (!nodes.containsKey(word)) {
			return null;
		}

		int n = 0;
		for (int freq : nodes.get(word).values()) {
			n += freq;
		}

		String next = null;
		int r = new Random().nextInt(n);
		int acc = 0;
		for (Entry<String, Integer> entry : nodes.get(word).entrySet()) {
			acc += entry.getValue();
			if (acc >= r) {
				next = entry.getKey();
				break;
			}
		}

		return next;
	}
}