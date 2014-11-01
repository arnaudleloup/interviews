package misc;

import static org.junit.Assert.assertEquals;
import misc.Mayor.Relationship;

import org.junit.Test;

public class MayorTest {

	private class Relationship1 implements Relationship {

		private final boolean[][] relationship;

		public Relationship1() {
			int n = people();
			relationship = new boolean[n][n];

			relationship[0][3] = true;
			relationship[1][3] = true;
			relationship[2][3] = true;
			relationship[3][3] = true;
			relationship[4][3] = true;

			relationship[0][0] = true;
			relationship[1][1] = true;
			relationship[2][2] = true;
			relationship[4][4] = true;

			relationship[0][4] = true;
			relationship[1][2] = true;
			relationship[2][1] = true;
			relationship[2][4] = true;
			relationship[4][0] = true;
		}

		@Override
		public int people() {
			return 5;
		}

		@Override
		public boolean knows(int i, int j) {
			return relationship[i][j];
		}
	}

	@Test
	public void test() {
		assertEquals(3, Mayor.f(new Relationship1()));
	}

}
