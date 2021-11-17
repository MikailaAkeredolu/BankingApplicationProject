package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.repositories.DepositsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositsService {

    private static final Logger logger = LoggerFactory.getLogger(DepositsService.class);

    @Autowired
    private DepositsRepository depositsRepository;


    public ResponseEntity<?> getDeposits(Long accountId) {
        return ResponseEntity.ok(depositsRepository.findAll());
    }

    public ResponseEntity<?> getDepositById(Long id) {
        if(depositsRepository.findById(id).isEmpty()){
            logger.info("Deposit not found");
         //   throw new DepositsNotFoundById(); //uncomment this when DepositsNotFoundById exception is created
        }
        return ResponseEntity.ok(depositsRepository.findById(id));
    }

    //we need a post method
    public void addDeposit(Deposits deposits){
        depositsRepository.save(deposits);
        logger.info("Deposit successfully completed");
    }

    //a put method as well
    public void editDeposit(Long depositId, Deposits deposits){
        depositsRepository.save(deposits);
        logger.info("Deposit successfully Updated");
    }

    //delete method
    public void deleteDeposit(Long depositId){
        depositsRepository.delete(depositsRepository.getById(depositId));
        logger.info("Deposit successfully deleted");
    }




}
