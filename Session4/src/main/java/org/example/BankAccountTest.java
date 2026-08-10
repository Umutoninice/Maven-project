package org.example;

public class BankAccountTest {


    public static void main(String[] args) {
        System.out.println(" BANK ACCOUNT TESTS");
        System.out.println("===================");

        testDeposit();
        testDepositNegative();
        testWithdraw();
        testWithdrawInsufficientFunds();
        testWithdrawNegative();
        testEquals();
        testEqualsDifferentAccounts();

        System.out.println("\n ALL TESTS PASSED!");
        System.out.println("====================");
    }


    // TEST 1: Deposit - Valid Amount
    public static void testDeposit() {
        System.out.println("\nTest 1: Deposit - Valid Amount");
        System.out.println("--------------------------------");

        // Create account with initial balance of 100
        BankAccount account = new BankAccount("A001", "Nice Umutoni", 100.00);

        // Perform deposit
        account.deposit(50.00);

        // Assert: Balance should be 150.00
        assert account.getBalance() == 150.00 :
                "FAIL: Balance should be 150.00, but got " + account.getBalance();

        // Perform another deposit
        account.deposit(25.50);

        // Assert: Balance should be 175.50
        assert account.getBalance() == 175.50 :
                " FAIL: Balance should be 175.50, but got " + account.getBalance();

        System.out.println("    Deposit test passed!");
        System.out.println("   Final balance: " + account.getBalance());
    }


    // TEST 2: Deposit - Negative Amount (Should Throw Exception)

    public static void testDepositNegative() {
        System.out.println("\n Test 2: Deposit - Negative Amount");
        System.out.println("-------------------------------");

        BankAccount account = new BankAccount("A002", "Alice Uwera", 500.00);
        boolean exceptionThrown = false;

        try {
            // Try to deposit negative amount
            account.deposit(-100.00);
            // If we get here, the test fails
            assert false : " FAIL: deposit() should throw exception for negative amount";
        } catch (IllegalArgumentException e) {
            // Expected exception
            exceptionThrown = true;
            System.out.println("   Caught expected exception: " + e.getMessage());
        }

        // Assert: Balance should remain unchanged
        assert account.getBalance() == 500.00 :
                " FAIL: Balance should remain 500.00, but got " + account.getBalance();

        // Assert: Exception was thrown
        assert exceptionThrown : " FAIL: Exception should have been thrown";

        System.out.println("   Negative deposit test passed!");
        System.out.println("   Balance unchanged: $" + account.getBalance());
    }


    // TEST 3: Withdraw - Valid Amount

    public static void testWithdraw() {
        System.out.println("\n Test 3: Withdraw - Valid Amount");
        System.out.println("-------------------------");

        // Create account with initial balance of $200
        BankAccount account = new BankAccount("A003", "James Kalisa", 200.00);

        // Perform withdrawal
        account.withdraw(50.00);

        // Assert: Balance should be 150.00
        assert account.getBalance() == 150.00 :
                " FAIL: Balance should be 150.00, but got " + account.getBalance();

        // Perform another withdrawal
        account.withdraw(25.50);

        // Assert: Balance should be 124.50
        assert account.getBalance() == 124.50 :
                "FAIL: Balance should be 124.50, but got " + account.getBalance();

        System.out.println("   Withdraw test passed!");
        System.out.println("   Final balance: $" + account.getBalance());
    }


    // TEST 4: Withdraw - Insufficient Funds

    public static void testWithdrawInsufficientFunds() {
        System.out.println("\n Test 4: Withdraw - Insufficient Funds");
        System.out.println("-------------------------------");

        // Create account with initial balance of $100
        BankAccount account = new BankAccount("A004", "Charlie Keza", 100.00);
        boolean exceptionThrown = false;
        double balanceBefore = account.getBalance();

        try {
            // Try to withdraw more than balance
            account.withdraw(200.00);
            // If we get here, the test fails
            assert false : " FAIL: withdraw() should throw exception for insufficient funds";
        } catch (IllegalArgumentException e) {
            // Expected exception
            exceptionThrown = true;
            System.out.println("   Caught expected exception: " + e.getMessage());
        }

        // Assert: Balance should remain unchanged
        assert account.getBalance() == balanceBefore :
                " FAIL: Balance should remain " + balanceBefore +
                        ", but got " + account.getBalance();

        // Assert: Exception was thrown
        assert exceptionThrown : " FAIL: Exception should have been thrown";

        System.out.println("   Insufficient funds test passed!");
        System.out.println("   Balance unchanged: $" + account.getBalance());
    }

    // TEST 5: Withdraw - Negative Amount (Should Throw Exception)

    public static void testWithdrawNegative() {
        System.out.println("\n Test 5: Withdraw - Negative Amount");
        System.out.println("-".repeat(40));

        BankAccount account = new BankAccount("A005", "Diane Uwimana", 300.00);
        boolean exceptionThrown = false;
        double balanceBefore = account.getBalance();

        try {
            // Try to withdraw negative amount
            account.withdraw(-50.00);
            // If we get here, the test fails
            assert false : " FAIL: withdraw() should throw exception for negative amount";
        } catch (IllegalArgumentException e) {
            //  Expected exception
            exceptionThrown = true;
            System.out.println("   Caught expected exception: " + e.getMessage());
        }

        // Assert: Balance should remain unchanged
        assert account.getBalance() == balanceBefore :
                " FAIL: Balance should remain " + balanceBefore +
                        ", but got " + account.getBalance();

        // Assert: Exception was thrown
        assert exceptionThrown : " FAIL: Exception should have been thrown";

        System.out.println("   Negative withdrawal test passed!");
        System.out.println("   Balance unchanged: $" + account.getBalance());
    }


    // TEST 6: equals() - Two Accounts with Same ID

    public static void testEquals() {
        System.out.println("\n Test 6: equals() - Same Account ID");
        System.out.println("-------------------------------");

        // Create two accounts with the SAME account ID
        BankAccount account1 = new BankAccount("A006", "Lisa Ineza", 1000.00);
        BankAccount account2 = new BankAccount("A006", "Lisa Ineza Second", 2000.00);

        // Assert: accounts should be equal (same ID)
        assert account1.equals(account2) :
                " FAIL: Accounts with same ID should be equal";

        // Assert: hashCode should be the same
        assert account1.hashCode() == account2.hashCode() :
                "FAIL: Accounts with same ID should have same hashCode";

        System.out.println("   equals() test passed!");
        System.out.println("   Account1: " + account1);
        System.out.println("   Account2: " + account2);
        System.out.println("   Equal: " + account1.equals(account2));
    }


    // TEST 7: equals() - Two Accounts with Different IDs

    public static void testEqualsDifferentAccounts() {
        System.out.println("\n Test 7: equals() - Different Account IDs");
        System.out.println("-----------------------------------");

        // Create two accounts with DIFFERENT account IDs
        BankAccount account1 = new BankAccount("A007", "Frank Karekezi", 500.00);
        BankAccount account2 = new BankAccount("A008", "Frank Karekezi", 500.00);

        // Assert: accounts should NOT be equal (different ID)
        assert !account1.equals(account2) :
                "FAIL: Accounts with different IDs should NOT be equal";

        // Assert: hashCode should be different
        assert account1.hashCode() != account2.hashCode() :
                "FAIL: Accounts with different IDs should have different hashCode";

        System.out.println("   Different account IDs test passed!");
        System.out.println("   Account1: " + account1);
        System.out.println("   Account2: " + account2);
        System.out.println("   Equal: " + account1.equals(account2));
    }
}