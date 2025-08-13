package com.codewithdurgesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.repositories.CategoryRepo;
import com.codewithdurgesh.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.dtoToCategory(categoryDto);
		Category savedCategory = this.categoryRepo.save(category);
		return this.categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		category.setDescription(categoryDto.getDescription());
		category.setTitle(categoryDto.getTitle());
		category.setTitle(categoryDto.getTitle());
		
		Category updatedcategory = this.categoryRepo.save(category);
		CategoryDto categoryToDto = this.categoryToDto(updatedcategory);
		return categoryToDto;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));
		this.categoryRepo.delete(category);
		
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));
		return  this.categoryToDto(category);
		
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> listOfCategories = this.categoryRepo.findAll();
		List<CategoryDto> collect = listOfCategories.stream().map(category -> this.categoryToDto(category)).collect(Collectors.toList());
		return collect;
	}
	
	public Category dtoToCategory(CategoryDto dto) {
		Category category = this.modelMapper.map(dto, Category.class);
		return category;
	}
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}
	
	

}
