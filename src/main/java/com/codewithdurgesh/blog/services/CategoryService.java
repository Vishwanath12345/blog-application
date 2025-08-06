package com.codewithdurgesh.blog.services;

import java.util.List;

import com.codewithdurgesh.blog.payloads.CategoryDto;

public interface CategoryService {

	 // Create a new category
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update an existing category
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // Delete a category by its ID
    void deleteCategory(Integer categoryId);

    // Get a category by its ID
    CategoryDto getCategoryById(Integer categoryId);

    // Get all categories
    List<CategoryDto> getAllCategories();
}
 