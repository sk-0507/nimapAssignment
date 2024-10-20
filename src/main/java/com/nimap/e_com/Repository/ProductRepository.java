package com.nimap.e_com.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.e_com.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	 Page<Product> findAllByCategoryId(Integer categoryId, Pageable pageable);
}
