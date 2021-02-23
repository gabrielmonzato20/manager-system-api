package com.coursedash.client.repository;

import com.coursedash.client.model.Lancament;
import com.coursedash.client.repository.lacament.LancamentRepositoryQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentRepository extends JpaRepository<Lancament,Long>,LancamentRepositoryQuery{
    
}
