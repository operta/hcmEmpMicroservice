package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpCitizenships;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the EmEmpCitizenships entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpCitizenshipsRepository extends JpaRepository<EmEmpCitizenships, Long> {

}
