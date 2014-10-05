package exercice.queryexpansion;

/**
 * Represents a synonyms of a word present in a query.
 * This synonym has a probability (between 0 and 1 inclusive).
 */
public class QuerySynonym {

	private final String value;
	private final double probability;

	public QuerySynonym(String value, double probability) {
		this.value = value;
		this.probability = probability;
	}

	public String getValue() {
		return value;
	}

	public double getProbability() {
		return probability;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(probability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		QuerySynonym other = (QuerySynonym) obj;
		if (Double.doubleToLongBits(probability) != Double
				.doubleToLongBits(other.probability)) {
			return false;
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "QuerySynonym [value=" + value + ", proba=" + probability + "]";
	}
}