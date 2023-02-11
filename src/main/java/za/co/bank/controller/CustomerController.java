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
        customerService.createCustomer(customer);
        accountController.createAccount(customer.getAccID(), 0, "Active",customer.getAccountType());
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
