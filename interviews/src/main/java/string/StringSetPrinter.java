package string;

import java.util.List;
import java.util.Set;

public class StringSetPrinter {

	public static void print(List<Set<String>> strings) {
		dfs(strings, new String[strings.size()], 0);
	}

	private static void dfs(List<Set<String>> strings, String[] current, int i) {
		if (i == strings.size()) {
			for (int j = 0; j < strings.size(); j++) {
				System.out.print(current[j] + " ");
			}
			System.out.println();
			return;
		}

		for (String s : strings.get(i)) {
			current[i] = s;
			dfs(strings, current, i + 1);
		}
	}
}
