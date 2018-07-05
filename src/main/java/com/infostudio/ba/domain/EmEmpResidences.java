package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
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

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "address_work")
    private String addressWork;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private EmEmployees idEmployee;

    @JoinColumn(name = "id_country")
    private Integer idCountry;

    @JoinColumn(name = "id_region")
    private Integer idRegion;

    @JoinColumn(name = "id_city")
    private Integer idCity;

    @JoinColumn(name = "id_country_work")
    private Integer idCountryWork;

    @JoinColumn(name = "id_region_work")
    private Integer idRegionWork;

    @JoinColumn(name = "id_city_work")
    private Integer idCityWork;

    public Integer getIdCountryWork() {
        return idCountryWork;
    }

    public void setIdCountryWork(Integer idCountryWork) {
        this.idCountryWork = idCountryWork;
    }

    public Integer getIdRegionWork() {
        return idRegionWork;
    }

    public void setIdRegionWork(Integer idRegionWork) {
        this.idRegionWork = idRegionWork;
    }

    public Integer getIdCityWork() {
        return idCityWork;
    }

    public void setIdCityWork(Integer idCityWork) {
        this.idCityWork = idCityWork;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(EmEmployees idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

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

    public LocalDate getDateTo() {
        return dateTo;
    }

    public EmEmpResidences datoTo(LocalDate datoTo) {
        this.dateTo = datoTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
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
            ", dateTo='" + getDateTo() + "'" +
            ", addressWork='" + getAddressWork() + "'" +
            "}";
    }
}
