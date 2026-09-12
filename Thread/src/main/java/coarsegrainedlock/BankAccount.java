package coarsegrainedlock;

public class BankAccount {

    private final int accountId;
    private int balance;

    public BankAccount(int accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {

        BankAccount a = new BankAccount(1, 1000);
        BankAccount b = new BankAccount(2, 500);
        BankAccount c = new BankAccount(3, 2000);

        Bank bank = new Bank();

        Thread t1 = new Thread(() -> bank.transfer(a, b, 200));
        Thread t2 = new Thread(() -> bank.transfer(b, c, 100));
        Thread t3 = new Thread(() -> bank.transfer(a, c, 100));
        Thread t4 = new Thread(() -> bank.transfer(c, a, 50));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Bank {

    private final Object bankLock = new Object();

    public void transfer(BankAccount from,
                         BankAccount to,
                         int amount) {

        synchronized (bankLock) {

            if (from.getBalance() < amount) {
                System.out.println("Insufficient balance");
                return;
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            System.out.println(
                    "Transferred " + amount +
                            " from " + from.getAccountId() +
                            " to " + to.getAccountId()
            );

        }
    }
}