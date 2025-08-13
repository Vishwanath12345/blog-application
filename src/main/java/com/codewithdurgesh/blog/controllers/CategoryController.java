package com.codewithdurgesh.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.services.CategoryService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto >createCategory(@Valid @RequestBody CategoryDto categorydto) {
		CategoryDto category = categoryService.createCategory(categorydto);
		return new ResponseEntity<>(category , HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable Integer id, @RequestBody  CategoryDto categoryDto) {
		CategoryDto updateCategory = categoryService.updateCategory(categoryDto, id);
		return new ResponseEntity<>(updateCategory , HttpStatus.OK);
	}
	
	@GetMapping("/")
	public  List<CategoryDto > getAllCategory() {
		List<CategoryDto> allCategories = categoryService.getAllCategories();
		return allCategories;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id) {
	    categoryService.deleteCategory(id);
	    return ResponseEntity.ok(new ApiResponse("Category deleted successfully", true));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) {
	    CategoryDto categoryDto = categoryService.getCategoryById(id);
	    return ResponseEntity.ok(categoryDto);
	}
	

}
