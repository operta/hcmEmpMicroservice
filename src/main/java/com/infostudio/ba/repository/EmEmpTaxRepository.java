package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpTax;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the EmEmpTax entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpTaxRepository extends JpaRepository<EmEmpTax, Long> {
    List<EmEmpTax> findByIdEmployee(Integer id);

}
