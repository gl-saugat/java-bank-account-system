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
}
