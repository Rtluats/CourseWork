package com.library.spring.repository;

import com.library.spring.models.SpecificBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificBookRepository extends JpaRepository<SpecificBook, Long> {

}
