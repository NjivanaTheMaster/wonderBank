package za.co.bank.dao;

import org.springframework.data.repository.CrudRepository;
import za.co.bank.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
