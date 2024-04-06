package com.example.jpa_example.repository;

import com.example.jpa_example.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
    Page<BookEntity> findByBookNameContains(String bookName, Pageable pageable);
}
