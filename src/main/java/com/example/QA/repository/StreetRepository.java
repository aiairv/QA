package com.example.QA.repository;

import com.example.QA.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Long> {
    List<Street> findByCityId(Long cityId);
}
