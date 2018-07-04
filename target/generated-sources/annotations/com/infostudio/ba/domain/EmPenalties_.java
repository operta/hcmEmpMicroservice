package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmPenalties.class)
public abstract class EmPenalties_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmPenalties, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmPenalties, LocalDate> dateTo;
	public static volatile SingularAttribute<EmPenalties, String> description;
	public static volatile SingularAttribute<EmPenalties, Long> id;
	public static volatile SingularAttribute<EmPenalties, LocalDate> dateFrom;

}

