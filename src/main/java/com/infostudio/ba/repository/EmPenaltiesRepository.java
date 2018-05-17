package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmPenalties;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the EmPenalties entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmPenaltiesRepository extends JpaRepository<EmPenalties, Long> {

}
