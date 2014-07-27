package number;

import static org.junit.Assert.assertEquals;

import number.Exercices;

import org.junit.Test;

public class ExercicesTest {

	@Test
	public void test0() {
		int[] t = {1, 2, 3, 4};
		int expected = 2;
		assertEquals(expected, Exercices.find(t));
	}

	@Test
	public void test1() {
		int[] t = {900, 2, 901, 3, 1000};
		int expected = 3;
		assertEquals(expected, Exercices.find(t));
	}

	@Test
	public void test2() {
		int[] t = {900, 2, 901, 3, 1000, 500};
		int expected = 4;
		assertEquals(expected, Exercices.find(t));
	}
}