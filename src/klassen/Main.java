package klassen;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Anhaenger a1 = new Anhaenger(5,"C");
		Anhaenger a2 = new Anhaenger(8,"b");
		Anhaenger a3 = new Anhaenger(10,"A");
		LKW lkw = new LKW(a1);
		
		lkw.amEndeAnhaengen(a2);
		lkw.amEndeAnhaengen(a3);
		System.out.println(lkw.toString());
		
		lkw.aushaengen(a3);
		System.out.println(lkw.toString());
	}
}
