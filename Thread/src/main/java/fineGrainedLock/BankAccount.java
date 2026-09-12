package fineGrainedLock;

public class BankAccount {

    private int accountId;
    public final Object lock = new Object();
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

    public void transfer(BankAccount from,
                         BankAccount to,
                         int amount) {
        BankAccount first = from.getAccountId() < to.getAccountId() ? from : to;
        BankAccount second = from.getAccountId() < to.getAccountId() ? to : from;
        synchronized (first.lock) {
            synchronized (second.lock) {
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
}


//using atomic integer
//AtomicInteger balance = new AtomicInteger(1000);
//
//public boolean withdraw(int amount) {
//    int current = balance.get();
//
//    if (current < amount) {
//        return false;
//    }
//
//    if (balance.compareAndSet(current , current - amount)) {
//        return true;
//    }
//}