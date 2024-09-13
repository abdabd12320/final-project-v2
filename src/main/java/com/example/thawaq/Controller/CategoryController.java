package com.example.thawaq.Controller;

import com.example.thawaq.Model.Category;
import com.example.thawaq.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getAllCategory() {
        return ResponseEntity.status(200).body(categoryService.getAllCategories());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("category added successfully");
    }

    @PutMapping("/update/{cId}")
    public ResponseEntity updateCategory(@PathVariable Integer cId,@Valid @RequestBody Category category) {
        categoryService.updateCategory(category,cId);
        return ResponseEntity.status(200).body("category updated successfully");
    }

    @DeleteMapping("/delete/{cId}")
    public ResponseEntity deleteCategory(@PathVariable Integer cId) {
        categoryService.deleteCategory(cId);
        return ResponseEntity.status(200).body("category deleted successfully");
    }
}
