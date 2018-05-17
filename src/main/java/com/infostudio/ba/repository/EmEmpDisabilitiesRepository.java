package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpDisabilities;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the EmEmpDisabilities entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpDisabilitiesRepository extends JpaRepository<EmEmpDisabilities, Long> {

}
