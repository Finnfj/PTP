package klassen;

public class Anhaenger {
	private Anhaenger anhaenger;
	private int last;
	private String id;
	
	public Anhaenger(int last, String id) {
		this.last = last;
		this.id = id;
	}
	
	public int getLast() {
		return last;
	}
	
	public String toString() {
		if (anhaenger == null) {
			return "[" + id + ", " + last + "t" + "]";
		}
		return "[" + id + ", " + last + "t" + "]" + " - " + anhaenger.toString();
	}
	
	public void anhaengen(Anhaenger trailer) {
		this.anhaenger = trailer;
	}

	public Anhaenger getAnhaenger() {
		return this.anhaenger;
	}
	
	public void aushaengen(Anhaenger trailer) {
		if (this.anhaenger == trailer) {
			this.anhaenger = null;
		}
	}
	
	public Anhaenger getLastAnhaenger(Anhaenger trailer) {
		if (trailer.id == null) {
			return null;
		}
		while (trailer.anhaenger != null) {
			trailer = trailer.anhaenger;
		}
		return trailer;
	}
}
