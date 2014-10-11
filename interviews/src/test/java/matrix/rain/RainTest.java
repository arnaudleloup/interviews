package matrix.rain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RainTest {

	@Test
	public void test() {
		int[][] heights = {
				{1, 2},
				{8, 4}
		};

		RainState[][] states = Rain.f(heights);


		assertEquals(RainState.PACIFIC, states[0][0]);
		assertEquals(RainState.BOTH, states[0][1]);
		assertEquals(RainState.BOTH, states[1][0]);
		assertEquals(RainState.BOTH, states[1][1]);
	}

	@Test
	public void test2() {
		int[][] heights = {
				{2, 4, 11, 5},
				{11, 10, 10, 13},
				{11, 10, 10, 18},
				{11, 8, 2, 3}
		};

		RainState[][] states = Rain.f(heights);

		assertEquals(RainState.PACIFIC, states[0][0]);
		assertEquals(RainState.PACIFIC, states[0][1]);
		assertEquals(RainState.BOTH, states[0][2]);
		assertEquals(RainState.BOTH, states[0][3]);

		assertEquals(RainState.PACIFIC, states[1][0]);
		assertEquals(RainState.PACIFIC, states[1][1]);
		assertEquals(RainState.NONE, states[1][2]);
		assertEquals(RainState.BOTH, states[1][3]);

		assertEquals(RainState.BOTH, states[2][0]);
		assertEquals(RainState.ATLANTIC, states[2][1]);
		assertEquals(RainState.ATLANTIC, states[2][2]);
		assertEquals(RainState.BOTH, states[2][3]);

		assertEquals(RainState.BOTH, states[3][0]);
		assertEquals(RainState.ATLANTIC, states[3][1]);
		assertEquals(RainState.ATLANTIC, states[3][2]);
		assertEquals(RainState.ATLANTIC, states[3][3]);
	}


}