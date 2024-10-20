package com.nimap.e_com.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.e_com.Entity.Category;
import com.nimap.e_com.Entity.Product;
import com.nimap.e_com.Repository.CategoryRepository;
import com.nimap.e_com.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Page<Product> getProductsByCategory(int categoryId, Pageable pageable) {
	    return productRepository.findAllByCategoryId(categoryId, pageable);
	}
	
	public Product createProduct(Product product) {
	    if (product.getCategory() != null && product.getCategory().getCategoryName() != null) {
	        // Fetch the category by name
	        Category category = categoryRepository.findByCategoryName(product.getCategory().getCategoryName());
	        if (category != null) {
	            product.setCategory(category);
	        } else {
	            throw new RuntimeException("Category not found");
	        }
	    } else {
	        throw new RuntimeException("Category must not be null");
	    }
	    
	    return productRepository.save(product);
	}


	
	public void deleteProductById(int id) {
		productRepository.deleteById(id); 
	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
	}
	
public Product updateProduct(Product updatedProduct,int id) {
		Product product = getProductById(id);
		product.setProductName(updatedProduct.getProductName());
		product.setProductDescription(updatedProduct.getProductDescription());
		product.setProductPrice(updatedProduct.getProductPrice());
		if (updatedProduct.getCategory() != null) {
		    product.setCategory(updatedProduct.getCategory());
		}

		return productRepository.save(product);
	}

}
