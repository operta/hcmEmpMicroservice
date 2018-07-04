package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpBorrowings.class)
public abstract class EmEmpBorrowings_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpBorrowings, String> damage;
	public static volatile SingularAttribute<EmEmpBorrowings, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpBorrowings, String> serialNumber;
	public static volatile SingularAttribute<EmEmpBorrowings, String> damagedByEmployee;
	public static volatile SingularAttribute<EmEmpBorrowings, EmBorrowingTypes> idBorrowing;
	public static volatile SingularAttribute<EmEmpBorrowings, String> chargedBy;
	public static volatile SingularAttribute<EmEmpBorrowings, LocalDate> dateTo;
	public static volatile SingularAttribute<EmEmpBorrowings, String> description;
	public static volatile SingularAttribute<EmEmpBorrowings, String> dischargedBy;
	public static volatile SingularAttribute<EmEmpBorrowings, Long> id;
	public static volatile SingularAttribute<EmEmpBorrowings, String> title;
	public static volatile SingularAttribute<EmEmpBorrowings, LocalDate> dateFrom;

}

