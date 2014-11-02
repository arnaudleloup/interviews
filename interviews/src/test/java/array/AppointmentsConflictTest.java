package array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import array.AppointmentsConflict.Appointment;

public class AppointmentsConflictTest {

	@Test
	public void test() {
		List<Appointment> apps = Arrays.asList(
				new Appointment(2, 6),
				new Appointment(3, 8),
				new Appointment(7, 9)
				);

		assertEquals(new HashSet<Appointment>(apps), AppointmentsConflict.conflicts(apps));
	}

	@Test
	public void test2() {
		List<Appointment> apps = Arrays.asList(
				new Appointment(2, 6),
				new Appointment(10, 15),
				new Appointment(7, 9)
				);

		assertEquals(new HashSet<Appointment>(), AppointmentsConflict.conflicts(apps));
	}

	@Test
	public void test3() {
		Appointment a1 = new Appointment(2, 6);
		Appointment a2 = new Appointment(5, 10);
		Appointment a3 = new Appointment(11, 14);
		List<Appointment> apps = Arrays.asList(a1, a2, a3);

		assertEquals(new HashSet<Appointment>(Arrays.asList(a1, a2)), AppointmentsConflict.conflicts(apps));
	}

	@Test
	public void test4() {
		Appointment a1 = new Appointment(2, 6);
		Appointment a2 = new Appointment(3, 7);
		Appointment a3 = new Appointment(4, 8);
		Appointment a4 = new Appointment(5, 9);
		List<Appointment> apps = Arrays.asList(a2, a4, a3, a1);

		assertEquals(new HashSet<Appointment>(apps), AppointmentsConflict.conflicts(apps));
	}

	@Test
	public void test5() {
		Appointment a1 = new Appointment(2, 6);
		Appointment a2 = new Appointment(7, 10);
		Appointment a3 = new Appointment(9, 15);
		Appointment a4 = new Appointment(17, 20);
		Appointment a5 = new Appointment(1, 30);
		List<Appointment> apps = Arrays.asList(a2, a4, a3, a5, a1);

		assertEquals(new HashSet<Appointment>(apps), AppointmentsConflict.conflicts(apps));
	}

	@Test
	public void test6() {
		Appointment a1 = new Appointment(2, 6);
		Appointment a2 = new Appointment(7, 10);
		Appointment a3 = new Appointment(9, 15);
		Appointment a4 = new Appointment(17, 20);
		List<Appointment> apps = Arrays.asList(a2, a4, a3, a1);

		assertEquals(new HashSet<Appointment>(Arrays.asList(a2, a3)), AppointmentsConflict.conflicts(apps));
	}
}