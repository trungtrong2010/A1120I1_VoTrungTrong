package com.codegym.furama.model.repository.contract;

import com.codegym.furama.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select c from Contract c where (c.starDate=:startDate) and (c.endDate = :endDate)")
    Page<Contract> findAllByStarDateAndEndDate(Optional<LocalDateTime> startDate, Optional<LocalDateTime> endDate, Pageable pageable);
}
