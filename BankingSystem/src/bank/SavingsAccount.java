package bank;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class SavingsAccount extends BankAccount {

    private static final long serialVersionUID = 1L;

    private float rate = 0.05f;
    private double maxWithLimit;

    public SavingsAccount(String name, double balance, double maxWithLimit) throws Exception {
        super(name, balance, 2000); // min balance = 2000
        this.maxWithLimit = maxWithLimit;
    }

    public double getNetBalance() {
        return balance + (balance * rate);
    }

    @Override
    public void withdraw(double amount) throws MaxWithdraw, MaxBalance {
        if (amount < maxWithLimit) {
            super.withdraw(amount);
        } else {
            throw new MaxWithdraw("Maximum Withdraw Limit Exceeded");
        }
    }
}
