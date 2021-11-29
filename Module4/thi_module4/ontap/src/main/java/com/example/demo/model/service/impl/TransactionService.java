package com.example.demo.model.service.impl;

import com.example.demo.model.entity.Transaction;
import com.example.demo.model.repository.ITransactionRepository;
import com.example.demo.model.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return this.transactionRepository.findAll();
    }

    @Override
    public Transaction findById(int id) {
        return this.transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        this.transactionRepository.delete(transaction);
    }
}
