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
	 * 
	 * Time complexity : O(n * log(n))
	 * Space complexity : O(n)
	 */
	public static Set<Appointment> conflicts(List<Appointment> apps) {
		Collections.sort(apps, new Comparator<Appointment>() { // sort by beginning time

			@Override
			public int compare(Appointment a1, Appointment a2) {
				if (a1.beginning < a2.beginning) {
					return -1;
				}
				return 1;
			}
		});

		PriorityQueue<Appointment> heap = new PriorityQueue<>(8, new Comparator<Appointment>() {

			@Override
			public int compare(Appointment a1, Appointment a2) { // min heap on ending time
				if (a1.ending < a2.ending) {
					return -1;
				}
				return 1;
			}
		});

		Set<Appointment> conflicts = new HashSet<>();
		for (Appointment a : apps) {
			while (!heap.isEmpty() && heap.peek().ending <= a.beginning) {
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
		int beginning;
		int ending;

		public Appointment(int beginning, int ending) {
			this.beginning = beginning;
			this.ending = ending;
		}
	}
}