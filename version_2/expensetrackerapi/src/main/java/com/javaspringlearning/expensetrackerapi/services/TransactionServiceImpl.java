package com.javaspringlearning.expensetrackerapi.services;

import java.util.List;

import com.javaspringlearning.expensetrackerapi.domain.Transaction;
import com.javaspringlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.javaspringlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note,
            Long transactionDate) throws EtBadRequestException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId)
            throws EtResourceNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeTransaction(Integer userId, Integer categoryId, Integer transactionId)
            throws EtResourceNotFoundException {
        // TODO Auto-generated method stub

    }

}
