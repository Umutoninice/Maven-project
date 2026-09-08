package org.example.banking;

import org.example.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
private BankAccount account;
private static final String ACCOUNT_NUMBER="12345";
private static final String ACCOUNT_HOLDER=" Nice";
@BeforeEach
    void setUp(){
    account = new BankAccount(ACCOUNT_NUMBER,ACCOUNT_HOLDER, 2000.0);
}
@Test
@DisplayName("Constructor should create valid account")
void testConstructorValid(){
    assertAll(
            ()-> assertEquals(ACCOUNT_NUMBER,account.getAccountNumber()),
            ()->assertEquals(ACCOUNT_HOLDER,account.getAccountHolder()),
            ()-> assertEquals(2000.0, account.getBalance(),0.002)
    );
}
@Test
@DisplayName("Constructor should reject null account number")
void testConstructorNullAccountNumber(){
    assertThrows(IllegalArgumentException.class, () -> new BankAccount(null, ACCOUNT_HOLDER, 2000.0));

}
    @Test
    @DisplayName("Constructor should reject empty account number")
void testConstructorEmptyAccountNumber(){
    assertThrows(IllegalArgumentException.class, ()-> new BankAccount("",ACCOUNT_HOLDER,2000.0));

}
@Test
    @DisplayName(" Construct should reject null account holder")
    void testConstructorNullAccountHolder(){
    assertThrows(IllegalArgumentException.class, ()-> new BankAccount(ACCOUNT_NUMBER,null,2000.0));

}
    @Test
    @DisplayName(" Construct should reject empty account holder")
    void testConstructorEmptyAccountHolder() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(ACCOUNT_NUMBER, "", 2000.0));
    }
@Test
    @DisplayName("Deposit should increase balance - successful deposit")
void testSuccessfulDeposit(){
    account.deposit(500.0);
    assertEquals(2500.0, account.getBalance());
}
@Test
    @DisplayName("Deposit of zero")
    void testDepositOfZero(){
assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
}
@Test
    @DisplayName(" Deposit of negative amount")
    void testDepositOfNegativeAmount(){
    assertThrows(IllegalArgumentException.class,()-> account.deposit(-50.0) );
}
@Test
    @DisplayName("Withdraw should decrease balance - Successful withdrawal")
    void testWithdrawValid() throws InsufficientFundsException {
    account.withdraw(1000.0);
    assertEquals(1000.0 , account.getBalance());
}
@Test
    @DisplayName("Withdrawal should throw InsufficientFundsException on overdraft")
            void testWithdrawOverdraft(){
                InsufficientFundsException exception= assertThrows(InsufficientFundsException.class, ()-> account.withdraw(4000.0));
                assertEquals(2000.0 , account.getBalance());
}
@Test
    @DisplayName("Withdraw exactly balance should succeed")
    void testWithdrawExactlyBalance() throws InsufficientFundsException {
    account.withdraw(2000.0);
    assertEquals(0.0, account.getBalance());
}
@Test
    @DisplayName("Withdraw should reject negative amount")
            void testWithdrawNegativeAmount(){
    assertThrows(IllegalArgumentException.class,()-> account.withdraw(-500));
}
@Test
    @DisplayName("Withdrawal should reject zero amount")
void testWithdrawZero(){
    assertThrows(IllegalArgumentException.class,()-> account.withdraw(0));
}
@Test
    @DisplayName(" toString should format correctly")
    void testToString(){

    String expected="BankAccount{ accountNumber= 12345, accountHolder=  Nice, balance= 2000.0}";
    assertEquals(expected, account.toString());
}
@Test
    @DisplayName("toString should update with new balance")
    void testToStringAfterChanges() throws InsufficientFundsException{
    account.deposit(200.0);
    account.withdraw(100.0);
    String expected= "BankAccount{ accountNumber= 12345, accountHolder=  Nice, balance= 2100.0}";
    assertEquals(expected, account.toString());
}
@Test
    @DisplayName("Equals should return true for identical accounts")
    void testEqualsIdentical(){
    BankAccount another= new BankAccount(ACCOUNT_NUMBER,ACCOUNT_HOLDER,2000.0);
    assertEquals(account, another);
}
@Test
    @DisplayName("Equals should return false for different account number")
    void testEqualsDifferentAccountNumber(){
    BankAccount another=new BankAccount("6789", ACCOUNT_HOLDER,2000.0);
    assertNotEquals(account,another);
}
    @Test
    @DisplayName("equals should return false for different account holder")
    void testEqualsDifferentAccountHolder() {
        BankAccount another = new BankAccount(ACCOUNT_NUMBER, "Aline", 2000.0);
        assertNotEquals(account, another);
    }

    @Test
    @DisplayName("equals should return false for different balance")
    void testEqualsDifferentBalance() {
        BankAccount another = new BankAccount(ACCOUNT_NUMBER, ACCOUNT_HOLDER, 3000.0);
        assertNotEquals(account, another);
    }
    @Test
    @DisplayName("hashCode should be consistent with equals")
    void testHashCodeConsistency() {
        BankAccount another = new BankAccount(ACCOUNT_NUMBER, ACCOUNT_HOLDER, 2000.0);
        assertEquals(account.hashCode(), another.hashCode());
    }
    @Test
    @DisplayName("Multiple deposits should compound correctly")
    void testMultipleDeposits(){
    account.deposit(500.0);
    account.deposit(200.0);
    account.deposit(300.0);
    assertEquals(3000.0, account.getBalance());
    }
    @Test
    @DisplayName("Multiple withdrawals should compound correctly")
    void testMultipleWithdraw() throws InsufficientFundsException{
    account.withdraw(500.0);
    account.withdraw(600.0);
    account.withdraw(100.0);
    assertEquals(800.0, account.getBalance());
    }
}