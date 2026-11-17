package br.com.zenon.fraud;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TransactionIngestor {

    public final int FRAUD_LIMIT = 50_000;

    public List<Transaction> read(String filename) {

        Path path = Path.of(filename);
        try {
            List<String> lines = Files.readAllLines(path);
            return lines.stream()
                    .skip(1)
                    .limit(FRAUD_LIMIT)
                    .map(this::parseTransaction)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + filename);
        }


    }

    private Optional<Transaction> parseTransaction(String line) {
        try {
            String[] chuncks = line.split(",");

            int step = Integer.parseInt(chuncks[0]);
            TransactionType type = TransactionType.valueOf(chuncks[1]);

            if (chuncks[2] == null || chuncks[2].trim().isEmpty()) throw new IllegalAccessException("O valor de amount não pode ser nulo nem vazio");
                BigDecimal amount = new BigDecimal(chuncks[2]);

            var origin = new TransactionCostumer(chuncks[3], new BigDecimal(chuncks[4]), new BigDecimal(chuncks[5]));
            var recipient = new TransactionCostumer(chuncks[6], new BigDecimal(chuncks[7]), new BigDecimal(chuncks[8]));

            boolean isFraud = "1".equals(chuncks[9]);
            boolean isFlaggedFraud = "1".equals(chuncks[10]);

            return Optional.of(new Transaction(step, type, amount,origin, recipient, isFraud, isFlaggedFraud));
        } catch (Exception e) {
            System.err.println("Erro ao fazer parse: " + line + " | " + e);
        }
        return Optional.empty();
    }
}
