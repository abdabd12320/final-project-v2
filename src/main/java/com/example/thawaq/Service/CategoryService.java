package com.example.thawaq.Service;


import com.example.thawaq.Api.ApiException;
import com.example.thawaq.Model.Category;
import com.example.thawaq.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        if (categoryRepository.findAll().isEmpty()) {
            throw new ApiException("Database is empty");
        }
            return categoryRepository.findAll();
        
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    public void updateCategory(Category category,Integer id) {
        Category updatedCategory = categoryRepository.findCategoryById(id);
        if (updatedCategory == null) {
            throw new ApiException("Category not found");
        }
        updatedCategory.setName(category.getName());
        updatedCategory.setDescription(category.getDescription());
        categoryRepository.save(updatedCategory);
    }
    public void deleteCategory(Integer id) {
        Category deletedCategory = categoryRepository.findCategoryById(id);
        if (deletedCategory == null) {
            throw new ApiException("Category not found");
        }
        categoryRepository.delete(deletedCategory);
    }


}
