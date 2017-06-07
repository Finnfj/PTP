package neuronetwork;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNeuron PalindromNeuron = new PalindromeNeuron(true);
		Signal anna = new Signal("AnnnA");
		PalindromNeuron.addInput(anna);
		ConcatenationNeuron con = new ConcatenationNeuron();
		con.addInput(PalindromNeuron);
		con.addInput(con);
		System.out.println(con.getOutputValue());
		System.out.println(con.getOutputValue());
		System.out.println(con.getOutputValue());
		System.out.println(PalindromNeuron.getOutputValue());
	}

}
