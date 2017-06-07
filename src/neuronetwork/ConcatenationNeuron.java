package neuronetwork;

public class ConcatenationNeuron extends AbstractNeuron {
	private String memory = new String();
	
	public ConcatenationNeuron() {
	}

	@Override
	public String getOutputValue() {
		String output = new String();
		
		for (int i=0; i<inputs.length; i++) {
			output += inputs[i].getOutputValue() + " ";
		}
		memory += output;
		return memory;
	}

}
