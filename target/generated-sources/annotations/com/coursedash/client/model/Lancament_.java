package com.coursedash.client.model;

import com.coursedash.client.enumerate.TypeLancament;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lancament.class)
public abstract class Lancament_ {

	public static volatile SingularAttribute<Lancament, Long> codigo;
	public static volatile SingularAttribute<Lancament, String> observacao;
	public static volatile SingularAttribute<Lancament, LocalDate> dataPagamento;
	public static volatile SingularAttribute<Lancament, TypeLancament> typeLancament;
	public static volatile SingularAttribute<Lancament, Person> pessoa;
	public static volatile SingularAttribute<Lancament, LocalDate> dataVencimento;
	public static volatile SingularAttribute<Lancament, Category> categoria;
	public static volatile SingularAttribute<Lancament, BigDecimal> valor;
	public static volatile SingularAttribute<Lancament, String> descricao;

}

