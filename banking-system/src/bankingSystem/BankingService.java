package bankingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankingService {
    ArrayList<Account> accounts = new ArrayList<>();
    Account currentAcc;

    public void createAccount(BigDecimal balance){
        Account userAccount = new Account(balance);
        currentAcc = userAccount;
        accounts.add(userAccount);
    }

    public BigDecimal getBalance(){
        return currentAcc.getBalance();
    }

    public void depositMoney(BigDecimal money){
        currentAcc.addBalance(money);
        currentAcc.recordTransaction("Deposited", money);
    }

    public void withdrawMoney(BigDecimal money){
        currentAcc.subtractBalance(money);
        currentAcc.recordTransaction("Withdrawn", money);

    }

    public List<Transaction> showTransactions(){
        return currentAcc.getTransactions().stream().toList();
    }

    public String myDetails(){
        return currentAcc.toString();
    }


    public void checkBalance(BigDecimal money) throws InsufficientBalanceException{
        int value = currentAcc.getBalance().compareTo(money);
        if(value <= 0){
            throw new InsufficientBalanceException("Sorry, you don't have sufficient balance.");
        }
    }
}
