package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A EmEmpTasks.
 */
@Entity
@Table(name = "em_emp_tasks")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpTasks extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "id_employee", nullable = false)
    private Integer idEmployee;

    @Column(name = "finished")
    private String finished;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public EmEmpTasks idEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
        return this;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFinished() {
        return finished;
    }

    public EmEmpTasks finished(String finished) {
        this.finished = finished;
        return this;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getName() {
        return name;
    }

    public EmEmpTasks name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public EmEmpTasks description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmEmpTasks emEmpTasks = (EmEmpTasks) o;
        if (emEmpTasks.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpTasks.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpTasks{" +
            "id=" + getId() +
            ", idEmployee=" + getIdEmployee() +
            ", finished='" + getFinished() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
