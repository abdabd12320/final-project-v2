package com.example.thawaq.Repository;

import com.example.thawaq.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryById(Integer id);
}
