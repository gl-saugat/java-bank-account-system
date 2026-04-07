package bankingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    IdIncrementor idInc = new IdIncrementor();
    private int accountNumber;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(BigDecimal balance){
        accountNumber = IdIncrementor.getId();
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void addBalance(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void subtractBalance(BigDecimal amount){
        this.balance = this.balance.subtract(amount);
    }

    public void recordTransaction(String type, BigDecimal amount){
        this.transactions.add(new Transaction(type, amount));
    }
}
