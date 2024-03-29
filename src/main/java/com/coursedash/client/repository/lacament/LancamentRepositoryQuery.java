package com.coursedash.client.repository.lacament;

import java.util.List;

import com.coursedash.client.model.Lancament;
import com.coursedash.client.repository.filter.LacamentFilter;
import com.coursedash.client.repository.projection.ResumeLancament;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentRepositoryQuery {
    public Page<Lancament> filter(LacamentFilter lacamentFilter,Pageable pageable);
    public Page<ResumeLancament> resume(LacamentFilter lacamentFilter, Pageable pageable);
}