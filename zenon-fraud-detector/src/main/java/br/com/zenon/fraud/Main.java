package br.com.zenon.fraud;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		// Criando a transação 1
		Transaction tc1 = new Transaction(
				1,
				"PAYMENT",
				new BigDecimal("9838.64"),
				"C1231006815",
	            new BigDecimal("170136.0"),
	            new BigDecimal("160296.36"),
	            "M1979787155",
	            new BigDecimal("0.0"),
	            new BigDecimal("0.0"),
	            0,
	            0				
				);
		
		// criando a transação 2
		Transaction tc2 = new Transaction(
	            2,
	            "CASH_OUT",
	            new BigDecimal("850002.52"),
	            "C1280323807",
	            new BigDecimal("850002.52"),
	            new BigDecimal("0.0"),
	            "C873221189",
	            new BigDecimal("6510099.11"),
	            new BigDecimal("7360101.63"),
	            1,
	            0
	        );		
		
		System.out.println("Transação 1: " + tc1);
		System.out.println("Transação 2: " + tc2);		
	}

}
