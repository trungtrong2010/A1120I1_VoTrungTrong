package com.codegym.furama.model.repository.employee;

import com.codegym.furama.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
