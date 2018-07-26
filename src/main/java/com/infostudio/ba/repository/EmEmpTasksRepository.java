package com.infostudio.ba.repository;

import com.infostudio.ba.domain.EmEmpTasks;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the EmEmpTasks entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmEmpTasksRepository extends JpaRepository<EmEmpTasks, Long> {
    List<EmEmpTasks> findByIdEmployee(Integer employeeId);
}
