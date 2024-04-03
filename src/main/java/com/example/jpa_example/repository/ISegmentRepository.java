package com.example.jpa_example.repository;

import com.example.jpa_example.entity.SegmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISegmentRepository extends JpaRepository<SegmentEntity, Long> {
}
