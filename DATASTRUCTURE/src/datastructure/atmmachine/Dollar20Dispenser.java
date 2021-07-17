package datastructure.atmmachine;

public class Dollar20Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Amount cur) {
		// set the chain of responsibility
		setNextChain(new Dollar50Dispenser());
		if (CashStock.totalCashAvailable() >= 20) {
			if (cur.getAmount() >= 20) {
				int num = cur.getAmount() / 20;
				if(CashStock.cashStock.get("TWENTY")>=num){
					int remainder = cur.getAmount() % 20;
					CashStock.cashStock.put("TWENTY",CashStock.cashStock.get("TWENTY")-num);
					System.out.println("Dispensing " + num + " 20$ note");
					if (remainder != 0)
						this.chain.dispense(new Amount(remainder));
				}else this.chain.dispense(cur);
				
			} else {
				this.chain.dispense(cur);
			}
		}

	}

}
