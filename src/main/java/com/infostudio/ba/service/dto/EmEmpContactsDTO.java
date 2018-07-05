package com.infostudio.ba.service.dto;


import com.infostudio.ba.domain.EmEmployees;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EmEmpContacts entity.
 */
public class EmEmpContactsDTO implements Serializable {

    private Long id;

    private String contact;

    private String description;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private EmEmployees idEmployee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(EmEmployees idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        EmEmpContactsDTO emEmpContactsDTO = (EmEmpContactsDTO) o;
        if(emEmpContactsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpContactsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpContactsDTO{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", idEmployee=" + idEmployee +
                '}';
    }

}
