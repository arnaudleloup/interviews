package exercice;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TrimTest {

	@Test
	public void test() {
		char[] c = {' ', ' ' , ' ', 'H', 'E', 'L', 'L', 'O', ' ', ' ', ' ',
				'W', 'O', 'R', 'L', 'D', ' ', ' ', ' '};

		char[] expected ={'H', 'E', 'L', 'L', 'O', ' ',
				'W', 'O', 'R', 'L', 'D', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

		Trim.trim(c);
		assertTrue(Arrays.toString(c), Arrays.equals(expected, c));
	}
}
