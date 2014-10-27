package string;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WordToWordTest {

	@Test
	public void test() {
		Set<String> dictionnary = dictionnary();
		assertEquals(4, WordToWord.f(dictionnary, "DAMP", "LIKE"));
		assertEquals(2, WordToWord.f(dictionnary, "HOUSE", "TORSE"));
		assertEquals(3, WordToWord.f(dictionnary, "HOUSE", "TOISE"));
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