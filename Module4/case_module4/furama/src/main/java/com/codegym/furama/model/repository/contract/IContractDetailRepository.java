package com.codegym.furama.model.repository.contract;

import com.codegym.furama.model.entity.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
