package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpBenefits;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import javax.mail.search.SearchTerm;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


/**
 * Spring Data JPA repository for the EmEmpBenefits entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpBenefitsRepository extends JpaRepository<EmEmpBenefits, Long> {
    Set<EmEmpBenefits> findAllByEmEmployeesId(Long employeeId);
    Set<EmEmpBenefits> findAllByEmBenefitTypesId(Long benefitTypeId);
    Set<EmEmpBenefits> findAllByDateToLessThanEqual(LocalDate dateTo);
    Set<EmEmpBenefits> findAllByDateFromGreaterThanEqual(LocalDate dateTo);
}
