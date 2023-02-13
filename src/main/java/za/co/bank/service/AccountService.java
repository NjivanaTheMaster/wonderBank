package za.co.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bank.dao.AccountsRepository;
import za.co.bank.model.Accounts;

@Service
public class AccountService {

    @Autowired // dependency injection
    private AccountsRepository accountsRepository;

    public void createAccount(Accounts acct) {
        accountsRepository.save(acct);
    }

    public Accounts getAccountInfo(int acctID) {
        return accountsRepository.findById(acctID).orElse(null);
    }

    public void deleteAccount(int acctID) {
        accountsRepository.deleteById(acctID);
    }

    public int getBalance(int acctID) {
        return accountsRepository.findCurrentAccountBalanceByAccID(acctID);
    }

    public void depositAmount(int acctID, int amount) {
        accountsRepository.depositAmountByAccID(acctID, amount);
    }

    public void withdrawAmount(int acctID, int amount) {
        accountsRepository.withdrawAmountByAcctID(acctID, amount);
    }
    public void withdrawAmountFromOverdraft(int acctID, int amount) {
        accountsRepository.withdrawOverdraftAmountByAcctID(acctID, amount);
    }

    public void transferAmount(int acctID, int destAcctID, int amount) {
        accountsRepository.withdrawAmountByAcctID(acctID, amount);
        accountsRepository.depositAmountByAccID(destAcctID, amount);
    }
}
