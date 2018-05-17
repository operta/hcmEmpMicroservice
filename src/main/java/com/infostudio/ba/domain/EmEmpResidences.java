package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpResidences.
 */
@Entity
@Table(name = "em_emp_residences")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpResidences extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "dato_to")
    private LocalDate datoTo;

    @Column(name = "address_work")
    private String addressWork;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public EmEmpResidences address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public EmEmpResidences dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDatoTo() {
        return datoTo;
    }

    public EmEmpResidences datoTo(LocalDate datoTo) {
        this.datoTo = datoTo;
        return this;
    }

    public void setDatoTo(LocalDate datoTo) {
        this.datoTo = datoTo;
    }

    public String getAddressWork() {
        return addressWork;
    }

    public EmEmpResidences addressWork(String addressWork) {
        this.addressWork = addressWork;
        return this;
    }

    public void setAddressWork(String addressWork) {
        this.addressWork = addressWork;
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
        EmEmpResidences emEmpResidences = (EmEmpResidences) o;
        if (emEmpResidences.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpResidences.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpResidences{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", datoTo='" + getDatoTo() + "'" +
            ", addressWork='" + getAddressWork() + "'" +
            "}";
    }
}
