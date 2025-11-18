package bank;

import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import java.io.Serializable;
import javax.swing.DefaultListModel;

public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    private BankAccount[] accounts = new BankAccount[100];

    // -------------------------
    // Add Account Overloads
    // -------------------------
    public int addAccount(BankAccount acc) {
        for (int i = 0; i < 100; i++) {
            if (accounts[i] == null) {
                accounts[i] = acc;
                return i;
            }
        }
        return -1;
    }

    public int addAccount(String name, double balance, double maxWithLimit) throws Exception {
        SavingsAccount acc = new SavingsAccount(name, balance, maxWithLimit);
        return addAccount(acc);
    }

    public int addAccount(String name, double balance, String tradeLicense) throws Exception {
        CurrentAccount acc = new CurrentAccount(name, balance, tradeLicense);
        return addAccount(acc);
    }

    // Student account
    public int addAccount(String name, String institutionName, double balance) throws Exception {
        StudentAccount acc = new StudentAccount(name, balance, institutionName);
        return addAccount(acc);
    }

    // -------------------------
    // Find Account
    // -------------------------
    public BankAccount findAccount(String accountNum) {
        for (int i = 0; i < 100; i++) {
            if (accounts[i] == null) continue;

            if (accounts[i].getAccNum().equals(accountNum)) {
                return accounts[i];
            }
        }
        return null;
    }

    // -------------------------
    // Deposit
    // -------------------------
    public void deposit(String accountNum, double amt)
            throws InvalidAmount, AccNotFound {

        if (amt < 0)
            throw new InvalidAmount("Invalid Deposit Amount");

        BankAccount temp = findAccount(accountNum);

        if (temp == null)
            throw new AccNotFound("Account Not Found");

        temp.deposit(amt);
    }

    // -------------------------
    // Withdraw
    // -------------------------
    public void withdraw(String accountNum, double amt)
            throws MaxBalance, AccNotFound, MaxWithdraw, InvalidAmount {

        BankAccount temp = findAccount(accountNum);

        if (temp == null)
            throw new AccNotFound("Account Not Found");

        if (amt <= 0)
            throw new InvalidAmount("Invalid Amount");

        if (amt > temp.getbalance())
            throw new MaxBalance("Insufficient Balance");

        temp.withdraw(amt);
    }

    // -------------------------
    // Display All Accounts → FIXED version
    // -------------------------
    public DefaultListModel<String> display() {
        DefaultListModel<String> list = new DefaultListModel<>();

        for (int i = 0; i < 100; i++) {
            if (accounts[i] == null) continue;   // FIXED (no break)
            list.addElement(accounts[i].toString());
        }

        return list;
    }

    public BankAccount[] getAccounts() {
        return accounts;
    }
}
