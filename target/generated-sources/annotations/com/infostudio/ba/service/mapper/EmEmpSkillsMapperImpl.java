package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpSkills;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpSkillsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-12T15:45:59+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmEmpSkillsMapperImpl implements EmEmpSkillsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpSkills> toEntity(List<EmEmpSkillsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpSkills> list = new ArrayList<EmEmpSkills>( dtoList.size() );
        for ( EmEmpSkillsDTO emEmpSkillsDTO : dtoList ) {
            list.add( toEntity( emEmpSkillsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpSkillsDTO> toDto(List<EmEmpSkills> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpSkillsDTO> list = new ArrayList<EmEmpSkillsDTO>( entityList.size() );
        for ( EmEmpSkills emEmpSkills : entityList ) {
            list.add( toDto( emEmpSkills ) );
        }

        return list;
    }

    @Override
    public EmEmpSkillsDTO toDto(EmEmpSkills emEmpSkills) {
        if ( emEmpSkills == null ) {
            return null;
        }

        EmEmpSkillsDTO emEmpSkillsDTO = new EmEmpSkillsDTO();

        Long id = emEmpSkillsIdEmployeeId( emEmpSkills );
        if ( id != null ) {
            emEmpSkillsDTO.setIdEmployeeId( id );
        }
        emEmpSkillsDTO.setId( emEmpSkills.getId() );
        emEmpSkillsDTO.setDescription( emEmpSkills.getDescription() );
        emEmpSkillsDTO.setDateSkill( emEmpSkills.getDateSkill() );
        emEmpSkillsDTO.setCreatedBy( emEmpSkills.getCreatedBy() );
        emEmpSkillsDTO.setCreatedAt( emEmpSkills.getCreatedAt() );
        emEmpSkillsDTO.setUpdatedBy( emEmpSkills.getUpdatedBy() );
        emEmpSkillsDTO.setUpdatedAt( emEmpSkills.getUpdatedAt() );
        emEmpSkillsDTO.setIdSkill( emEmpSkills.getIdSkill() );
        emEmpSkillsDTO.setIdGrade( emEmpSkills.getIdGrade() );

        return emEmpSkillsDTO;
    }

    @Override
    public EmEmpSkills toEntity(EmEmpSkillsDTO emEmpSkillsDTO) {
        if ( emEmpSkillsDTO == null ) {
            return null;
        }

        EmEmpSkills emEmpSkills = new EmEmpSkills();

        emEmpSkills.setIdEmployee( emEmployeesMapper.fromId( emEmpSkillsDTO.getIdEmployeeId() ) );
        emEmpSkills.setCreatedBy( emEmpSkillsDTO.getCreatedBy() );
        emEmpSkills.setCreatedAt( emEmpSkillsDTO.getCreatedAt() );
        emEmpSkills.setUpdatedBy( emEmpSkillsDTO.getUpdatedBy() );
        emEmpSkills.setUpdatedAt( emEmpSkillsDTO.getUpdatedAt() );
        emEmpSkills.setId( emEmpSkillsDTO.getId() );
        emEmpSkills.setDescription( emEmpSkillsDTO.getDescription() );
        emEmpSkills.setDateSkill( emEmpSkillsDTO.getDateSkill() );
        emEmpSkills.setIdSkill( emEmpSkillsDTO.getIdSkill() );
        emEmpSkills.setIdGrade( emEmpSkillsDTO.getIdGrade() );

        return emEmpSkills;
    }

    private Long emEmpSkillsIdEmployeeId(EmEmpSkills emEmpSkills) {
        if ( emEmpSkills == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpSkills.getIdEmployee();
        if ( idEmployee == null ) {
            return null;
        }
        Long id = idEmployee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
