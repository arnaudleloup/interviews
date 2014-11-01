package misc;

/**
 * n citizens in a town want to elect a mayor.
 * The mayor must be known by everybody, but must know no one.
 */
public class Mayor {
	public interface Relationship {
		public int people();
		public boolean knows(int i, int j);
	}

	/**
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 */
	public static int f(Relationship relationship) {
		int n = relationship.people();
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (relationship.knows(candidate, i)) { // if candidate knows i, candidate can not be the mayor
				candidate = i;
			}
		}

		// check that the last candidate can be the mayor
		for (int i = 0; i < n; i++) {
			if (!relationship.knows(i,  candidate)) {
				return -1;
			}

			if (candidate != i && relationship.knows(candidate, i)) {
				return -1;
			}
		}

		return candidate;
	}
}