package com.example.managers;

import java.util.List;

import com.example.Entity.Category;
import com.example.Entity.Product;

public interface ProductManager 
{

	List<Product> getAllProducts();

	Product getProductById(int productId);

	Product addProduct(Product product);

	void deleteProduct(int productId);

	Product updateProduct(int productId, Product updatedProduct);
	
	List<Product> getProductsByPriceRange(double minPrice, double maxPrice);
	
	List<Product> getProductsWithValidDiscount();
	
	List<Product> findByCatID(int id);
	

}
