package bankingSystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        BankingService service = new BankingService();

        service.createAccount(BigDecimal.valueOf(20000));

        try{
            service.getBalance();
            System.out.println("You balance is: " + service.getBalance());
        }catch (NullBalanceException e){
            System.out.println(e.getMessage());
        }
        if(service.withdrawMoney(BigDecimal.valueOf(10000))){
            System.out.println("You've withdrawn:" + BigDecimal.valueOf(10000));
        }else{
            System.out.println("Insufficient fund.");
        }

        try{
            service.getBalance();
            System.out.println("You balance is: " + service.getBalance());
        }catch (NullBalanceException e){
            System.out.println(e.getMessage());
        }
        service.depositMoney(BigDecimal.valueOf(35000));

        try{
            service.getBalance();
            System.out.println("You balance is: " + service.getBalance());
        }catch (NullBalanceException e){
            System.out.println(e.getMessage());
        }

        service.showTransactions().forEach(System.out::println);

        System.out.println(service.myDetails());



    }
}