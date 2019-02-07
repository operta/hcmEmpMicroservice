package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpBenefits;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the EmEmpBenefits entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpBenefitsRepository extends JpaRepository<EmEmpBenefits, Long> {
    List<EmEmpBenefits> findAllByEmEmployeesId(Long employeeId);
}
