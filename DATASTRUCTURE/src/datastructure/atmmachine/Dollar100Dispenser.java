package datastructure.atmmachine;

public class Dollar100Dispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Amount cur) {
		// set the chain of responsibility
		setNextChain(new Dollar50Dispenser());
		if (CashStock.totalCashAvailable() >= 100) {
			if (cur.getAmount() >= 100) {
				int num = cur.getAmount() / 100;
				if(CashStock.cashStock.get("HUNDREDE")>=num){
					int remainder = cur.getAmount() % 100;
					CashStock.cashStock.put("HUNDREDE",CashStock.cashStock.get("HUNDREDE")-num);
					System.out.println("Dispensing " + num + " 100$ note");
					if (remainder != 0)
						this.chain.dispense(new Amount(remainder));
				}else this.chain.dispense(cur);
				
			} else {
				this.chain.dispense(cur);
			}
		}

	}

}
