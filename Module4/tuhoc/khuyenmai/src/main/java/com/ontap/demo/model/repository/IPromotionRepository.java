package com.ontap.demo.model.repository;

import com.ontap.demo.model.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query(value="select * from promotion where (?1 between start_date and end_date) or (?2 between start_date and end_date) and (detail like %?3%)",nativeQuery=true)
    List<Promotion> search(String startDateSearch, String endDateSearch, String detailSearch);
}
