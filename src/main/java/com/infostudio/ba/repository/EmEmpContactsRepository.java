package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpContacts;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the EmEmpContacts entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpContactsRepository extends JpaRepository<EmEmpContacts, Long> {
    List<EmEmpContacts> findByIdEmployeeId(Long id);
}
