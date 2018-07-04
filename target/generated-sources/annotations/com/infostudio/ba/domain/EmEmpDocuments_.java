package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpDocuments.class)
public abstract class EmEmpDocuments_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpDocuments, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpDocuments, Integer> idDocumentType;
	public static volatile SingularAttribute<EmEmpDocuments, LocalDate> dateCreated;
	public static volatile SingularAttribute<EmEmpDocuments, String> name;
	public static volatile SingularAttribute<EmEmpDocuments, String> description;
	public static volatile SingularAttribute<EmEmpDocuments, Long> id;
	public static volatile SingularAttribute<EmEmpDocuments, LocalDate> validFrom;
	public static volatile SingularAttribute<EmEmpDocuments, Integer> idDocumentLink;
	public static volatile SingularAttribute<EmEmpDocuments, LocalDate> validTo;

}

