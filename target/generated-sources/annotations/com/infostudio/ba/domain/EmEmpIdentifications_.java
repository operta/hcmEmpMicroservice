package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpIdentifications.class)
public abstract class EmEmpIdentifications_ {

	public static volatile SingularAttribute<EmEmpIdentifications, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpIdentifications, LocalDate> validThrough;
	public static volatile SingularAttribute<EmEmpIdentifications, Integer> idIdentification;
	public static volatile SingularAttribute<EmEmpIdentifications, String> jurisdiction;
	public static volatile SingularAttribute<EmEmpIdentifications, Integer> idRegion;
	public static volatile SingularAttribute<EmEmpIdentifications, String> identificationNumber;
	public static volatile SingularAttribute<EmEmpIdentifications, Long> id;

}

