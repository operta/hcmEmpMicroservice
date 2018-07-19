package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmployees;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the EmEmployees entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmployeesRepository extends JpaRepository<EmEmployees, Long> {

    EmEmployees findByIdUser(Integer id);

    List<EmEmployees> findAllByNameContains(String name);
    List<EmEmployees> findAllBySurnameContains(String name);
    List<EmEmployees> findAllByHireDateGreaterThanEqual(LocalDate fromDate);
    List<EmEmployees> findAllByHireDateLessThanEqual(LocalDate toDate);
    List<EmEmployees> findAllByIdQualification(Integer idQualification);


}
