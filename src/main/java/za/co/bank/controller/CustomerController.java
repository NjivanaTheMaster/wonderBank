package za.co.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.bank.model.Customer;
import za.co.bank.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountController accountController;

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer) {
        if(customer != null) {
            customerService.createCustomer(customer);
            if(customer.getAccounts().getAccountType().getAccountName() == "SAVINGS"){
                if(customer.getAccounts().getBalance() >= 1000){
                    // Saving account set overdraftLimit to zero
                    customer.getAccounts().setOverdraftLimit(0);
                    accountController.createAccount(customer.getCustID(), customer.getAccounts().getBalance(), "Active",customer.getAccounts().getOverdraftLimit(),customer.getAccounts().getAccountType());
                }
            }else{ // this is a CURRENT account
                accountController.createAccount(customer.getCustID(), customer.getAccounts().getBalance(), "Active",customer.getAccounts().getOverdraftLimit(), customer.getAccounts().getAccountType());
            }
        }
    }

    @GetMapping("/customer/{acctID}")
    public Customer getCustomerInfo(@PathVariable int acctID) {
        return customerService.getCustomerInfo(acctID);
    }

    @DeleteMapping("/customer/{acctID}")
    public void deleteCustomer(@PathVariable int acctID) {
        customerService.deleteCustomer(acctID);
    }
}
