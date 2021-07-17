package datastructure.atmmachine.bankfactory.hdfc;

public class TransactionInfo {
	int accNo;
	String transactionType;
	String Status;

	public int getAccId() {
		return accNo;
	}

	public void setAccId(int accNo) {
		this.accNo = accNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	String date;
	double amount;

}
