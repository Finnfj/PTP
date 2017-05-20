package aufgabenblatt3;

import java.util.Scanner;

public class Aufgabe1 {
	public static void main(String[] args){
		int primenumber = 0;
		int input = 0;
		boolean isPrimenumber = false;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte gib eine Zahl ein, bis zu der ich die Primzahlen berechnen soll");
		input = scanner.nextInt();
		scanner.close();
		
		for (int i=1; i <= input;i++) {
			for (int z=2; z<i;z++) {
				
				int modInput = i%z;
				
				if (modInput != 0) {
					isPrimenumber = true;
					primenumber = i;
				}	
				else if (modInput == 0) {
					isPrimenumber = false;
					break;
				}
			}
			if (isPrimenumber) {
				System.out.println(primenumber);
				isPrimenumber = false;
			}
			else if (i==1 || i==2) {
				System.out.println(i);
			}
		}
	}
}