package string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NestingTest {

	@Test
	public void test() {
		assertTrue(Nesting.f("()()"));
		assertTrue(Nesting.f("(())"));
		assertFalse(Nesting.f("())("));
		assertFalse(Nesting.f("()("));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test2() {
		Nesting.f("())(a");
	}

	@Test
	public void test3() {
		assertTrue(Nesting.f2("[()]{()}(){}[{}]"));
		assertTrue(Nesting.f2("(([]{}))"));
		assertFalse(Nesting.f2("([))("));
		assertFalse(Nesting.f2("()[("));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test4() {
		Nesting.f2("([{])})(a");
	}
}