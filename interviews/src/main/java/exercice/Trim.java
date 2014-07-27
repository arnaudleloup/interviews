package exercice;

public class Trim {
	public static void trim(char[] s) {
		int r = 0;
		int w = 0;
		boolean hasSpace = false;

		while(r < s.length) {
			if (s[r] == ' ') {
				hasSpace = true;
			} else {
				if (w == 0 || !hasSpace) {
					s[w] = s[r];
				} else {
					s[w] = ' ';
					s[w + 1] = s[r];
					w++;
				}

				w++;
				hasSpace = false;
			}

			r++;
		}

		for (int i = w; i < s.length; i++) {
			s[i] = ' ';
		}
	}
}
