package za.co.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountType {

    @Id
    private int accTypeID;
    private String accountName;

    public AccountType() {
    }

    public AccountType(int accTypeID, String accountType) {
        this.accTypeID = accTypeID;
        this.accountName = accountType;
    }

    public int getAccTypeID() {
        return accTypeID;
    }

    public void setAccTypeID(int accTypeID) {
        this.accTypeID = accTypeID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
