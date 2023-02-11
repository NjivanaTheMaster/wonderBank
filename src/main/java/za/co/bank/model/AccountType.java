package za.co.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountType {

    @Id
    private int accTypeID;
    private String accountType;

    public AccountType() {
    }

    public AccountType(int accTypeID, String accountType) {
        this.accTypeID = accTypeID;
        this.accountType = accountType;
    }

    public int getAccTypeID() {
        return accTypeID;
    }

    public void setAccTypeID(int accTypeID) {
        this.accTypeID = accTypeID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
