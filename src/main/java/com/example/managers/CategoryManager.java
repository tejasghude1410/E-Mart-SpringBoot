package com.example.managers;

import java.util.List;

import com.example.Entity.Category;

public interface CategoryManager {

	void deleteCategory(int categoryId);

	Category updateCategory(int categoryId, Category updatedCategory);

	Category addCategory(Category category);

	Category getCategoryById(int categoryId);

	List<Category> getAllCategorys();
	
	List<Category> getCategoriesByCategoryName(String categoryName);

	List<Category> findByParentCatID(int id);

	

}
