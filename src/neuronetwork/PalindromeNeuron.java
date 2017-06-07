package neuronetwork;

public class PalindromeNeuron extends AbstractNeuron {
	private boolean lowerAndUpperRelevant;
	
	
	public PalindromeNeuron(boolean lowerAndUpperRelevant) {
		this.lowerAndUpperRelevant = lowerAndUpperRelevant;
	}
	
	private boolean isPalindrome(String input) {
		//creating an artificial palindrome
		String firstHalf = input.substring(0, input.length()/2);
		String reverseFirstHalf = new StringBuilder(firstHalf).reverse().toString();
		String artificialPalindrome;
		int length = input.length();
		
		if (length%2 == 1) {
			artificialPalindrome = firstHalf + input.charAt(length/2) + reverseFirstHalf;
		} else {
			artificialPalindrome = firstHalf + reverseFirstHalf;
		}
		
		//Frage: Kann man die "und" Bedingung anstatt mit "else if" direkt mit || erweitern?
		if (lowerAndUpperRelevant && input.equals(artificialPalindrome)) {
			return true;
		} else if (!lowerAndUpperRelevant && input.equalsIgnoreCase(artificialPalindrome)) {
			return true;
		}
		return false;
	}

	@Override
	public String getOutputValue() {
		for (int i=0; i<inputs.length; i++) {
			if (isPalindrome(inputs[i].getOutputValue())) {
				return inputs[i].getOutputValue();
			}
		}
		return null;
	}

	public boolean isLowerAndUpperRelevant() {
		return lowerAndUpperRelevant;
	}
}