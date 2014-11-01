package math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * n points in a plane are given,
 * returns the maximal set of points in the same line.
 */
public class MaxLine {

	public static Set<Point> f(Set<Point> points) {
		Map<VerticalLine, Set<Point>> lines = new HashMap<>();
		Set<Point> max = new HashSet<>();
		for (Point p1 : points) {
			for (Point p2 : points) {
				if (!p1.equals(p2)) {
					VerticalLine line;
					if (p1.x == p2.x) {
						line = new VerticalLine(p1.x);
					} else {
						double a = ((double) (p1.y - p2.y)) / (p1.x - p2.x);
						double b = p1.y - a * p1.x;
						line = new Line(a, b);
					}

					if (!lines.containsKey(line)) {
						lines.put(line, new HashSet<Point>());
					}

					lines.get(line).add(p1);
					lines.get(line).add(p2);

					if (lines.get(line).size() > max.size()) {
						max = lines.get(line);
					}
				}
			}
		}

		return max;
	}

	public static class VerticalLine {
		double a;

		public VerticalLine(double a) {
			this.a = a;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(a);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			VerticalLine other = (VerticalLine) obj;
			if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "VerticalLine [a=" + a + "]";
		}
	}

	public static class Line extends VerticalLine {
		double b;

		public Line(double a, double b) {
			super(a);
			this.b = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			long temp;
			temp = Double.doubleToLongBits(b);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!super.equals(obj)) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Line other = (Line) obj;
			if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Line [b=" + b + "]";
		}
	}



	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Point other = (Point) obj;
			if (x != other.x) {
				return false;
			}
			if (y != other.y) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}