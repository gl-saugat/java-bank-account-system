package bankingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingService {
    ArrayList<Account> accounts = new ArrayList<>();

    public void createAccount(BigDecimal balance){
        Account userAccount = new Account(balance);
        accounts.add(userAccount);
    }
}
