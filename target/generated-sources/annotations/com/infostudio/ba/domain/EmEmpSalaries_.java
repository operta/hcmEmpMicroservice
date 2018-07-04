package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpSalaries.class)
public abstract class EmEmpSalaries_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpSalaries, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpSalaries, Integer> idWorkPlace;
	public static volatile SingularAttribute<EmEmpSalaries, Integer> salaryAmount;
	public static volatile SingularAttribute<EmEmpSalaries, LocalDate> dateTo;
	public static volatile SingularAttribute<EmEmpSalaries, Long> id;
	public static volatile SingularAttribute<EmEmpSalaries, LocalDate> dateFrom;
	public static volatile SingularAttribute<EmEmpSalaries, EmContractTypes> idContractType;
	public static volatile SingularAttribute<EmEmpSalaries, Integer> salaryCoefficient;
	public static volatile SingularAttribute<EmEmpSalaries, Integer> workHistoryCoefficient;

}

