package br.com.zenon.fraud;

import java.math.BigDecimal;

public record Transaction(int step, TransactionType type, BigDecimal amount, TransactionCostumer origin,
						  TransactionCostumer recipiente, boolean isFraud, boolean isFlaggedFraud) {
}
