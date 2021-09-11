package com.codegym.test.model.repository;

import com.codegym.test.model.entity.KhuyenMai;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IKhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {
    @Query(value="select * from khuyen_mai where discount_rate like %?1% and start_date like %?2%  and end_date like %?3%", nativeQuery=true)
    List<KhuyenMai> find3Truong(String discount, String startDate, String endDate);
}
