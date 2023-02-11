package za.co.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import za.co.bank.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Integer>, JpaRepository<Accounts,Integer> {
    //CrudRepository: provides CRUD functions
    //PagingAndSortingRepository: provides methods to do pagination and sort records
    //JpaRepository: provides JPA related methods such as flushing the persistence context and delete records in a batch

    // @Query("select u from User u where u.firstname = :#{#customer.firstname}")
    //List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);

    @Query("select balance from Accounts where acctID = ?1")
    public int findCurrentAccountBalanceByAccID(int accID);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance+?2 where acctID=?1")
    public void depositAmountByAccID(int accID, int amount);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance-?2 where acctID=?1")
    public void withdrawAmountByAcctID(int acctID, int amount);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Accounts set balance = balance+?2 where acctID=?1")
    public void transferAmountByAcctID(int acctID, int amount);
}
