package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpResidences;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the EmEmpResidences entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpResidencesRepository extends JpaRepository<EmEmpResidences, Long> {
    List<EmEmpResidences> findByIdEmployeeId(Long id);
}
