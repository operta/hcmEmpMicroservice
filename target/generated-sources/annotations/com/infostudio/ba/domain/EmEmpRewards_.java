package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpRewards.class)
public abstract class EmEmpRewards_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpRewards, String> rewardedBy;
	public static volatile SingularAttribute<EmEmpRewards, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpRewards, Integer> amount;
	public static volatile SingularAttribute<EmEmpRewards, EmRewardTypes> idReward;
	public static volatile SingularAttribute<EmEmpRewards, String> description;
	public static volatile SingularAttribute<EmEmpRewards, Long> id;
	public static volatile SingularAttribute<EmEmpRewards, LocalDate> dateReward;

}

