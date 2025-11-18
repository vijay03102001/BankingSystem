package bank;

import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import java.io.Serializable;

public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String name;        // changed to protected
    protected double balance;     // changed to protected
    protected double min_balance; // changed to protected

    private String acc_num; // keep private

    public BankAccount(String name, double balance, double min_balance) throws Exception {
        if (balance < min_balance) {
            throw new Exception("Initial balance cannot be less than minimum balance: " + min_balance);
        }
        this.name = name;
        this.balance = balance;
        this.min_balance = min_balance;

        // auto-generate account number
        this.acc_num = 10000 + (int) (Math.random() * 89999) + "";
    }

    public String getAccNum() {
        return acc_num;
    }

    public void deposit(double amount) throws InvalidAmount {
        if (amount <= 0) {
            throw new InvalidAmount("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws MaxWithdraw, MaxBalance {
        if ((balance - amount) >= min_balance && amount < balance) {
            balance -= amount;
        } else {
            throw new MaxBalance("Insufficient Balance");
        }
    }

    public double getbalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Id: " + acc_num + ", Balance: " + balance +
               ", Type: " + this.getClass().getSimpleName();
    }
}
