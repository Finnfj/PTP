package autorennen;

import java.lang.reflect.Array;

/**
 * <br>
 * Kurs: PTP1 Axel Schmolitzky und Philipp Jenke <br>
 * Aufgabe: 5 Autorennen <br>
 * Die Race Klasse stellt ein funktionales Rennen der Rennautos erstellt mit
 * Klasse sportsCars dar. <br>
 * <br>
 * Objektvariablen: <br>
 * numberOfCars Anzahl Rennautos <br>
 * trackDistance Länge der Strecke <br>
 * sportsCars[] Menge mit Rennautos
 * 
 * @author Finn Jannsen
 * @author Kim Schiefke
 * @version 1.0, 23.05.17
 */
public class Race {

	/**
	 * <br>
	 */
	private int numberOfCars;
	private double trackDistance;
	private SportsCars[] sportsCars;

	/**
	 * Konstruktor mit Streckenlänge und beliebiger Anzahl an Rennautos.
	 * 
	 * @param trackDistance
	 *            Streckenlänge
	 * @param sportsCars
	 *            Rennautos
	 */

	public Race(double trackDistance, SportsCars... sportsCars) {
		this.setTrackDistance(trackDistance);
		this.sportsCars = sportsCars;
		this.setNumberOfCars(sportsCars.length);
	}

	/**
	 * Fügt dem Array mit den Rennautos ein weiteres Rennauto hinzu.
	 * 
	 * @param sportsCar
	 *            Rennauto, das hinzugefügt werden soll.
	 */
	public void addSportsCar(SportsCars sportsCar) {
		// prüfen, ob ein freier Platz im Array vorhanden ist.
		for (int counter = 0; counter < sportsCars.length; counter++) {
			if (sportsCars[counter] == null) {
				sportsCars[counter] = sportsCar;
				setNumberOfCars(getNumberOfCars() + 1);
			}
		}
		// Kopiere Array und verdopple Länge
		int oldLength = sportsCars.length;
		SportsCars[] newCarArray = new SportsCars[oldLength+1];
		System.arraycopy(sportsCars, 0, newCarArray, 0,
				Array.getLength(sportsCars));
		sportsCars = (SportsCars[]) newCarArray;
		sportsCars[oldLength] = sportsCar;
	}

	/**
	 * Methode ermittelt Auto mit der längsten gefahrenen Strecke.
	 * 
	 * @return Rennauto mit der längsten gefahrenen Strecke
	 */
	public SportsCars determineWinner() {
		SportsCars winner = null;
		double maxDistance = 0;
		for (int i = 0; i < sportsCars.length; i++) {
			if (sportsCars[i] != null) {
				if (sportsCars[i].getDrivenDistance() > maxDistance) {
					winner = sportsCars[i];
					maxDistance = sportsCars[i].getDrivenDistance();
				}
			}
		}
		if (winner != null) {
			return winner;
		}
		return null;
	}

	/**
	 * Lässt die Rennautos des Objektes eine Stunde fahren
	 * 
	 * @see sportsCars.drive()
	 */
	private void step() {
		for (int i = 0; i < sportsCars.length; i++) {
			if (sportsCars[i] != null) {
				sportsCars[i].drive();
			}
		}
	}

	/**
	 * Die Rennautos fahren, bis ein Gewinner gefunden wurde.
	 */
	public void execute() {
		// step();
		if (determineWinner() == null) {
			step();
		}
	}

	public int getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(int numberOfCars) {
		this.numberOfCars = numberOfCars;
	}

	public double getTrackDistance() {
		return trackDistance;
	}

	public void setTrackDistance(double trackDistance) {
		this.trackDistance = trackDistance;
	}
}
