package banking;


public class checkingAccount extends BankAccount {
    double monthlyFee;
    public checkingAccount(String accountId, String owner, double balance, double monthlyFee) {

        super(accountId, owner, balance);
        this.monthlyFee=monthlyFee;
    }
    public void chargeMonthlyFee(){
if (balance < monthlyFee){
    System.out.println("Insufficient amount, balance: " + balance);
}
  balance -=monthlyFee;
        System.out.println("Owner: " + owner + "Monthly fees charged: " + monthlyFee + ". New balance: " + balance);
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}
