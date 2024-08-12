package com.example.Repositories;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Entity.Category;
import com.example.Entity.Product;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	List<Product> findProductsByMrpPriceBetween(double minPrice, double maxPrice);

	
	default List<Product> findProductsWithValidDiscount() {
        List<Product> allProducts = findAll();
        return allProducts.stream()
                .filter(product -> product.getOfferPrice() < product.getMrpPrice())
                .collect(Collectors.toList());
    }
	
	@Query("SELECT p FROM Product p WHERE p.catmasterID = :catId")
    List<Product> findByCatID(@Param("catId") int catId);
	
	
	

}
