package bank;

public class StudentAccount extends SavingsAccount {

    private static final long serialVersionUID = 1L;

    private String institutionName;

    public StudentAccount(String name, double balance, String institutionName) throws Exception {
        super(name, balance, 20000);   // withdrawal limit for students
        this.min_balance = 100;        // allowed because min_balance is protected
        this.institutionName = institutionName;
    }

    @Override
    public String toString() {
        return super.toString() + ", Institution: " + institutionName;
    }
}
