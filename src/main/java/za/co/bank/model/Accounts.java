package za.co.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Accounts {

    @Id
    private int acctID;
    private int balance;
    private String acctStatus;
    private int overdraftLimit;

    @OneToMany
    @JoinColumn(name = "accTypeID", referencedColumnName = "acctID")
    private AccountType accountType;


    public Accounts() {
    }

    public Accounts(int acctID, int balance, String acctStatus,int overdraft, AccountType accountType) {
        this.acctID = acctID;
        this.balance = balance;
        this.acctStatus = acctStatus;
        this.accountType = accountType;
        this.overdraftLimit = overdraft;
    }

    public int getAcctID() {
        return acctID;
    }

    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
