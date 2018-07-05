package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpPreviousJobs.class)
public abstract class EmEmpPreviousJobs_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpPreviousJobs, String> managerPosition;
	public static volatile SingularAttribute<EmEmpPreviousJobs, Integer> lengthOfServiceYears;
	public static volatile SingularAttribute<EmEmpPreviousJobs, Integer> lengthOfServiceMonths;
	public static volatile SingularAttribute<EmEmpPreviousJobs, String> reasonOfLeaving;
	public static volatile SingularAttribute<EmEmpPreviousJobs, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpPreviousJobs, Integer> lengthOfServiceDays;
	public static volatile SingularAttribute<EmEmpPreviousJobs, LocalDate> dateTo;
	public static volatile SingularAttribute<EmEmpPreviousJobs, String> company;
	public static volatile SingularAttribute<EmEmpPreviousJobs, Long> id;
	public static volatile SingularAttribute<EmEmpPreviousJobs, String> position;
	public static volatile SingularAttribute<EmEmpPreviousJobs, LocalDate> dateFrom;

}

