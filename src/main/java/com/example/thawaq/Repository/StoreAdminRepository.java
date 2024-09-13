package com.example.thawaq.Repository;

import com.example.thawaq.Model.StoreAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreAdminRepository extends JpaRepository<StoreAdmin, Integer> {
    StoreAdmin findStoreAdminById(Integer id);
}
