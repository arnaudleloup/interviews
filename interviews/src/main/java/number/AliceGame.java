package number;

/**
 * 
 *  Alice and Kirito just played a game. The game consisted of a finite (possibly empty) sequence of turns.
 *  You do not know the exact number of turns. The turns were numbered starting from 1.
 *  In each turn, exactly one of our two players won.
 *  In the easy game, the winner of turn i scored i points.
 *  In the hard game, the winner of turn i scored 2 * i - 1 points.
 * 
 *  You are given two longs x and y.
 *  Find out whether it is possible that at the end of the game Alice had exactly x points and Kirito had exactly y points.
 *  If it is possible, return the smallest number of turns Alice could have won.
 *  If the given final result is not possible, return -1 instead.
 */
public class AliceGame {

	public static long findMinimumValueEasy(long x, long y) {
		long n = findTurnEasy(x + y);
		if (n == -1) {
			return -1;
		}

		return findAliceSmallestTurnEasy(n, x);
	}

	private static long findAliceSmallestTurnEasy(long n, long x) {
		long turn = 0;
		long points = 0;
		while (points != x) {
			turn++;
			points += n;
			long left = x - points;
			if (n - 1 <= left) {
				n--;
			} else {
				n = left;
			}
		}

		return turn;
	}

	private static long findTurnEasy(long v) {
		long delta = 1 + 8 * v;

		long sqrt = Double.valueOf(Math.sqrt(delta)).longValue();

		if (sqrt * sqrt != delta) {
			return -1;
		}

		if ((sqrt - 1) % 2 != 0) {
			return  -1;
		}

		return (sqrt - 1) / 2;
	}

	public static long findMinimumValueHard(long x, long y) {
		long n = findTurnHard(x + y);
		if (n == -1) {
			return -1;
		}

		return findAliceSmallestTurnHard(n, x);
	}

	private static long findAliceSmallestTurnHard(long n, long x) {
		long turn = 0;
		long points = 0;
		while (points != x) {
			turn++;
			points += 2 * n - 1;
			long left = x - points;
			if (2 * (n - 1) - 1 <= left) {
				n--;
			} else {
				n = (left + 1) / 2;
			}
		}

		return turn;
	}

	private static long findTurnHard(long v) {
		long sqrt = Double.valueOf(Math.sqrt(v)).longValue();

		if (sqrt * sqrt != v) {
			return -1;
		}

		return sqrt;
	}
}