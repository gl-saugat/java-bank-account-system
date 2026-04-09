package bankingSystem;

public class IdIncrementor {
    private static int counter = 1;

    public static int getId() {
        return counter++;
    }
}

