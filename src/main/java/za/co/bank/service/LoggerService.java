package za.co.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bank.dao.LoggerRepository;
import za.co.bank.model.Logger;

@Service
public class LoggerService {

    @Autowired
    private LoggerRepository loggerRepository;

    public void addLog(Logger logger) {
        loggerRepository.save(logger);
    }

    public Logger showLog(int acctID) {
        return loggerRepository.findById(acctID).orElse(null);
    }

    public void deleteLog(int acctID) {
        loggerRepository.deleteById(acctID);
    }
}
