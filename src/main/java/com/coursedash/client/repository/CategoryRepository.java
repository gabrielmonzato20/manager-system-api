package com.coursedash.client.repository;

import com.coursedash.client.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
