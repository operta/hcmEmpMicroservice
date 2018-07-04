package com.infostudio.ba.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractAuditingEntity.class)
public abstract class AbstractAuditingEntity_ {

	public static volatile SingularAttribute<AbstractAuditingEntity, Instant> createdAt;
	public static volatile SingularAttribute<AbstractAuditingEntity, String> updatedBy;
	public static volatile SingularAttribute<AbstractAuditingEntity, String> createdBy;
	public static volatile SingularAttribute<AbstractAuditingEntity, Instant> updatedAt;

}

