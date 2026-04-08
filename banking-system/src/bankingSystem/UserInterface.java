package bankingSystem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private BankingService service = new BankingService();
    public UserInterface(Scanner scanner){
        this.scan = scanner;
    }

    public void start(){
        bankingMenu();
    }

    public void mainMenu(){
        while (true){
            System.out.println("Enter your id to login:");
            int input = Integer.parseInt(scan.nextLine());
            if(service.checkUser(input)){
                bankingMenu();
                break;
            }
            System.out.println("Do you want to enroll? Y/N");
            String answer = scan.nextLine();
            if(answer.equals("Y")){

            }
        }
    }

    public void bankingMenu(){
        while(true){
            printMenu();
            int input = getMenuOption();

            switch (input){
                case 1:
                    System.out.println("Enter you name please:");
                    String name = scan.nextLine();
                    System.out.println("Enter the balance you want to open account with: ");
                    BigDecimal amount = getMoneyAmount();
                    service.createAccount(name, amount);
                    break;

                case 2:
                    System.out.println("Enter the amount you want to deposit : ");
                    BigDecimal addAmount = getMoneyAmount();
                    service.depositMoney(addAmount);
                    System.out.println("You're " + addAmount + "has been deposited.");
                    break;

                case 3:
                    try {
                        System.out.println("Enter the amount you want to withdraw : ");
                        BigDecimal takeAmount = getMoneyAmount();
                        service.checkBalance(takeAmount);
                        service.withdrawMoney(takeAmount);
                        System.out.println("You're " + takeAmount + "has been withdrawn.");
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Your current balance is: " + service.getBalance());
                    break;

                case 5:
                    List<Transaction> trans= service.showTransactions();
                    if(trans.isEmpty()){
                        System.out.println("No transactions performed yet.");
                        break;
                    }
                    trans.forEach(System.out::println);
                    break;

                case 6:
                    return;
            }

        }
    }

    public void printMenu(){
        System.out.println("""
                1. Create Account
                2. Deposit
                3. Withdraw
                4. View Balance
                5. View Transactions""");
    }

    public int getMenuOption(){
        while(true){
            try{
                int input = Integer.parseInt(scan.nextLine());
                if(input > 0 && input < 7){
                    return input;
                }
                System.out.println("Please enter valid option.");

            }catch (Exception e){
                System.out.println("Invalid input!");
            }
        }
    }

    public BigDecimal getMoneyAmount(){
        while(true){
            try{
                BigDecimal input = BigDecimal.valueOf(Long.parseLong(scan.nextLine()));
                if(input.floatValue()> 0){
                    return input;
                }
                System.out.println("Please enter positive value.");
            }catch (Exception e){
                System.out.println("Invalid amount!!");
            }
        }
    }
}
