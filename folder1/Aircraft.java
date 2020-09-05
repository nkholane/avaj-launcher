package folder1;

public abstract class Aircraft {
	protected long 	id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 1;
	protected boolean unregistered;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId() {
		return idCounter++;
	}
}
