package math;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import math.MaxLine.Point;

import org.junit.Test;

public class MaxLineTest {

	@Test
	public void test() {
		Set<Point> points = new HashSet<>(Arrays.asList(
				new Point(1, 1),
				new Point(2, 18),
				new Point(3, 7),
				new Point(2, 2),
				new Point(1, 4),
				new Point(4, 4),
				new Point(6, 4),
				new Point(3, 9),
				new Point(9, 4),
				new Point(8, 8)
				));

		Set<Point> expected = new HashSet<>(Arrays.asList(
				new Point(1, 1),
				new Point(2, 2),
				new Point(4, 4),
				new Point(8, 8)
				));



		assertEquals(expected, MaxLine.f(points));
	}
}