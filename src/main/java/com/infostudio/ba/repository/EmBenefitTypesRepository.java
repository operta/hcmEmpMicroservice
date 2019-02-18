package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmBenefitTypes;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the EmBenefitTypes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmBenefitTypesRepository extends JpaRepository<EmBenefitTypes, Long> {
    EmBenefitTypes findByCode(String code);
}
