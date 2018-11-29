package com.infostudio.ba.service.dto;


import com.infostudio.ba.domain.EmEmployees;

import java.time.Instant;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EmEmpPreviousJobs entity.
 */
public class EmEmpPreviousJobsDTO implements Serializable {

    private Long id;

    private String company;

    private String position;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private String reasonOfLeaving;

    private String managerPosition;

    private Integer lengthOfServiceYears;

    private Integer lengthOfServiceMonths;

    private Integer lengthOfServiceDays;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private String idEmployeeName;

    private Long idEmployeeId;

    public String getIdEmployeeName() {
        return idEmployeeName;
    }

    public void setIdEmployeeName(String idEmployeeName) {
        this.idEmployeeName = idEmployeeName;
    }

    public Long getIdEmployeeId() {
        return idEmployeeId;
    }

    public void setIdEmployeeId(Long idEmployeeId) {
        this.idEmployeeId = idEmployeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getReasonOfLeaving() {
        return reasonOfLeaving;
    }

    public void setReasonOfLeaving(String reasonOfLeaving) {
        this.reasonOfLeaving = reasonOfLeaving;
    }

    public String getManagerPosition() {
        return managerPosition;
    }

    public void setManagerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
    }

    public Integer getLengthOfServiceYears() {
        return lengthOfServiceYears;
    }

    public void setLengthOfServiceYears(Integer lengthOfServiceYears) {
        this.lengthOfServiceYears = lengthOfServiceYears;
    }

    public Integer getLengthOfServiceMonths() {
        return lengthOfServiceMonths;
    }

    public void setLengthOfServiceMonths(Integer lengthOfServiceMonths) {
        this.lengthOfServiceMonths = lengthOfServiceMonths;
    }

    public Integer getLengthOfServiceDays() {
        return lengthOfServiceDays;
    }

    public void setLengthOfServiceDays(Integer lengthOfServiceDays) {
        this.lengthOfServiceDays = lengthOfServiceDays;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpPreviousJobsDTO emEmpPreviousJobsDTO = (EmEmpPreviousJobsDTO) o;
        if(emEmpPreviousJobsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpPreviousJobsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


    @Override
    public String toString() {
        return "EmEmpPreviousJobsDTO{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", reasonOfLeaving='" + reasonOfLeaving + '\'' +
                ", managerPosition='" + managerPosition + '\'' +
                ", lengthOfServiceYears=" + lengthOfServiceYears +
                ", lengthOfServiceMonths=" + lengthOfServiceMonths +
                ", lengthOfServiceDays=" + lengthOfServiceDays +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", idEmployeeName='" + idEmployeeName + '\'' +
                ", idEmployeeId=" + idEmployeeId +
                '}';
    }

}
