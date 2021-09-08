package com.codegym.furama.model.service;

import com.codegym.furama.model.entity.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAll();

    ContractDetail findById(int id);

    void save(ContractDetail contractDetail);

    void delete(ContractDetail contractDetail);
}
