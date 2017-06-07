package autorennen;

import static java.lang.Math.*;

/**
 * <br>
 * Kurs: PTP1 Axel Schmolitzky und Philipp Jenke <br>
 * Aufgabe: 5 Autorennen <br>
 * Die Sportscar Klasse repräsentiert Rennautos mit vier Grundlegenden
 * Objektvariablen. <br>
 * <br>
 * Objektvariablen: <br>
 * driver Fahrer/in des Autos <br>
 * Typ Typ des Autos <br>
 * maxVelocity Maximale Geschwindigkeit <br>
 * drivenDistance gefahrene Distanz des Autos
 * 
 * @author Finn Jannsen
 * @author Kim Schiefke
 * @version 1.1, 23.05.17	 
 */

public class SportsCars {
	public enum Typ {
		SPORTSCAR, SUPER_SPORTSCAR, SUPER_DUPER_SPORTSCAR
	}

	private String driver;
	private Typ typ;
	private double maxVelocity;
	private double drivenDistance;

	/**
	 * Konstruktionsmethode für Rennauto.
	 * 
	 * @param driver
	 *            Autofahrer/in
	 * @param typ
	 *            Typ des Autos: SPORTSCAR, SUPER_SPORTSCAR,
	 *            SUPER_DUPER_SPORTSCAR
	 * @param maxVelocity
	 *            Maximale Geschwindigkeit des Autos
	 */
	public SportsCars(String driver, Typ typ, double maxVelocity) {
		this.driver = driver;
		this.typ = typ;
		this.maxVelocity = maxVelocity;
	}

	public SportsCars() {

	}

	/**
	 * gefahrene Distanz wird um 1h Fahrt bei Maximalgeschwindigkeit mal
	 * Zufallsfaktor 0-1 erhöht.
	 */
	public void drive() {
		drivenDistance += random() * maxVelocity;
	}

	/**
	 * Gibt alle Objektvariablen des Autos in Konsole aus. Unterscheidung der
	 * drei Typen.
	 */
	public void output() {
		switch (typ) {
		case SUPER_DUPER_SPORTSCAR:
			System.out.println(
					"Fahrer: " + driver + "; Typ: Super-Duper-Sportwagen"
							+ "; Maximalgeschwindigkeit: " + maxVelocity
							+ "; gefahrene Strecke: " + drivenDistance);
			break;
		case SUPER_SPORTSCAR:
			System.out.println("Fahrer: " + driver + "; Typ: Super-Sportwagen"
					+ "; Maximalgeschwindigkeit: " + maxVelocity
					+ "; gefahrene Strecke: " + drivenDistance);
			break;
		case SPORTSCAR:
			System.out.println("Fahrer: " + driver + "; Typ: Sportwagen"
					+ "; Maximalgeschwindigkeit: " + maxVelocity
					+ "; gefahrene Strecke: " + drivenDistance);
			break;
		}

	}

	/**
	 * toString-Methode auf Rennauto-Klasse zugeschnitten.
	 * 
	 * @return Alle Objektvariablen des Rennautos getrennt durch ";".
	 */
	public String toString() {
		return "Fahrer/in: " + driver + "; Typ: " + typ
				+ "; Maximalgeschwindigkeit: " + maxVelocity
				+ "; gefahrene Strecke: " + drivenDistance;
	}

	/**
	 * @return Gefahrene Distanz des Autos.
	 */
	public double getDrivenDistance() {
		return drivenDistance;
	}

	/**
	 * @return Name des/der Fahrers/in.
	 */
	public String getName() {
		return driver;
	}

	public static void main(String[] args) {
		SportsCars Volvo = new SportsCars("Finn", Typ.SUPER_SPORTSCAR, 250);
		SportsCars Cashmobil = new SportsCars("DagobertDuck",
				Typ.SUPER_DUPER_SPORTSCAR, 252);
		Race Rennen = new Race(5000, Volvo, Cashmobil);
		SportsCars VW = new SportsCars("Elon Musk", Typ.SPORTSCAR, 300);
		Rennen.addSportsCar(VW);
		Rennen.execute();
		Rennen.determineWinner().output();
	}
}
