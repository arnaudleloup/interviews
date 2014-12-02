package array;



public class FindMissingElement {

	/**
	 * Given an unsorted array containing all element from 1 through n except one,
	 * find the missing element.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static int missOne(int[] a) {
		int sum = 0;
		for (int e : a) {
			sum += e;
		}

		int n = a.length;
		int expectedSum = (n + 1) * (n + 2) / 2;
		return expectedSum - sum;
	}


	//	/**
	//	 * Given an unsorted array containing all element from 1 through n except two,
	//	 * find the missing pair of elements.
	//	 *
	//	 * Time complexity: O(n)
	//	 * Space complexity: O(1)
	//	 */
	//	public static Pair<Integer, Integer> missTwo(int[] a) {
	//		int sum = 0;
	//		int squareSum = 0;
	//
	//		for (int e : a) {
	//			sum += e;
	//			squareSum += e * e;
	//		}
	//
	//		int n = a.length;
	//		int expectedSum = (n + 1) * (n + 2) / 2;
	//		int expectedSquareSum = (n + 1) * (n + 2) * (2 *n + 3) / 6;
	//
	//		int j = (expectedSum - sum + Double.valueOf(Math.sqrt(sum * sum + expectedSquareSum - squareSum)).intValue()) / 2;
	//		int i = expectedSum - sum - j;
	//
	//		if (i < j) {
	//			return new Pair<Integer, Integer>(i, j);
	//		} else {
	//			return new Pair<Integer, Integer>(j, i);
	//		}
	//	}
}