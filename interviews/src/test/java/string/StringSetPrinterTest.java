package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class StringSetPrinterTest {

	@Test
	public void test() {
		Set<String> set1 = new HashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("c");

		Set<String> set2 = new HashSet<>();
		set2.add("d");
		set2.add("e");

		Set<String> set3 = new HashSet<>();
		set3.add("f");
		set3.add("g");
		set3.add("h");
		set3.add("i");


		List<Set<String>> list = Arrays.asList(set1, set2, set3);
		StringSetPrinter.print(list);
	}

}
