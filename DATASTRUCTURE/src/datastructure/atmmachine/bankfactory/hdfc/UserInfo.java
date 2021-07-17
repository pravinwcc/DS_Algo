package datastructure.atmmachine.bankfactory.hdfc;

import java.util.List;

public class UserInfo {
	String fName;
	String lName;
	int mobileNo;
	AccountInfo accountInfo;
	CardInfo cardInfo;
	CashInfo cashInfo;
	List<TransactionInfo> transactionInfo;

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public CashInfo getCashInfo() {
		return cashInfo;
	}

	public void setCashInfo(CashInfo cashInfo) {
		this.cashInfo = cashInfo;
	}

	public List<TransactionInfo> getTransactionInfo() {
		return transactionInfo;
	}

	public void setTransactionInfo(List<TransactionInfo> transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

}
