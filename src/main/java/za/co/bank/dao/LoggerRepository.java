package za.co.bank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import za.co.bank.model.Logger;

public interface LoggerRepository extends CrudRepository<Logger, Integer> {

    @Query("select finalBal from Logger where acctID = ?1")
    public int findFinalBalanceByAccID(int accID);

    @Query("select initBal from Logger where acctID = ?1")
    public int findInitialBalanceByAccID(int accID);
}
