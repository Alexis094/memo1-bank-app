package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createDeposit(Long cbu, Double sum){

        double extra = (double) 0;
        double init_promo_sum = 2000.0;
        double cap_sum_promo = 500.0;

        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }

        //promo account:
        if (sum >= init_promo_sum) {
            if ((extra = sum* 0.10) > cap_sum_promo)
                extra = cap_sum_promo;
        }

        Transaction transaction = new Transaction(cbu, sum + extra, "Deposit");
        return transactionRepository.save(transaction);
    }

    public Transaction createExtraction(Long cbu, Double sum){
        Transaction transaction = new Transaction(cbu, sum, "Extraction");
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public Collection<Transaction> getTransactionsByAccountCbu(Long cbu){
        return transactionRepository.findTransactionsByAccountCbu(cbu);
    }

    public void deleteTransactionById(Long id){
        transactionRepository.deleteById(id);
    }
}