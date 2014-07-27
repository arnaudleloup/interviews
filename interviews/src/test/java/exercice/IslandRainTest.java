package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IslandRainTest {

	@Test
	public void testComplex1() {
		int[] heights = {1, 2, 3, 5, 1, 0, 2, 5, 4, 5, 3, 2, 3, 2, 1, 0, 0, 0, 2};
		int expected = 21;
		int actual = IslandRain.f(heights);
		assertEquals(expected, actual);
	}

	@Test
	public void testAscending() {
		int[] heights = {1, 2, 3, 5};
		int expected = 0;
		int actual = IslandRain.f(heights);
		assertEquals(expected, actual);
	}

	@Test
	public void testDescending() {
		int[] heights = {5, 4, 3, 2, 1};
		int expected = 0;
		int actual = IslandRain.f(heights);
		assertEquals(expected, actual);
	}

	@Test
	public void testTopPic() {
		int[] heights = {1, 2, 3, 5, 1, 0};
		int expected = 0;
		int actual = IslandRain.f(heights);
		assertEquals(expected, actual);
	}

	@Test
	public void testBottomPic() {
		int[] heights = {5, 3, 1, 3, 5};
		int expected = 8;
		int actual = IslandRain.f(heights);
		assertEquals(expected, actual);
	}

	@Test
	public void testPlatform() {
		int[] heights = {5, 5, 5, 5, 3, 1, 3, 5};
		int expected = 8;
		int actual = IslandRain.f(heights);
		assertEquals(expected, actual);
	}
}