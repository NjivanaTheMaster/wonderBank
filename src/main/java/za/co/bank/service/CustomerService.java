package za.co.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bank.dao.CustomerRepository;
import za.co.bank.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerInfo(int acctID) {
        return customerRepository.findById(acctID).orElse(null);
    }

    public void deleteCustomer(int acctID) {
        customerRepository.deleteById(acctID);
    }
}
