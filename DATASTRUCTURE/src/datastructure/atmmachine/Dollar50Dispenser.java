package datastructure.atmmachine;


public class Dollar50Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	@Override
	public void dispense(Amount cur) {
		// set the chain of responsibility
		setNextChain(new Dollar50Dispenser());
		if (CashStock.totalCashAvailable() >= 50) {
			if (cur.getAmount() >= 50) {
				int num = cur.getAmount() / 50;
				if(CashStock.cashStock.get("FIFTY")>=num){
					int remainder = cur.getAmount() % 50;
					CashStock.cashStock.put("FIFTY",CashStock.cashStock.get("FIFTY")-num);
					System.out.println("Dispensing " + num + " 50$ note");
					if (remainder != 0)
						this.chain.dispense(new Amount(remainder));
				}else this.chain.dispense(cur);
				
			} else {
				this.chain.dispense(cur);
			}
		}

	}

}
