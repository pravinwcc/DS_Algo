package datastructure.atmmachine;

public class Dollar10Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Amount cur) {
		// set the chain of responsibility
		setNextChain(new Dollar50Dispenser());
		if (CashStock.totalCashAvailable() >= 10) {
			if (cur.getAmount() >= 10) {
				int num = cur.getAmount() / 100;
				if(CashStock.cashStock.get("TEN")>=num){
					int remainder = cur.getAmount() % 10;
					CashStock.cashStock.put("TEN",CashStock.cashStock.get("TEN")-num);
					System.out.println("Dispensing " + num + " 10$ note");
					if (remainder != 0)
						this.chain.dispense(new Amount(remainder));
				}else this.chain.dispense(cur);
				
			} else {
				this.chain.dispense(cur);
			}
		}

	}

}