package DefiningClasses.BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int bankAccountCounter = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccountCounter;
        bankAccountCounter++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest (int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }
    public int getId () {
        return id;
    }
}
