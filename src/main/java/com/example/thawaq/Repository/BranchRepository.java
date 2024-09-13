package com.example.thawaq.Repository;

import com.example.thawaq.Model.Branch;
import com.example.thawaq.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

    Branch findBranchById(Integer id);
}
