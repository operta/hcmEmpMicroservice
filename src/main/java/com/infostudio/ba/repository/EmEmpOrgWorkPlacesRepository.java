package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpOrgWorkPlaces;
import feign.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the EmEmpOrgWorkPlaces entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpOrgWorkPlacesRepository extends JpaRepository<EmEmpOrgWorkPlaces, Long> {
    List<EmEmpOrgWorkPlaces> findByIdEmployeeId(Long id);

    @Query("SELECT em FROM EmEmpOrgWorkPlaces em WHERE em.dateFrom=(SELECT MAX(e.dateFrom) FROM EmEmpOrgWorkPlaces e WHERE e.idEmployee.id=?1) AND em.idEmployee.id=?1 AND ROWNUM=1")
    EmEmpOrgWorkPlaces findLastOrgWorkPlace(Long employeeId);

    @Query("SELECT em FROM EmEmpOrgWorkPlaces em WHERE em.dateFrom=(SELECT MAX(e.dateFrom) FROM EmEmpOrgWorkPlaces e WHERE e.idEmployee=em.idEmployee)")
    List<EmEmpOrgWorkPlaces> findLastOrgWorkPlaces();

    List<EmEmpOrgWorkPlaces> findAllById(Long id);


    @Query("SELECT em FROM EmEmpOrgWorkPlaces em WHERE em.idEmployee.id=?1 AND (em.dateTo IS NULL OR em.dateTo >= ?2)")
    List<EmEmpOrgWorkPlaces> findEmEmpOrgWorkPlacesForEmployees(Long idEmployee, LocalDate dateTo);
}
