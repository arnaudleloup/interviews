package exercice.queryexpansion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PartialQuery implements Comparable<PartialQuery>, Iterable<QuerySynonym> {

	private final List<QuerySynonym> list;

	public PartialQuery() {
		list = new ArrayList<>();
	}

	public PartialQuery(PartialQuery pq) {
		this.list = new ArrayList<>(pq.list);
	}

	public void add(QuerySynonym s) {
		list.add(s);
	}

	public int size() {
		return list.size();
	}

	@Override
	public int compareTo(PartialQuery o) {
		if (getProba() < o.getProba()) {
			return -1;
		} else if (getProba() == o.getProba()) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public Iterator<QuerySynonym> iterator() {
		return list.iterator();
	}

	public double getProba() {
		double p = 1;

		for (QuerySynonym s : list) {
			p *= s.getProba();
		}

		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		if (list == null) {
			if (other.list != null) {
				return false;
			}
		} else if (!list.equals(other.list)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PartialQuery [list=" + list + "]";
	}
}