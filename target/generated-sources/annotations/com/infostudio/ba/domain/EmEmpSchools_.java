package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpSchools.class)
public abstract class EmEmpSchools_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpSchools, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpSchools, String> major;
	public static volatile SingularAttribute<EmEmpSchools, Integer> grade;
	public static volatile SingularAttribute<EmEmpSchools, LocalDate> dateTo;
	public static volatile SingularAttribute<EmEmpSchools, String> degree;
	public static volatile SingularAttribute<EmEmpSchools, String> description;
	public static volatile SingularAttribute<EmEmpSchools, Long> id;
	public static volatile SingularAttribute<EmEmpSchools, Integer> idQualification;
	public static volatile SingularAttribute<EmEmpSchools, LocalDate> dateFrom;

}

