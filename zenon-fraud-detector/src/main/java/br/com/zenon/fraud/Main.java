package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		var t1 = new Transaction (1, TransactionType.PAYMENT, new BigDecimal("9838.64"),
				new TransactionCostumer("C1231006815", new BigDecimal ("170136.0"), new BigDecimal ("160296.36")),
				new TransactionCostumer("M1979787155", new BigDecimal ("0.0"), new BigDecimal ("0.0")),
				false, false
		);

		var t2 = new Transaction (743, TransactionType.CASH_OUT, new BigDecimal ("850002.52"),
				new TransactionCostumer("C1280323807", new BigDecimal ("850002.52"), new BigDecimal ("0.0")),
				new TransactionCostumer("C873221189", new BigDecimal ("6510099.11"), new BigDecimal ("7360101.63")),
				true, false
		);

		System.out.println("Transação 1: " + t1);
		System.out.println("Transação 2: " + t2);

		IO.println("-----------------------------------------------------------------");

		var transactionIngestor =  new TransactionIngestor();
		List<Transaction> transactions = transactionIngestor.read("data/PS_20174392719_1491204439457_log.csv");
		IO.println(transactions.size());

		transactions.stream().limit(10).forEach(IO::println);

	}
}