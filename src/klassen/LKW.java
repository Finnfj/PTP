package klassen;

public class LKW {
	private Anhaenger anhaenger;
	
	public LKW(Anhaenger anhaenger) {
		this.anhaenger = anhaenger;
	}
	
	public String toString() {
		if (anhaenger == null) {
			return "[LKW]";
		}
		return "[LKW] - " + anhaenger.toString();
	}
	
	public void setAnhaenger(Anhaenger trailer) {
		this.anhaenger = trailer;
	}
	
	public void amEndeAnhaengen(Anhaenger trailer) {
		Anhaenger lastTrailer;
		if (this.anhaenger == null) {
			this.anhaenger = trailer;
		}
		else {
			lastTrailer = this.anhaenger.getLastAnhaenger(this.anhaenger);
			lastTrailer.anhaengen(trailer);
		}
	}
	
	public void aushaengen(Anhaenger trailer) {
		if (this.anhaenger == trailer) {
			this.anhaenger = null;
		}
		else {
			this.anhaenger.aushaengen(trailer);
		}
	}
	/*
	public Anhaenger getSchwerstenAnhaenger() {
		
	}*/
}
