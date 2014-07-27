package exercice;

import org.junit.Test;

public class ReplaceWhiteSpaceTest {

	@Test
	public void test() {
		char[] chars = new char[9];
		chars[0] = 'A';
		chars[1] = ' ';
		chars[2] = 'B';
		chars[3] = ' ';
		chars[4] = 'C';
		int n = 5;
		ReplaceWhiteSpace.f(chars, n);
		System.out.println(chars);
	}

	@Test
	public void test2() {
		char[] chars = new char[11];
		chars[0] = ' ';
		chars[1] = 'A';
		chars[2] = 'B';
		chars[3] = ' ';
		chars[4] = ' ';
		int n = 5;
		ReplaceWhiteSpace.f(chars, n);
		System.out.println(chars);
	}

	@Test
	public void test3() {
		char[] chars = new char[15];
		chars[0] = ' ';
		chars[1] = ' ';
		chars[2] = ' ';
		chars[3] = ' ';
		chars[4] = ' ';
		int n = 5;
		ReplaceWhiteSpace.f(chars, n);
		System.out.println(chars);
	}

}
