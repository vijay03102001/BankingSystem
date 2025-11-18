package bank;

public class CurrentAccount extends BankAccount {

    private static final long serialVersionUID = 1L;

    private String tradeLicenseNumber;

    public CurrentAccount(String name, double balance, String tradeLicenseNumber) throws Exception {
        super(name, balance, 5000);  // min balance = 5000
        this.tradeLicenseNumber = tradeLicenseNumber;
    }

    public String getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }
}
