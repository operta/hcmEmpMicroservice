package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpResidences.class)
public abstract class EmEmpResidences_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpResidences, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpResidences, Integer> idRegionWork;
	public static volatile SingularAttribute<EmEmpResidences, String> address;
	public static volatile SingularAttribute<EmEmpResidences, Integer> idCountryWork;
	public static volatile SingularAttribute<EmEmpResidences, LocalDate> dateTo;
	public static volatile SingularAttribute<EmEmpResidences, Integer> idRegion;
	public static volatile SingularAttribute<EmEmpResidences, Integer> idCity;
	public static volatile SingularAttribute<EmEmpResidences, Long> id;
	public static volatile SingularAttribute<EmEmpResidences, Integer> idCityWork;
	public static volatile SingularAttribute<EmEmpResidences, LocalDate> dateFrom;
	public static volatile SingularAttribute<EmEmpResidences, String> addressWork;
	public static volatile SingularAttribute<EmEmpResidences, Integer> idCountry;

}

