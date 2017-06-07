package neuronetwork;

public abstract class AbstractNeuron implements Neuron {
	protected Neuron[] inputs;
	
	public AbstractNeuron() {
	}
	
	public void addInput(Neuron neuron) {
		if (neuron == this) {
			return;
		}
		if (inputs == null) {
			inputs = new Neuron[1];
			inputs[0] = neuron;
		} else {
			int oldLength = inputs.length;
			Neuron[] newinputs = new Neuron[oldLength+1];
			System.arraycopy(inputs, 0, newinputs, 0, oldLength+1);
			inputs = newinputs;
			inputs[inputs.length] = neuron;
		}
	}
}
