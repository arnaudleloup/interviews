package exercice.queryexpansion;

import java.util.Arrays;
import java.util.Iterator;

public class PartialQuery implements Comparable<PartialQuery>, Iterable<QuerySynonym> {

	private final QuerySynonym[] queries;
	private int words = 0; // number of words in the partial query

	public PartialQuery(int queryLength) {
		queries = new QuerySynonym[queryLength];
	}

	public PartialQuery(PartialQuery partial) {
		queries = new QuerySynonym[partial.queries.length];
		this.words = partial.words;

		int i = 0;
		for (QuerySynonym s : partial) {
			queries[i++] = s;
		}
	}

	public void add(QuerySynonym s) {
		queries[words++] = s;
	}

	public void removeLast() {
		queries[--words] = null;
	}

	public int getWords() {
		return words;
	}

	@Override
	public int compareTo(PartialQuery o) {
		if (getProbability() < o.getProbability()) {
			return -1;
		} else if (getProbability() == o.getProbability()) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public Iterator<QuerySynonym> iterator() {
		return new Iterator<QuerySynonym>() {
			private int i = 0;

			@Override
			public boolean hasNext() {
				return i < queries.length;
			}

			@Override
			public QuerySynonym next() {
				return queries[i++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public double getProbability() {
		double p = 1;

		for (int i = 0; i < words; i++) {
			p *= queries[i].getProbability();
		}

		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(queries);
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
		PartialQuery other = (PartialQuery) obj;
		if (!Arrays.equals(queries, other.queries)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PartialQuery [queries=" + Arrays.toString(queries) + "]";
	}
}