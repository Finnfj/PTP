package aufgabenblatt2;

import java.util.Scanner;

public class Aufgabenblatt2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Bitte gib eine Sekundenzahl ein: ");
		int eingabeZahl = scanner.nextInt();
		while (eingabeZahl == 0) {		// In den nächsten 2 Schleifen prüfe ich, ob die Eingabe für unseren Zweck passend ist, wenn nicht wird das dem Nutzer mitgeteilt und die Eingabe wiederholt.
			System.out.print("Du hast 0 Sekunden eingegeben, bitte gib eine positive ganze Zahl an: ");
			eingabeZahl = scanner.nextInt();
		}
		while (eingabeZahl < 0) {
			System.out.print("Du hast eine negative Zahl eingegeben, bitte gib eine positive ganze Zahl an: ");
			eingabeZahl = scanner.nextInt();
		}
		scanner.close();
		int d = eingabeZahl/86400; 		// Tage: Sekunden geteilt durch (60*60*24)=86400 ergibt Anzahl der Tage
		int dRest = eingabeZahl%86400; 	// Rest an Sekunden durch Modulo ermitteln 
		int h = dRest/3600; 			// und durch (60*60)=3600 in Stunden umrechnen.
		int hRest = dRest%3600;			// wieder den Rest der vorigen Stundenerrechnung durch Modulo ermitteln.
		int m = hRest/60;				// Minuten durch teilen der restlichen Sekunden durch 60 ermitteln.
		int s = hRest%60;				// Rest der obigen Rechnung ergibt die verbleibenden Sekunden.
		
		System.out.println("Das Programm hat die Sekunden in Tag, Stunden, Minuten und Sekunden umgerechnet:");
		if (d > 0) { System.out.println(d + " Tage " + h + ":" + m + ":" + s); } 	//Sind keine Tage, Stunden oder Minuten vorhanden, so wird eine dementsprechende Antwort formuliert.
		else { 
			if (h > 0) { 
				System.out.println("Deine Eingabe hat keine Tage ergeben, aber dafür");
				System.out.println(h + ":" + m + ":" + s); 
				}
			else { 
				if (m > 0) {
					System.out.println("Die Eingabe hat keine Tage und Stunden ergeben, es bleiben aber");
					System.out.println(m + "m und " + s + "s");
				}
				else {
					System.out.println("Deine Eingabe hat weder Tag, Stunde, noch Minute ergeben. Es bleiben " + s + "s");
				}
				
			}
		}
	}
}
