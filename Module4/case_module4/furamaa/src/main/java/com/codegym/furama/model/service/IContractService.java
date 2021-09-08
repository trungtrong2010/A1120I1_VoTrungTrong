package com.codegym.furama.model.service;

import com.codegym.furama.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IContractService {

    List<Contract> findAll();

    Page<Contract> findAllByStarDateAndEndDate(Optional<LocalDateTime> startDate, Optional<LocalDateTime> endDate, Pageable pageable);


    Contract findById(Integer id);

    void save(Contract contract);

    void delete(Contract contract);

}
