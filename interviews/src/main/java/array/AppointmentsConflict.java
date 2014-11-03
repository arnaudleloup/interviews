package array;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AppointmentsConflict {

	/**
	 * Returns the appointments in conflicts.
	 * Two appointments are in conflicts if the ending time of one is after
	 * the beginning time of the other.
	 * The appointments given as input are sorted by beginning time.
	 * You can assume that the appointments are sorted.
	 * 
	 * Time complexity : O(n * log(n))
	 * Space complexity : O(n)
	 */
	public static Set<Appointment> conflicts(List<Appointment> apps) {
		Collections.sort(apps, new Appointment.StartComparator()); // Assume that appointments sorted by start
		PriorityQueue<Appointment> heap = new PriorityQueue<>(8, new Appointment.FinishComparator());

		Set<Appointment> conflicts = new HashSet<>();
		for (Appointment a : apps) {
			while (!heap.isEmpty() && heap.peek().finish <= a.start) {
				heap.poll();
			}

			// heap not empty means there is at least one appointment with ending time
			// after the beginning time of the current appointment, which means conflict
			if (!heap.isEmpty()) {
				conflicts.add(a);
				conflicts.add(heap.peek());
			}

			heap.add(a);
		}

		return conflicts;
	}

	public static class Appointment {
		int start;
		int finish;

		public Appointment(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		public static class StartComparator implements Comparator<Appointment> {
			@Override
			public int compare(Appointment a1, Appointment a2) {
				if (a1.start < a2.start) {
					return -1;
				}
				return 1;
			}
		}

		public static class InverseStartComparator implements Comparator<Appointment> {
			@Override
			public int compare(Appointment a1, Appointment a2) {
				if (a1.start < a2.start) {
					return 1;
				}
				return -1;
			}
		}

		public static class FinishComparator implements Comparator<Appointment> {
			@Override
			public int compare(Appointment a1, Appointment a2) {
				if (a1.finish < a2.finish) {
					return -1;
				}
				return 1;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + start;
			result = prime * result + finish;
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
			Appointment other = (Appointment) obj;
			if (start != other.start) {
				return false;
			}
			if (finish != other.finish) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Appointment [beginning=" + start + ", ending=" + finish
					+ "]";
		}
	}
}