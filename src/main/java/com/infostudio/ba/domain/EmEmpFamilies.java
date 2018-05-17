package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A EmEmpFamilies.
 */
@Entity
@Table(name = "eef")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpFamilies extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "maiden_name")
    private String maidenName;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "id_family")
    private Integer idFamily;

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

    public String getName() {
        return name;
    }

    public EmEmpFamilies name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public EmEmpFamilies middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public EmEmpFamilies surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public EmEmpFamilies maidenName(String maidenName) {
        this.maidenName = maidenName;
        return this;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public EmEmpFamilies identificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getIdFamily() {
        return idFamily;
    }

    public EmEmpFamilies idFamily(Integer idFamily) {
        this.idFamily = idFamily;
        return this;
    }

    public void setIdFamily(Integer idFamily) {
        this.idFamily = idFamily;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public EmEmpFamilies idEmployee(EmEmployees emEmployees) {
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
        EmEmpFamilies emEmpFamilies = (EmEmpFamilies) o;
        if (emEmpFamilies.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpFamilies.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpFamilies{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", middleName='" + getMiddleName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", maidenName='" + getMaidenName() + "'" +
            ", identificationNumber='" + getIdentificationNumber() + "'" +
            ", idFamily=" + getIdFamily() +
            "}";
    }
}
