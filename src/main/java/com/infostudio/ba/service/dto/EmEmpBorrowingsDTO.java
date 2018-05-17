package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the EmEmpBorrowings entity.
 */
public class EmEmpBorrowingsDTO implements Serializable {

    private Long id;

    @NotNull
    private String title;

    private String description;

    private String serialNumber;

    @NotNull
    private LocalDate dateFrom;

    private String chargedBy;

    private LocalDate dateTo;

    private String dischargedBy;

    private String damage;

    private String damagedByEmployee;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private Long idEmployeeId;

    private Long idBorrowingId;

    private String idBorrowingName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getChargedBy() {
        return chargedBy;
    }

    public void setChargedBy(String chargedBy) {
        this.chargedBy = chargedBy;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getDischargedBy() {
        return dischargedBy;
    }

    public void setDischargedBy(String dischargedBy) {
        this.dischargedBy = dischargedBy;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getDamagedByEmployee() {
        return damagedByEmployee;
    }

    public void setDamagedByEmployee(String damagedByEmployee) {
        this.damagedByEmployee = damagedByEmployee;
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

    public Long getIdEmployeeId() {
        return idEmployeeId;
    }

    public void setIdEmployeeId(Long emEmployeesId) {
        this.idEmployeeId = emEmployeesId;
    }

    public Long getIdBorrowingId() {
        return idBorrowingId;
    }

    public void setIdBorrowingId(Long emBorrowingTypesId) {
        this.idBorrowingId = emBorrowingTypesId;
    }

    public String getIdBorrowingName() {
        return idBorrowingName;
    }

    public void setIdBorrowingName(String emBorrowingTypesName) {
        this.idBorrowingName = emBorrowingTypesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpBorrowingsDTO emEmpBorrowingsDTO = (EmEmpBorrowingsDTO) o;
        if(emEmpBorrowingsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpBorrowingsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpBorrowingsDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", serialNumber='" + getSerialNumber() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", chargedBy='" + getChargedBy() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", dischargedBy='" + getDischargedBy() + "'" +
            ", damage='" + getDamage() + "'" +
            ", damagedByEmployee='" + getDamagedByEmployee() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
