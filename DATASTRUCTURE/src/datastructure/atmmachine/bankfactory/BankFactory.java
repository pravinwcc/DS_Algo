package datastructure.atmmachine.bankfactory;

public class BankFactory {

	public Bank getBank(Integer cardNo) {
		switch (cardNo) {
		case 12:
			return new HDFC();
		case 34:
			return new SBI();
		default:
			return null;
		}

	}

}// End of the BankFactory class.