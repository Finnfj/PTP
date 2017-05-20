package autorennen;

import static java.lang.Math.*;

/**
 * @author Finn Jannsen
 * @author Kim Schiefke
 * @version 1.0, 20.05.17
 *
 */
public class Sportscar {
	public enum Typ { 
		SPORTSCAR, SUPER_SPORTSCAR, SUPER_DUPER_SPORTSCAR 
	}
	
	private String driver;
	private Typ typ;
	private double maxVelocity;
	private double drivenDistance;
	
	/**
	 * Konstruktionsmethode für Rennauto.
	 * @param driver		Autofahrerin
	 * @param typ			Typ des Autos: SPORTSCAR, SUPER_SPORTSCAR, SUPER_DUPER_SPORTSCAR  
	 * @param maxVelocity	Maximale Geschwindigkeit des Autos
	 */
	public Sportscar(String driver, Typ typ, double maxVelocity) {
		this.driver = driver;
		this.typ = typ;
		this.maxVelocity = maxVelocity;
	}
	
	/**
	 * gefahrene Distanz wird um 1h Fahrt bei Maximalgeschwindigkeit mal Zufallsfaktor 0-1 erhöht.
	 */
	public void drive() {
		drivenDistance += random()*maxVelocity;
	}
	
	/**
	 * Gibt alle Objektvariablen des Autos in Konsole aus.
	 */
	public void output() {
		switch (typ) {
		case SUPER_DUPER_SPORTSCAR: 
			System.out.println("Fahrer: " + driver + "; Typ: Super-Duper-Sportwagen" + "; Maximalgeschwindigkeit: " + maxVelocity + "; gefahrene Strecke: " + drivenDistance);
			break;
		case SUPER_SPORTSCAR:
			System.out.println("Fahrer: " + driver + "; Typ: Super-Sportwagen" + "; Maximalgeschwindigkeit: " + maxVelocity + "; gefahrene Strecke: " + drivenDistance);
			break;
		case SPORTSCAR:
			System.out.println("Fahrer: " + driver + "; Typ: Sportwagen" + "; Maximalgeschwindigkeit: " + maxVelocity + "; gefahrene Strecke: " + drivenDistance);
			break;
		}
		
	}
	
	/**
	 * toString-Methode auf Rennauto-Klasse zugeschnitten.
	 * @return Alle Objektvariablen des Rennautos getrennt durch ";".
	 */
	public String toString() {
		return "Fahrer: " + driver + "; Typ: " + typ + "; Maximalgeschwindigkeit: " + maxVelocity + "; gefahrene Strecke: " + drivenDistance;
	}
	
	/**
	 * @return Gefahrene Distanz des Autos.
	 */
	public double getDrivenDistance() {
		return drivenDistance;
	}
	
	/**
	 * @return Name der Fahrerin.
	 */
	public String getName() {
		return driver;
	}
	
	public static void main(String[] args) {
		Sportscar Volvo = new Sportscar("Finn", Typ.SUPER_SPORTSCAR, 250);
		Volvo.output();
		Volvo.drive();
		Volvo.output();
		Volvo.drive();
		Volvo.output();
	}
}
