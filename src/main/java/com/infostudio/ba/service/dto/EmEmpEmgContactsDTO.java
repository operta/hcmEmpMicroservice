package com.infostudio.ba.service.dto;


import com.infostudio.ba.domain.EmContractTypes;
import com.infostudio.ba.domain.EmEmployees;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EmEmpEmgContacts entity.
 */
public class EmEmpEmgContactsDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private String phoneNumber;

    private String email;

    private EmEmployees idEmployee;

    private Integer idContactType;

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(EmEmployees idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdContactType() {
        return idContactType;
    }

    public void setIdContactType(Integer idContactType) {
        this.idContactType = idContactType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpEmgContactsDTO emEmpEmgContactsDTO = (EmEmpEmgContactsDTO) o;
        if(emEmpEmgContactsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpEmgContactsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpEmgContactsDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", idEmployee=" + idEmployee +
                ", idContactType=" + idContactType +
                '}';
    }
}
