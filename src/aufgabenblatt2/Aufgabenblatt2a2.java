package aufgabenblatt2;

import java.util.Scanner;

public class Aufgabenblatt2a2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Gib eine Zahl ein und ich prüfe für dich, ob sie durch 3 teilbar ist: ");
		double eingabeZahl = scanner.nextDouble(); 	// Eingabe wird als Fließkommazahl in eine double Variable eingelesen.
		double rundungsRest = eingabeZahl%1;		// Ich berechne den Rest, der als Information bei der Rundung verloren gehen wird, indem ich den Modulo mit 1 berechne
		scanner.close();							// Scanner wird geschlossen, da ich ihn nicht mehr brauche.
		int gerundeteZahl = (int) eingabeZahl;		// Ich mache eine explizite Typkonvertierung der Fließkommazahl zu Integer und runde dabei automatisch.
		if (rundungsRest >= 0.5) { gerundeteZahl = gerundeteZahl + 1; } 	//Wenn mehr als 0,5 übrig geblieben ist addiere ich 1 zur gerundeten Zahl, da Java immer auf das nächstkleine reduziert bei der expliziten Konversion.
		int restZahl = gerundeteZahl%3;				// Ich berechne den Modulo von 3, also den Rest der Division.
		int geteilteZahl = gerundeteZahl/3;			// Ich teile die gerundete Zahl durch 3.
		if (restZahl != 0) {						// Prüfe, ob der Modulo nicht 0 ist, im Umkehrschluss wäre die Zahl nicht durch 3 teilbar.
			System.out.println("Deine eingegebene Zahl konnte gerundet zu " + gerundeteZahl + " leider nicht durch 3 geteilt werden.");
		}
		else {										// In allen anderen Fällen ist sie durch 3 teilbar, also benutze ich else.
			System.out.println("Deine Zahl " + eingabeZahl + " konnte als gerundete Zahl " + gerundeteZahl + " durch 3 geteilt werden und ergibt " + geteilteZahl);
		}
	}
}
