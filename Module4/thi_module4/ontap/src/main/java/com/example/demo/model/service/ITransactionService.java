package com.example.demo.model.service;

import com.example.demo.model.entity.Transaction;

import java.util.List;

public interface ITransactionService {

    List<Transaction> findAll();

    Transaction findById(int id);

    void save(Transaction transaction);

    void delete(Transaction transaction);
}
