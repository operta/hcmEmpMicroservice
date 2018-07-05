package com.infostudio.ba.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpContacts.class)
public abstract class EmEmpContacts_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpContacts, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpContacts, EmContractTypes> idContactType;
	public static volatile SingularAttribute<EmEmpContacts, String> contact;
	public static volatile SingularAttribute<EmEmpContacts, String> description;
	public static volatile SingularAttribute<EmEmpContacts, Long> id;

}

