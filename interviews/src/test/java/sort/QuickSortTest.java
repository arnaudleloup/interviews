package sort;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest extends AbstractSortTest {

	@Test
	public void test() {
		int[] a = getUnsortedArray(1000);
		QuickSort.sort(a);
		if (!isSorted(a)) {
			fail(Arrays.toString(a));
		}
	}
}