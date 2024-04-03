package com.example.jpa_example.repository;

import com.example.jpa_example.entity.TenureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITenureRepository extends JpaRepository<TenureEntity, Long> {
}
