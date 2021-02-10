package com.coursedash.client.repository;

import com.coursedash.client.model.Lancament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Lancamentrepository extends JpaRepository<Lancament,Long>{
    
}
