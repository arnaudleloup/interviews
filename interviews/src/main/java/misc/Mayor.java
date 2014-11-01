package misc;

/**
 * n citizens in a town want to elect a mayor.
 * The mayor must be known by everybody, but must known no one.
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
		int prev = 0;
		for (int i = 1; i < n; i++) {
			if (relationship.knows(prev, i)) {
				prev = i;
			}
		}

		for (int i = 0; i < n; i++) {
			if (!relationship.knows(i,  prev)) {
				return -1;
			}
		}

		return prev;
	}
}