package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpSchools.
 */
@Entity
@Table(name = "em_emp_schools")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpSchools extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "major")
    private String major;

    @Column(name = "degree")
    private String degree;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "description")
    private String description;


    @Column(name = "id_school")
    private Integer idSchool;

    @Column(name = "id_qualification")
    private Integer idQualification;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private EmEmployees idEmployee;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public EmEmpSchools dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public EmEmpSchools dateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getMajor() {
        return major;
    }

    public EmEmpSchools major(String major) {
        this.major = major;
        return this;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public EmEmpSchools degree(String degree) {
        this.degree = degree;
        return this;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getGrade() {
        return grade;
    }

    public EmEmpSchools grade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public EmEmpSchools description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdSchool() {
        return idSchool;
    }

    public EmEmpSchools idSchool(Integer idQualification) {
        this.idSchool = idQualification;
        return this;
    }

    public void setIdSchool(Integer idQualification) {
        this.idSchool = idQualification;
    }

    public Integer getIdQualification() {
        return idQualification;
    }

    public EmEmpSchools idQualification(Integer idQualification) {
        this.idQualification = idQualification;
        return this;
    }

    public void setIdQualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public EmEmpSchools idEmployee(EmEmployees emEmployees) {
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
        EmEmpSchools emEmpSchools = (EmEmpSchools) o;
        if (emEmpSchools.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpSchools.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpSchools{" +
            "id=" + getId() +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", major='" + getMajor() + "'" +
            ", degree='" + getDegree() + "'" +
            ", grade=" + getGrade() +
            ", description='" + getDescription() + "'" +
            ", idQualification=" + getIdQualification() +
            "}";
    }
}
