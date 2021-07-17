package datastructure.atmmachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CashStock {
	static Map<String, Integer> cashStock = new ConcurrentHashMap<String, Integer>();

	public static void setCashStock() {
		cashStock.put(Notes.HUNDREDE.getValue(), 2);
		cashStock.put(Notes.FIFTY.getValue(), 3);
		cashStock.put(Notes.TWENTY.getValue(), 4);
		cashStock.put(Notes.TEN.getValue(), 5);
	}

	public static Integer getAvailableCash(String note) {
		switch (note) {
		case "HUNDREDE":
			return cashStock.get(note) != null ? cashStock.get(note) * 100 : 0;

		case "FIFTY":
			return cashStock.get(note) != null ? cashStock.get(note) * 50 : 0;

		case "TWENTY":
			return cashStock.get(note) != null ? cashStock.get(note) * 20 : 0;

		case "TEN":
			return cashStock.get(note) != null ? cashStock.get(note) * 10 : 0;

		default:
			System.out.println("Not in 10, 20 or 30");
		}
		return 0;

	}

	public static Integer totalCashAvailable() {
		return ((cashStock.get(Notes.HUNDREDE.getValue()) != null ? cashStock.get(Notes.HUNDREDE.getValue()) * 100 :0) + 
				(cashStock.get(Notes.FIFTY.getValue()) != null ? cashStock.get(Notes.FIFTY.getValue()) * 50 :0)+
				(cashStock.get(Notes.TWENTY.getValue()) != null ? cashStock.get(Notes.TWENTY.getValue()) * 20 :0) + 
				(cashStock.get(Notes.TWENTY.getValue()) != null ? cashStock.get(Notes.TEN.getValue()) * 10 :0));

	}

	public static String cashStatus() 
	{
		if((cashStock.get(Notes.HUNDREDE.getValue())*100+
				cashStock.get(Notes.FIFTY.getValue())*50+
				cashStock.get(Notes.TWENTY.getValue())*20+ 
				cashStock.get(Notes.TEN.getValue())*10)!=0)
			return "AVAILABLE";
		else		return "NOT AVAILABLE";
	}

}
