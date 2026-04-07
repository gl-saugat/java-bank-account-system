package bankingSystem;

public class IdIncrementor {
    private static int counter = 0;

    public static int getId() {
        return counter++;
    }
}

