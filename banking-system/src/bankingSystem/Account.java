package bankingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    IdIncrementor idInc = new IdIncrementor();
    private String name;
    private int accountNumber;
    private BigDecimal balance;
    private ArrayList<Transaction> transactions;

    public Account(String name,BigDecimal balance){
        this.name = name;
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

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }

    public void recordTransaction(String type, BigDecimal amount){
        this.transactions.add(new Transaction(type, amount));
    }

    @Override
    public String toString(){
        StringBuilder trans = new StringBuilder();
        for(Transaction transaction : this.transactions){
            trans.append(transaction).append("\n");
        }

        //this.transactions.forEach(trans::append);
        return "ID: "+ accountNumber + " Name: "+ name + " Current Balance: " + balance + " \nTransaction Records: \n" + trans;

    }
}
