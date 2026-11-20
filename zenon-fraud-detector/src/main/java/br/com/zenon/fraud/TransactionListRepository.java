package br.com.zenon.fraud;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class TransactionListRepository implements TransactionRepository {

    private final List<Transaction> transactions;

    public TransactionListRepository(List<Transaction> transactions) {
        Objects.requireNonNull(transactions);
        this.transactions = transactions;
    }

    public Optional<Transaction> findByOriginName(String originName) {
        return transactions
                .stream()
                .filter(transaction -> transaction.origin().name().equals(originName))
                .findFirst();
    }
}
