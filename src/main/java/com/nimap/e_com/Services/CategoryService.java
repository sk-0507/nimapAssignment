package com.nimap.e_com.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.e_com.Entity.Category;
import com.nimap.e_com.Repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category getCategoryById( int id) {
		return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
	}
	
	public  void deleteByCategoryId( int id) {
	  categoryRepository.deleteById(id);
	}
	
	public Category updateCategory(Category ucategory,int id) {
		Category category = getCategoryById(id);
		category.setCategoryName(ucategory.getCategoryName());
		return categoryRepository.save(category);
	}
	 

	 
}
