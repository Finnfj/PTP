package aufgabenblatt3;

import java.util.Scanner;

public class Aufgabe2 {
	public static void main(String[] args) {
		//Scanner initialisieren und Zeilenanzahl in initialisierte Variable abspeichern
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ich zeichne einen Tannenbaum für dich, gib die Höhe in Zeilen an (exklusive Baumstamm): ");
		int lines = scanner.nextInt();
		
		//Fälle prüfen, in denen eine Zeilenzahl kleiner 0, 0, 1 oder 2 eingegeben wurde, da eine positive Zeilenzahl
		//Für diesen Zweck von Nöten ist. 1 und 2 sind nicht erlaubt, da das Ergebnis kein Baum mehr ist.
		while(lines <= 2){
			if (lines == 0) {		
				System.out.print("Du hast 0 Zeilen angegeben, bitte gib eine positive ganze Zahl an: ");
				lines = scanner.nextInt();
			}
			else if (lines < 0) {
				System.out.print("Du hast eine negative Zahl eingegeben. Ich kann keinen umgekehrten Baum zeichnen. Bitte gib eine positive ganze Zahl an: ");
				lines = scanner.nextInt();
			}
			else if (lines == 1 || lines == 2) {
				System.out.print("Du hast eine Zahl kleiner 3 eingegeben. Um einen erkennbaren Tannenbaum zu zeichnen brauche ich mehr Zeilen: ");
				lines = scanner.nextInt();
			}
		}
		
		//Deklarieren und Initialisieren 
		int i = 0;
		int treeCounter = 1;
		/*
		 * Der Baum fängt an der Spitze an, der Baum wird (Zeilen*2)+1 breit gezeichnet, damit der Baum eine adäquate Breite hat.
		 * Ich werde die "Blanks" (".") aber 2 mal zeichnen, von daher ist die Anzahl an Blanks am Anfang die
		 * Anzahl der Linien minus das eine Zeichen für den Baum in der ersten Zeile.
		 */
		int spaceCounter = lines - treeCounter;
		//Der Übersicht halber initialisiere ich Strings mit den Zeichen, die ich immer wieder verwende
		String treeChar = "*";
		String spaceChar = ".";
		
		//Die von mir gewählte Methode schreibt jede Zeile in einer Schleifenperiode
		System.out.println("Du möchtest einen Tannenbaum mit " + lines + " Zeilen, hier ist er:");
		while (i < lines) {
			//Erst schreibt es n ".", die Anzahl der "." und "*" sind jeweils in der spaceCounter und treeCounter Variable abgelegt
			for (int z=0;z<spaceCounter;z++) {
				System.out.print(spaceChar);
			}
			//Dann schreibt es n "*"
			for (int z=0;z<treeCounter;z++) {
				System.out.print(treeChar);
			}
			//Dann wieder n "."
			for (int z=0;z<spaceCounter;z++) {
				System.out.print(spaceChar);
			}
			//Es wird in die nächste Zeile gerückt
			System.out.println();
			//Ich setze für die nächste Zeile die "*" um 2 hoch und die "." um 1 runter, da ich letztere 2 mal schreibe (Erklärung s.o.)
			treeCounter += 2;
			spaceCounter -= 1;
			i++;
		}
		
		//Folgende if else Überprüfung fügt noch einen 2-zeiligen Baumstamm für alle Tannenbäume höher 3 hinzu
		//und einen 1-zeiligen Baumstamm für einen 3 Zeilen hohen Baum aus ästhetischen Gründen
		if (lines > 3) {
			for (int z=2;z<lines;z++) {
				System.out.print(".");
			}
			System.out.print("| |");
			for (int z=2;z<lines;z++) {
				System.out.print(".");
			}
		
			System.out.println();
		
			for (int z=2;z<lines;z++) {
				System.out.print(".");
			}
			System.out.print("|_|");
			for (int z=2;z<lines;z++) {
				System.out.print(".");
			}
		}
		else {
			for (int z=2;z<lines;z++) {
				System.out.print(".");
			}
			System.out.print("|_|");
			for (int z=2;z<lines;z++) {
				System.out.print(".");
			}
		}
		//Es wird in die nächste Zeile gerückt
		System.out.println();
		
		//Abfrage, ob man Kerzen auf dem Baum haben möchte. Antwort wird in einem gleichzeitig deklarierten und initialisierten String abgespeichert
		System.out.println("Möchtest du Kerzen auf deinem Tannenbaum? (Bitte auf Deutsch oder Englisch antworten)");
		String wantsCandles = scanner.next();
		
		//Abfrage, ob die Antwort in einem String aus vordefinierten Antworten NICHT enthalten ist. 
		//Falls er dies nicht ist wird erneut eine Antwort abgefragt, bis eine gültige Antwort gegeben wurde
		while (!wantsCandles.matches("j|J|ja|Ja|y|Y|yes|Yes|n|N|nein|Nein|no|No")) {
			System.out.println("Das ist keine gültige Antwort, du hast folgende Antwortmöglichkeiten:");
			System.out.println("Für Ja: j|J|ja|Ja|y|Y|yes|Yes \nFür Nein: n|N|nein|Nein|no|No");
			wantsCandles = scanner.next();
		}
		
		//Abfrage, ob die Antwort in den vordefinierten positiven Antworten enthalten ist
		if (wantsCandles.matches("j|J|ja|Ja|y|Y|yes|Yes")) {
			System.out.println("Du möchtest also Kerzen auf dem Tannenbaum, die sollst du haben");
			System.out.println("ich hab sie bei den Zeilen die eine Primzahl sind gesetzt, angefangen bei der 2., da Informatiker ab 0 zählen und es schöner aussieht =) :");
			
			//Zurücksetzen der zuvor verwendeten Variablen
			i = 0;
			treeCounter = 1;
			spaceCounter = lines - treeCounter;
			
			//Initialisierung eines Booleans zur Überprüfung, ob die aktuelle Zeilenzahl eine Primzahl ist.
			boolean isPrimenumber = false;
			
			while (i < lines) {
				//Überprüfung, ob die aktuelle Zeilenzahl eine Primzahl ist. Methode in Aufgabe 1 erläutert.
				for (int z=2; z<i;z++) {
					
					int modInput = i%z;
					
					if (modInput != 0) {
						isPrimenumber = true;
					}	
					else if (modInput == 0) {
						isPrimenumber = false;
						break;
					}
				}
				
				/*Wenn die Zeilenzahl eine Primzahl ist wird eine separate Methode zum schreiben der Zeilenzahl eingeführt.
				 * 1. In der Zeile, wo der Baum die volle Breite einnimmt dürfen keine zusätzlichen Kerzen erscheinen, weil sonst das Format bricht.
				 * 2. Die Primzahlüberprüfung funktioniert bei den Primzahlen 1 und 2 nicht, daher eine extra Überprüfung auf diese beiden.
				 */
				if (isPrimenumber == true && i != lines-1 || i == 1 && lines !=2 || i == 2 && lines != 3) {
					//In dieser leicht abgeänderten Methode zum schreiben der Zeile wird ein "." weniger geschrieben,
					//daher z+1 und vor und nach den "*" wird ein "i" als Kerze hinzugefügt.
					for (int z=0;z+1<spaceCounter;z++) {
						System.out.print(spaceChar);
					}
					System.out.print("i");
					for (int z=0;z<treeCounter;z++) {
						System.out.print(treeChar);
					}
					System.out.print("i");
					for (int z=0;z+1<spaceCounter;z++) {
						System.out.print(spaceChar);
					}
				}
				//Ist es keine Primzahl wird die Zeile wie zuvor geschrieben
				else {
					for (int z=0;z<spaceCounter;z++) {
						System.out.print(spaceChar);
					}
					for (int z=0;z<treeCounter;z++) {
						System.out.print(treeChar);
					}
					for (int z=0;z<spaceCounter;z++) {
						System.out.print(spaceChar);
					}
				}
				//Zeilenumbruch und Counter hoch/runtersetzen s.o.
				System.out.println();
				treeCounter += 2;
				spaceCounter -= 1;
				i++;
			}
			
			//Baumstamm genau wie oben hinzugefügt
			if (lines > 3) {
				for (int z=2;z<lines;z++) {
					System.out.print(".");
				}
				System.out.print("| |");
				for (int z=2;z<lines;z++) {
					System.out.print(".");
				}
			
				System.out.println();
			
				for (int z=2;z<lines;z++) {
					System.out.print(".");
				}
				System.out.print("|_|");
				for (int z=2;z<lines;z++) {
					System.out.print(".");
				}
			}
			else {
				for (int z=2;z<lines;z++) {
					System.out.print(".");
				}
				System.out.print("|_|");
				for (int z=2;z<lines;z++) {
					System.out.print(".");
				}
			}
		}
		//Überprüfung, ob die Antwort in den vordefinierten negativen Antworten vorkommt und dementsprechende Rückmeldung
		else if (wantsCandles.matches("n|N|nein|Nein|no|No")) {
			System.out.println("Du möchtest also keine Kerzen auf dem Tannenbaum, ich hoffe er hat trotzdem Gefallen gefunden");
		}
		//Schließen des Scanners
		scanner.close();
	}
}
