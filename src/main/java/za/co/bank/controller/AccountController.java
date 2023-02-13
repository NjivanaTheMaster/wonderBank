package za.co.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.bank.model.AccountType;
import za.co.bank.model.Accounts;
import za.co.bank.model.Logger;
import za.co.bank.service.AccountService;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private LoggerController loggerController;

    // createAccount happens upon createCustomer
    public void createAccount(int acctID, int balance, String acctStatus,int overdraftLimit, AccountType accountType) {
        Accounts acct = new Accounts(acctID, balance, acctStatus, overdraftLimit, accountType);
        accountService.createAccount(acct);
    }

    // checkBalance
    @GetMapping("/account/{acctID}/balance")
    public int getBalance(@PathVariable int acctID) {
        return accountService.getBalance(acctID);
    }

    // depositAmount
    @PutMapping("/account/{acctID}/deposit/{amount}")
    public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
        int initBal = getBalance(acctID);
        accountService.depositAmount(acctID, amount);
        Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
        loggerController.addLog(logger);
    }

    // withdrawAmount
    @PutMapping("/account/{acctID}/withdraw/{amount}")
    public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
        int initBal = getBalance(acctID);
        Accounts accounts = accountService.getAccountInfo(acctID);
        if(accounts.getAccountType().getAccountName() == "SAVINGS"){
            if(initBal >= 1000) {
                accountService.withdrawAmount(acctID, amount);
                Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
                loggerController.addLog(logger);
            }else{
                Logger logger = new Logger(acctID, "Withdrawn", "insufficient funds", initBal, initBal);
                loggerController.addLog(logger);
            }
        }else{ // This is a CURRENT account
            if(accounts.getOverdraftLimit() == 100000){ // There is an overdraftLimit set on the account
                int withdrawalAmount = initBal+accounts.getOverdraftLimit();
                if(amount > withdrawalAmount){
                    Logger logger = new Logger(acctID, "Withdrawn", "amount requested is more than the balance", initBal, withdrawalAmount);
                    loggerController.addLog(logger);
                }else{
                    // check if the initial balance is 0
                    if(initBal == 0){
                        // withdrawal will be made from the overdraftLimit amount
                        accountService.withdrawAmountFromOverdraft(acctID, amount);
                        Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, accounts.getOverdraftLimit() - amount);
                        loggerController.addLog(logger);
                    }else{
                        // he still has money, we subtract from balance
                        accountService.withdrawAmount(acctID, amount);
                        Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
                        loggerController.addLog(logger);
                    }
                }
            }else{ // No overdraft limit set
                accountService.withdrawAmount(acctID, amount);
                Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
                loggerController.addLog(logger);
            }
        }
    }

    // transferAmount
    @PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
    public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
        int initBalSender = getBalance(acctID);
        int initBalReceiver = getBalance(destAcctID);
        accountService.transferAmount(acctID, destAcctID, amount);
        Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
        loggerController.addLog(loggerSender);
        Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
                initBalReceiver + amount);
        loggerController.addLog(loggerReceiver);
    }

    // deleteAccount
    @DeleteMapping("/account/{acctID}")
    public void deleteAccount(@PathVariable int acctID) {
        accountService.deleteAccount(acctID);
        loggerController.deleteLog(acctID);
    }

    // getAccountInfo
    @GetMapping("/account/{acctID}")
    public Accounts getAccountInfo(@PathVariable int acctID) {
        return accountService.getAccountInfo(acctID);
    }
}
