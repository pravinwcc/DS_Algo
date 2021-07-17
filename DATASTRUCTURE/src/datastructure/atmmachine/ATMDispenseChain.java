package datastructure.atmmachine;

import java.util.Scanner;

import datastructure.atmmachine.bankfactory.Bank;
import datastructure.atmmachine.bankfactory.BankFactory;
import datastructure.atmmachine.bankfactory.hdfc.CashInfo;

public class ATMDispenseChain {
	private static void cashDispensh(int cardNo,int amount){
		if (amount % 10 != 0) {
			System.out.println("Amount should be in multiple of 10s.");
			return;
		}
		// process the request
		if (CashStock.cashStatus().equals("AVAILABLE") && CashInfo.cash.get(cardNo) >= amount)
			new Dollar100Dispenser().dispense(new Amount(amount));
		else
			System.out.println("Cash Not Available");
	}

	public static void main(String[] args) {
		CashStock.setCashStock();
		System.out.println("Enter card no to cash withdrow");
		Scanner card = new Scanner(System.in);
		int cardNo = card.nextInt();
		BankFactory b = new BankFactory();
		Bank bank = b.getBank(cardNo);
		String bankName = bank == null ? null : bank.getBankName();
		if (bankName == null) {
			System.out.println("Enter valid card no to cash withdrow");
			return;
		}

		System.out.println("Enter amount to dispense");
		Scanner input = new Scanner(System.in);
		int amount = input.nextInt();

		switch (bankName) {
		case "HDFC": {
			cashDispensh(cardNo,amount);
			break;
		}
		case "SBI": {
			cashDispensh(cardNo,amount);break;
		}
		default:
			System.out.println("Bank details not available !!");
		}

	}

}
