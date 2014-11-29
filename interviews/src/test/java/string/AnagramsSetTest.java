package string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AnagramsSetTest {

	@Test
	public void test() {
		Set<String> set = new HashSet<>(Arrays.asList("cat", "dog", "tacc", "ez", "god", "tac", "ogd", "catc"));

		Set<Set<String>> expected = new HashSet<>();
		Set<String> anagrams1 = new HashSet<>();
		anagrams1.add("cat");
		anagrams1.add("tac");

		Set<String> anagrams2 = new HashSet<>();
		anagrams2.add("dog");
		anagrams2.add("god");
		anagrams2.add("ogd");

		Set<String> anagrams3 = new HashSet<>();
		anagrams3.add("ez");

		Set<String> anagrams4 = new HashSet<>();
		anagrams4.add("tacc");
		anagrams4.add("catc");

		expected.add(anagrams1);
		expected.add(anagrams2);
		expected.add(anagrams3);
		expected.add(anagrams4);

		assertEquals(expected, AnagramsSet.f(set, 128));
	}

	@Test
	public void test2() {
		Set<String> set = new HashSet<>(Arrays.asList("cat", "dog", "tacc", "ez", "god", "tac", "ogd", "catc"));

		Set<Set<String>> expected = new HashSet<>();
		Set<String> anagrams1 = new HashSet<>();
		anagrams1.add("cat");
		anagrams1.add("tac");

		Set<String> anagrams2 = new HashSet<>();
		anagrams2.add("dog");
		anagrams2.add("god");
		anagrams2.add("ogd");

		Set<String> anagrams3 = new HashSet<>();
		anagrams3.add("ez");

		Set<String> anagrams4 = new HashSet<>();
		anagrams4.add("tacc");
		anagrams4.add("catc");

		expected.add(anagrams1);
		expected.add(anagrams2);
		expected.add(anagrams3);
		expected.add(anagrams4);

		assertEquals(expected, AnagramsSet.f2(set));
	}

	@Test
	public void test3() {
		Set<String> set = new HashSet<>(Arrays.asList("cat", "dog", "tacc", "ez", "god", "tac", "ogd", "catc"));

		Set<Set<String>> expected = new HashSet<>();
		Set<String> anagrams1 = new HashSet<>();
		anagrams1.add("cat");
		anagrams1.add("tac");

		Set<String> anagrams2 = new HashSet<>();
		anagrams2.add("dog");
		anagrams2.add("god");
		anagrams2.add("ogd");

		Set<String> anagrams3 = new HashSet<>();
		anagrams3.add("ez");

		Set<String> anagrams4 = new HashSet<>();
		anagrams4.add("tacc");
		anagrams4.add("catc");

		expected.add(anagrams1);
		expected.add(anagrams2);
		expected.add(anagrams3);
		expected.add(anagrams4);

		assertEquals(expected, AnagramsSet.f3(set));
	}

}