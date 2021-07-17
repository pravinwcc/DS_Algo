package datastructure.atmmachine;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Amount cur);
}