package string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WordToWordTest {

	@Test
	public void test() {
		Set<String> dictionnary = dictionnary();
		assertEquals(Arrays.asList("DAMP", "LAMP", "LIMP", "LIME", "LIKE"), WordToWord.f(dictionnary, "DAMP", "LIKE"));
		assertEquals(Arrays.asList("HOUSE", "HORSE", "TORSE"), WordToWord.f(dictionnary, "HOUSE", "TORSE"));
		assertEquals(Arrays.asList("HOUSE", "HORSE", "TORSE", "TOISE"), WordToWord.f(dictionnary, "HOUSE", "TOISE"));
		assertEquals(Arrays.asList("SMOKE"), WordToWord.f(dictionnary, "SMOKE", "SMOKE"));
	}

	private Set<String> dictionnary() {
		Set<String> dictionnary = new HashSet<>();

		dictionnary.add("DAMP");
		dictionnary.add("LAMP");
		dictionnary.add("LIMP");
		dictionnary.add("LIME");
		dictionnary.add("LIKE");
		dictionnary.add("HOUSE");
		dictionnary.add("CAT");
		dictionnary.add("SMOKE");
		dictionnary.add("ART");
		dictionnary.add("HORSE");
		dictionnary.add("MORSE");
		dictionnary.add("MOISE");
		dictionnary.add("TOISE");
		dictionnary.add("TORSE");

		return dictionnary;
	}
}