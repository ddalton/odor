package tools.xor;

public class OrderbyItem {
	public enum Ordering {
		ASC, DESC;
	}

	private String name;
	private Ordering ordering;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ordering getOrdering() {
		return ordering;
	}

	public void setOrdering(Ordering ordering) {
		this.ordering = ordering;
	}
	
	@Override
	public String toString() {
		return name + " " + ordering.toString().toLowerCase();
	}
}