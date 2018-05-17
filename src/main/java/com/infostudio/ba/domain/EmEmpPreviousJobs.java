package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpPreviousJobs.
 */
@Entity
@Table(name = "em_emp_previous_jobs")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpPreviousJobs extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "reason_of_leaving")
    private String reasonOfLeaving;

    @Column(name = "manager_position")
    private String managerPosition;

    @Column(name = "length_of_service_years")
    private Integer lengthOfServiceYears;

    @Column(name = "length_of_service_months")
    private Integer lengthOfServiceMonths;

    @Column(name = "length_of_service_days")
    private Integer lengthOfServiceDays;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public EmEmpPreviousJobs company(String company) {
        this.company = company;
        return this;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public EmEmpPreviousJobs position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public EmEmpPreviousJobs dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public EmEmpPreviousJobs dateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getReasonOfLeaving() {
        return reasonOfLeaving;
    }

    public EmEmpPreviousJobs reasonOfLeaving(String reasonOfLeaving) {
        this.reasonOfLeaving = reasonOfLeaving;
        return this;
    }

    public void setReasonOfLeaving(String reasonOfLeaving) {
        this.reasonOfLeaving = reasonOfLeaving;
    }

    public String getManagerPosition() {
        return managerPosition;
    }

    public EmEmpPreviousJobs managerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
        return this;
    }

    public void setManagerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
    }

    public Integer getLengthOfServiceYears() {
        return lengthOfServiceYears;
    }

    public EmEmpPreviousJobs lengthOfServiceYears(Integer lengthOfServiceYears) {
        this.lengthOfServiceYears = lengthOfServiceYears;
        return this;
    }

    public void setLengthOfServiceYears(Integer lengthOfServiceYears) {
        this.lengthOfServiceYears = lengthOfServiceYears;
    }

    public Integer getLengthOfServiceMonths() {
        return lengthOfServiceMonths;
    }

    public EmEmpPreviousJobs lengthOfServiceMonths(Integer lengthOfServiceMonths) {
        this.lengthOfServiceMonths = lengthOfServiceMonths;
        return this;
    }

    public void setLengthOfServiceMonths(Integer lengthOfServiceMonths) {
        this.lengthOfServiceMonths = lengthOfServiceMonths;
    }

    public Integer getLengthOfServiceDays() {
        return lengthOfServiceDays;
    }

    public EmEmpPreviousJobs lengthOfServiceDays(Integer lengthOfServiceDays) {
        this.lengthOfServiceDays = lengthOfServiceDays;
        return this;
    }

    public void setLengthOfServiceDays(Integer lengthOfServiceDays) {
        this.lengthOfServiceDays = lengthOfServiceDays;
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
        EmEmpPreviousJobs emEmpPreviousJobs = (EmEmpPreviousJobs) o;
        if (emEmpPreviousJobs.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpPreviousJobs.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpPreviousJobs{" +
            "id=" + getId() +
            ", company='" + getCompany() + "'" +
            ", position='" + getPosition() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", reasonOfLeaving='" + getReasonOfLeaving() + "'" +
            ", managerPosition='" + getManagerPosition() + "'" +
            ", lengthOfServiceYears=" + getLengthOfServiceYears() +
            ", lengthOfServiceMonths=" + getLengthOfServiceMonths() +
            ", lengthOfServiceDays=" + getLengthOfServiceDays() +
            "}";
    }
}
