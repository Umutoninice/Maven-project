package banking;



public class savingAccount extends BankAccount {
    double interestRate;

    public savingAccount(String accountId, String owner, double balance, double interestRate, double rate) {
        super(accountId, owner, balance);
        this.interestRate = interestRate;

    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Owner: " + owner + "with interest rate of: " + interestRate + ". Balance: " + balance);

    }

    //Implement a new applyYearlyInterest(double rate) method on SavingsAccount.
    public void applyYearlyInterest(double rate){
        if (rate<0){
            throw new IllegalArgumentException("rate can not be negative");
        }
        double interest= getBalance() * rate;
        deposit(interest);
        System.out.println("Owner: " + owner + " has got interest of " + interest + " On rate of " + rate);
        System.out.println("The balance of owner: " + owner + " is " + balance);
    }
}