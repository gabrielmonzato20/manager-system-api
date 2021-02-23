package com.coursedash.client.repository.lacament;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coursedash.client.model.Lancament;
import com.coursedash.client.model.Lancament_;
import com.coursedash.client.repository.filter.LacamentFilter;

import org.hibernate.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public class LancamentRepositoryImpl implements LancamentRepositoryQuery {

    @PersistenceContext
    private  EntityManager manager ; 


    @Override
    public Page<Lancament> filter(LacamentFilter lacamentFilter,Pageable pageable) {
        // TODO Auto-generated method stub
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancament> creatira = builder.createQuery(Lancament.class);
        Root<Lancament> root = creatira.from(Lancament.class);

        Predicate[] predicates  = RestrictionCreate(lacamentFilter,builder,root);
        creatira.where(predicates);
        

        TypedQuery<Lancament> query = manager.createQuery(creatira);

        addRestrictionQuery(query,pageable);
        
        return new PageImpl<>(query.getResultList(),pageable,tot(lacamentFilter)); 
    }
private void addRestrictionQuery(TypedQuery<Lancament> query, Pageable pageable){
int curretPage=pageable.getPageNumber();
int registerPerPage=pageable.getPageSize();
int registerPage=curretPage*registerPerPage;
query.setFirstResult(registerPage);
query.setMaxResults(registerPerPage);

}
private Long tot(LacamentFilter lacamentFilter){
CriteriaBuilder builder = manager.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
Root<Lancament> root = criteria.from(Lancament.class);
Predicate[] predicates= RestrictionCreate(lacamentFilter, builder, root);
criteria.where(predicates);
criteria.select(builder.count(root));
return manager.createQuery(criteria).getSingleResult();
}
    private Predicate[] RestrictionCreate(LacamentFilter lacamentFilter,CriteriaBuilder builder,
            Root<Lancament> root) {
                List<Predicate> predicates = new ArrayList<>();
                if(!StringUtils.isEmpty(lacamentFilter.getDescribe())){
                    // where described like % xpto %
                    predicates.add(builder.like(builder.lower(root.get(Lancament_.descricao))
                    ,"%"+ lacamentFilter.getDescribe().toLowerCase() + "%"));
                }
                if(lacamentFilter.getDataVencAt() != null ){
                  predicates.add(builder.greaterThan(root.get(Lancament_.dataVencimento),
                  lacamentFilter.getDataVencAt()));
                }
                if(lacamentFilter.getDataVencFrom() != null ){
                    predicates.add(builder.lessThan(root.get(Lancament_.dataVencimento),
                    lacamentFilter.getDataVencFrom()));
                }
            return predicates.toArray(new Predicate[predicates.size()]);

            }

    
}
