package com.codegym.furama.model.service.impl;

import com.codegym.furama.model.entity.contract.Contract;
import com.codegym.furama.model.repository.contract.IContractRepository;
import com.codegym.furama.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return this.contractRepository.findAll();
    }

    @Override
    public Page<Contract> findAllByStarDateAndEndDate(Optional<LocalDateTime> startDate, Optional<LocalDateTime> endDate, Pageable pageable) {
        return this.findAllByStarDateAndEndDate(startDate, endDate, pageable);
    }


    @Override
    public Contract findById(Integer id) {
        return this.contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public void delete(Contract contract) {
        this.contractRepository.delete(contract);
    }
}
