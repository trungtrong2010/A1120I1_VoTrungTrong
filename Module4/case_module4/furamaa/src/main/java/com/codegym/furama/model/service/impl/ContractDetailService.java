package com.codegym.furama.model.service.impl;

import com.codegym.furama.model.entity.contract.ContractDetail;
import com.codegym.furama.model.repository.contract.IContractDetailRepository;
import com.codegym.furama.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(int id) {
        return this.contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        this.contractDetailRepository.delete(contractDetail);
    }
}
