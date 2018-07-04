package com.infostudio.ba.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmEmpSkills.class)
public abstract class EmEmpSkills_ extends com.infostudio.ba.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<EmEmpSkills, Integer> idSkill;
	public static volatile SingularAttribute<EmEmpSkills, EmEmployees> idEmployee;
	public static volatile SingularAttribute<EmEmpSkills, String> description;
	public static volatile SingularAttribute<EmEmpSkills, Long> id;
	public static volatile SingularAttribute<EmEmpSkills, Integer> idGrade;
	public static volatile SingularAttribute<EmEmpSkills, LocalDate> dateSkill;

}

