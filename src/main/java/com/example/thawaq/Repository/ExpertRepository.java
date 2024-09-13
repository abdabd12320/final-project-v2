package com.example.thawaq.Repository;

import com.example.thawaq.Model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
    Expert findExpertById(Integer id);
}
