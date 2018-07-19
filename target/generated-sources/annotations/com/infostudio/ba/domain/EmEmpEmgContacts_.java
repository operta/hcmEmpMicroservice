package com.infostudio.ba.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpEmgContacts.class)
public abstract class EmEmpEmgContacts_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpEmgContacts, String> firstName;
	public static volatile SingularAttribute<EmEmpEmgContacts, String> lastName;
	public static volatile SingularAttribute<EmEmpEmgContacts, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpEmgContacts, String> phoneNumber;
	public static volatile SingularAttribute<EmEmpEmgContacts, Integer> idContactType;
	public static volatile SingularAttribute<EmEmpEmgContacts, Long> id;
	public static volatile SingularAttribute<EmEmpEmgContacts, String> email;

}

