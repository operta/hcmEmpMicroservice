package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpOrgWorkPlaces.class)
public abstract class EmEmpOrgWorkPlaces_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpOrgWorkPlaces, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpOrgWorkPlaces, LocalDate> dateTo;
	public static volatile SingularAttribute<EmEmpOrgWorkPlaces, Integer> idOrgWorkPlace;
	public static volatile SingularAttribute<EmEmpOrgWorkPlaces, Long> id;
	public static volatile SingularAttribute<EmEmpOrgWorkPlaces, LocalDate> dateFrom;
	public static volatile SingularAttribute<EmEmpOrgWorkPlaces, EmContractTypes> idContractType;
	public static volatile SingularAttribute<EmEmpOrgWorkPlaces, Integer> workHistoryCoefficient;

}

