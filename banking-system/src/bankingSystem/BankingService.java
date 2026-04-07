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

    public BigDecimal getBalance() throws NullBalanceException{
        checkBalance(currentAcc);
        return currentAcc.getBalance();
    }

    public boolean withdrawMoney(BigDecimal money) {
        if(currentAcc.getBalance().compareTo(money) <= 0){
            return false;
        }
        currentAcc.subtractBalance(money);
        currentAcc.recordTransaction("Withdrawn", money);
        return true;

    }

    public void depositMoney(BigDecimal money){
        currentAcc.addBalance(money);
        currentAcc.recordTransaction("Deposited", money);
    }

    public List<Transaction> showTransactions(){
        return currentAcc.getTransactions().stream().toList();
    }

    public String myDetails(){
        return currentAcc.toString();
    }


    public void checkBalance(Account account) throws NullBalanceException{
        boolean isThereBalance = true;
        if(account.getBalance().equals(BigDecimal.ZERO)){
            throw new NullBalanceException("Sorry, but you're account is empty");
        }

    }
}
