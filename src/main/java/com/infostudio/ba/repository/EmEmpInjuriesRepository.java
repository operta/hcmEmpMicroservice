package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpInjuries;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the EmEmpInjuries entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpInjuriesRepository extends JpaRepository<EmEmpInjuries, Long> {

}
