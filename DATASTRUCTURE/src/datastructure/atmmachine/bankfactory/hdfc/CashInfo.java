package datastructure.atmmachine.bankfactory.hdfc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CashInfo {
	int accNo;
	double amount;
	public static Map<Integer, Double> cash= new ConcurrentHashMap<>();
	static{
		cash.put(12, 10000.0);
		cash.put(34, 10000.0);
		cash.put(56, 10000.0);
	}

	public int getAccId() {
		return accNo;
	}

	public void setAccId(int accNo) {
		this.accNo = accNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
