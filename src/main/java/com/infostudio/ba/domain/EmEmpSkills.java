package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpSkills.
 */
@Entity
@Table(name = "em_emp_skills")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpSkills implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date_skill")
    private LocalDate dateSkill;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "id_skill")
    private Integer idSkill;

    @Column(name = "id_grade")
    private Integer idGrade;

    @OneToOne
    @JoinColumn(unique = true)
    private EmEmployees idEmployee;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public EmEmpSkills description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateSkill() {
        return dateSkill;
    }

    public EmEmpSkills dateSkill(LocalDate dateSkill) {
        this.dateSkill = dateSkill;
        return this;
    }

    public void setDateSkill(LocalDate dateSkill) {
        this.dateSkill = dateSkill;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public EmEmpSkills createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public EmEmpSkills createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public EmEmpSkills updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public EmEmpSkills updatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getIdSkill() {
        return idSkill;
    }

    public EmEmpSkills idSkill(Integer idSkill) {
        this.idSkill = idSkill;
        return this;
    }

    public void setIdSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public EmEmpSkills idGrade(Integer idGrade) {
        this.idGrade = idGrade;
        return this;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public EmEmpSkills idEmployee(EmEmployees emEmployees) {
        this.idEmployee = emEmployees;
        return this;
    }

    public void setIdEmployee(EmEmployees emEmployees) {
        this.idEmployee = emEmployees;
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
        EmEmpSkills emEmpSkills = (EmEmpSkills) o;
        if (emEmpSkills.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpSkills.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpSkills{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", dateSkill='" + getDateSkill() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", idSkill=" + getIdSkill() +
            ", idGrade=" + getIdGrade() +
            "}";
    }
}
