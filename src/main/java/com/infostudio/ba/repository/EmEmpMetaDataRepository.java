package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpMetaData;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the EmEmpMetaData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpMetaDataRepository extends JpaRepository<EmEmpMetaData, Long> {
    List<EmEmpMetaData> findByIdEmployeeId(Long id);
}
