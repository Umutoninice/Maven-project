package banking;



public class savingAccount extends BankAccount {
    double interestRate;
    public savingAccount(String accountId, String owner, double balance, double interestRate) {
        super(accountId, owner, balance);
        this.interestRate=interestRate;

    }
    public void applyInterest(){
        double interest= balance * interestRate/100;
        balance += interest;
        System.out.println("Owner: " + owner + "with interest rate of: " + interestRate + ". Balance: " + balance);

    }

}
