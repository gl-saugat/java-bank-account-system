package bankingSystem;

public class NullBalanceException extends Exception{
    public NullBalanceException(String message){
        super(message);
    }
}
