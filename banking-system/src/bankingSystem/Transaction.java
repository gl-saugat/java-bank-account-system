package bankingSystem;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaction {

    private String transactionType;
    private BigDecimal amount;
    private LocalDateTime timestamp;

    public Transaction(String transType, BigDecimal amt){
        this.transactionType = transType;
        this.amount = amt;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return transactionType + "Rs." + amount + " at " + this.timestamp;
    }
}
