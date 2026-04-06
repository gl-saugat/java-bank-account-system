package bankingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private long accountNumber;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(long accNumber, BigDecimal balance){
        this.accountNumber = accNumber;
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
