package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmployees.class)
public abstract class EmEmployees_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmployees, String> code;
	public static volatile SingularAttribute<EmEmployees, String> gender;
	public static volatile SingularAttribute<EmEmployees, String> imagePath;
	public static volatile SingularAttribute<EmEmployees, String> maidenName;
	public static volatile SingularAttribute<EmEmployees, Integer> idQualification;
	public static volatile SingularAttribute<EmEmployees, String> ssn;
	public static volatile SingularAttribute<EmEmployees, Integer> idUser;
	public static volatile SingularAttribute<EmEmployees, EmStatuses> idStatus;
	public static volatile SingularAttribute<EmEmployees, String> bloodGroup;
	public static volatile SingularAttribute<EmEmployees, String> residentialSituation;
	public static volatile SingularAttribute<EmEmployees, String> surname;
	public static volatile SingularAttribute<EmEmployees, Long> id;
	public static volatile SingularAttribute<EmEmployees, String> email;
	public static volatile SingularAttribute<EmEmployees, Integer> idLegalEntity;
	public static volatile SingularAttribute<EmEmployees, LocalDate> hireDate;
	public static volatile SingularAttribute<EmEmployees, String> taxNumber;
	public static volatile SingularAttribute<EmEmployees, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<EmEmployees, String> personalPhoneNumber;
	public static volatile SingularAttribute<EmEmployees, String> phoneNumber;
	public static volatile SingularAttribute<EmEmployees, EmEmpTypes> idEmploymentType;
	public static volatile SingularAttribute<EmEmployees, Integer> disabilityDegree;
	public static volatile SingularAttribute<EmEmployees, String> name;
	public static volatile SingularAttribute<EmEmployees, String> middleName;
	public static volatile SingularAttribute<EmEmployees, String> ethnicGroup;
	public static volatile SingularAttribute<EmEmployees, String> maritalStatus;

}

