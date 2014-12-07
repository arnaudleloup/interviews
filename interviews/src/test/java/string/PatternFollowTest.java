package string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PatternFollowTest {

	@Test
	public void test() {
		assertTrue(PatternFollow.f("redbluebluered", "abba"));
		assertTrue(PatternFollow.f("asdasdasdasd", "aaaa"));
		assertFalse(PatternFollow.f("asdasdasdas", "aaaa"));
		assertFalse(PatternFollow.f("asdasdasdasdX", "aaaa"));
		assertFalse(PatternFollow.f("asdasdasdasX", "aaaa"));
		assertFalse(PatternFollow.f("xyzabcxzyabc", "aabb"));
	}
}