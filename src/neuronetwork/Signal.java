package neuronetwork;

public class Signal implements Neuron {
	private String value;
	
	public Signal(String value) {
		this.value = value;
	}

	@Override
	public String getOutputValue() {
		return value;
	}
}
