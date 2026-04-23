package bankingSystem;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class BankingService {
    HashMap<Integer, Account> users = new HashMap<>();


    public Account createAccount(String name, BigDecimal balance){
        Account userAccount = new Account(name, balance);
        this.users.put(userAccount.getAccountNumber(), userAccount);
        return userAccount;
    }

    public BigDecimal getBalance(Account currentAcc){
        return currentAcc.getBalance();
    }

    public Map<Integer, Account> getUsers(){
        return Collections.unmodifiableMap(this.users);
    }


    public void depositMoney(Account currentAcc, BigDecimal money) throws NegativeValueException{
        int check = money.compareTo(BigDecimal.ZERO);
        if(check<0){
            throw new NegativeValueException("Can't enter negative values!!");
        }
        currentAcc.addBalance(money);
        currentAcc.recordTransaction("Deposited", money);
    }



    public void withdrawMoney(Account currentAcc, BigDecimal money) throws NegativeValueException{
        int check = money.compareTo(BigDecimal.ZERO);
        if(check<0){
            throw new NegativeValueException("Can't enter negative values!!");
        }
        currentAcc.subtractBalance(money);
        currentAcc.recordTransaction("Withdrawn", money);

    }

    public List<Transaction> showTransactions(Account currentAcc){
        return currentAcc.getTransactions().stream().toList();
    }

    public String myDetails(Account currentAcc){
        return currentAcc.toString();
    }


    public void checkBalance(Account currentAcc, BigDecimal money) throws InsufficientBalanceException{
        int value = currentAcc.getBalance().compareTo(money);
        if(value < 0){
            throw new InsufficientBalanceException("Sorry, you don't have sufficient balance.");
        }
    }

    public boolean checkUser(int id){
        return this.users.keySet().stream().anyMatch(i -> i == id);
    }






}
