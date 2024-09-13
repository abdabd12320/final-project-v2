package com.example.thawaq.Repository;

import com.example.thawaq.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findMenuById(Integer id);
}
