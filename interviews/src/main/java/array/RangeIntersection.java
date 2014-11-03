package array;

import java.util.Arrays;

public class RangeIntersection {

	public static int[] f(int[][] ranges) {
		int n = ranges.length;
		Endpoint[] endpoints = new Endpoint[2 * n];
		for (int i = 0; i < n; i++) {
			endpoints[2 * i] = new Endpoint(Endpoint.Type.START, i, ranges[i][0]);
			endpoints[2 * i + 1] = new Endpoint(Endpoint.Type.FINISH, i, ranges[i][1]);
		}
		Arrays.sort(endpoints);

		int startCount = 0;
		int finishCount = 0;

		for (int i = 0; i < 2 * n; i++) {
			Endpoint endpoint = endpoints[i];
			if (Endpoint.Type.START == endpoint.type) {
				endpoint.count = -(finishCount + 1);
				startCount++;
			} else {
				endpoint.count = startCount;
				finishCount++;
			}
		}

		int[] intersections = new int[n];
		for (Endpoint endpoint : endpoints) {
			intersections[endpoint.index] += endpoint.count;
		}

		int[] range = new int[2];
		range[0] = ranges[0][0];
		range[1] = ranges[0][1];
		int max = intersections[0];
		for (int i = 1; i < n; i++) {
			if (intersections[i] > max
					|| (intersections[i] == max
					&& (ranges[i][0] < range[0]
							|| (ranges[i][0] == range[0] && ranges[i][1] < range[1])))) {
				max = intersections[i];
				range[0] = ranges[i][0];
				range[1] = ranges[i][1];
			}
		}

		return range;
	}

	private static class Endpoint implements Comparable<Endpoint> {
		private static enum Type {
			START,
			FINISH;
		}

		Type type;
		int index;
		int value;
		int count;

		public Endpoint(Type type, int index, int value) {
			this.type = type;
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Endpoint o) {
			if (this.value < o.value) {
				return -1;
			}

			return 1;
		}
	}
}