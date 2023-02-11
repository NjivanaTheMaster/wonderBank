package za.co.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Accounts {

    @Id
    private int acctID;
    private int balance;
    private String acctStatus;

    @OneToMany
    @JoinColumn(name = "accTypeID", referencedColumnName = "acctID")
    private List<AccountType> accountType;

    public Accounts() {
    }

    public Accounts(int acctID, int balance, String acctStatus, List<AccountType> accountType) {
        this.acctID = acctID;
        this.balance = balance;
        this.acctStatus = acctStatus;
        this.accountType = accountType;
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

    public List<AccountType> getAccountType() {
        return accountType;
    }

    public void setAccountType(List<AccountType> accountType) {
        this.accountType = accountType;
    }
}
