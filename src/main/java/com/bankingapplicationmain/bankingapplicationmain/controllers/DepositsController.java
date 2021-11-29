package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.services.DepositsService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/deposits")
public class DepositsController {

    @Autowired
    private DepositsService depositsService;

    //works
    @GetMapping("/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        return ResponseEntity.ok(depositsService.getDepositById(depositId));

    }

    //works
    @RequestMapping(value="/accounts/{accountId}/deposits",method = RequestMethod.GET)
    public ResponseEntity<?> getDepositsByAccountId(@PathVariable Long accountId) {
        return ResponseEntity.ok(depositsService.getDepositsByAccountId(accountId));
    }

    //works
    @PostMapping("/deposits")
    public ResponseEntity<?> createDeposit(@Valid @RequestBody Deposits deposit){
        return depositsService.createDeposit(deposit);
    }

    //works
    @PutMapping("/deposits/{depositId}")
    public ResponseEntity<Object> updateDeposits(@RequestBody Deposits deposits, @PathVariable Long depositId){
        return ResponseEntity.ok(depositsService.updateDeposit(deposits,depositId));
    }

    //works
    @DeleteMapping("/deposits/{depositId}")
    public ResponseEntity<Object> deleteDeposits(@PathVariable Long depositId){
        return ResponseEntity.accepted().body(depositsService.deleteDeposit(depositId)) ;
    }



}
