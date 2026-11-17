package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.Objects;

public record TransactionCostumer(String name, BigDecimal oldBalance, BigDecimal newBalance) {

    public TransactionCostumer {

        Objects.requireNonNull(name);
        Objects.requireNonNull(oldBalance);
        Objects.requireNonNull(newBalance);

        if (oldBalance.signum() < 0 ) throw new IllegalArgumentException("O valor de oldBallance deve ser positivo ou zero: " + oldBalance );
        if (newBalance.signum() < 0 ) throw new IllegalArgumentException("O valor de newBallance deve ser positivo ou zero: " + newBalance );
        if (name.trim().isEmpty()) throw new IllegalArgumentException("O name não pode ser vazio");
    }

}
