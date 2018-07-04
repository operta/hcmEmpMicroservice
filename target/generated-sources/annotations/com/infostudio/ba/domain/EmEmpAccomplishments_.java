package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpAccomplishments.class)
public abstract class EmEmpAccomplishments_ {

	public static volatile SingularAttribute<EmEmpAccomplishments, Integer> idAccomplishmentType;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> occupation;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> licenceNumber;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> link;
	public static volatile SingularAttribute<EmEmpAccomplishments, Integer> rating;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> description;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> association;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> title;
	public static volatile SingularAttribute<EmEmpAccomplishments, LocalDate> dateFrom;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> proficiency;
	public static volatile SingularAttribute<EmEmpAccomplishments, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> ongoing;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> organization;
	public static volatile SingularAttribute<EmEmpAccomplishments, LocalDate> dateTo;
	public static volatile SingularAttribute<EmEmpAccomplishments, String> location;
	public static volatile SingularAttribute<EmEmpAccomplishments, Long> id;

}

