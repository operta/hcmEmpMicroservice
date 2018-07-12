package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpPreviousJobs;
import com.infostudio.ba.service.dto.EmEmpPreviousJobsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-12T09:28:36+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmEmpPreviousJobsMapperImpl implements EmEmpPreviousJobsMapper {

    @Override
    public EmEmpPreviousJobs toEntity(EmEmpPreviousJobsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpPreviousJobs emEmpPreviousJobs = new EmEmpPreviousJobs();

        emEmpPreviousJobs.setCreatedBy( dto.getCreatedBy() );
        emEmpPreviousJobs.setCreatedAt( dto.getCreatedAt() );
        emEmpPreviousJobs.setUpdatedBy( dto.getUpdatedBy() );
        emEmpPreviousJobs.setUpdatedAt( dto.getUpdatedAt() );
        emEmpPreviousJobs.setIdEmployee( dto.getIdEmployee() );
        emEmpPreviousJobs.setId( dto.getId() );
        emEmpPreviousJobs.setCompany( dto.getCompany() );
        emEmpPreviousJobs.setPosition( dto.getPosition() );
        emEmpPreviousJobs.setDateFrom( dto.getDateFrom() );
        emEmpPreviousJobs.setDateTo( dto.getDateTo() );
        emEmpPreviousJobs.setReasonOfLeaving( dto.getReasonOfLeaving() );
        emEmpPreviousJobs.setManagerPosition( dto.getManagerPosition() );
        emEmpPreviousJobs.setLengthOfServiceYears( dto.getLengthOfServiceYears() );
        emEmpPreviousJobs.setLengthOfServiceMonths( dto.getLengthOfServiceMonths() );
        emEmpPreviousJobs.setLengthOfServiceDays( dto.getLengthOfServiceDays() );

        return emEmpPreviousJobs;
    }

    @Override
    public EmEmpPreviousJobsDTO toDto(EmEmpPreviousJobs entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpPreviousJobsDTO emEmpPreviousJobsDTO = new EmEmpPreviousJobsDTO();

        emEmpPreviousJobsDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpPreviousJobsDTO.setId( entity.getId() );
        emEmpPreviousJobsDTO.setCompany( entity.getCompany() );
        emEmpPreviousJobsDTO.setPosition( entity.getPosition() );
        emEmpPreviousJobsDTO.setDateFrom( entity.getDateFrom() );
        emEmpPreviousJobsDTO.setDateTo( entity.getDateTo() );
        emEmpPreviousJobsDTO.setReasonOfLeaving( entity.getReasonOfLeaving() );
        emEmpPreviousJobsDTO.setManagerPosition( entity.getManagerPosition() );
        emEmpPreviousJobsDTO.setLengthOfServiceYears( entity.getLengthOfServiceYears() );
        emEmpPreviousJobsDTO.setLengthOfServiceMonths( entity.getLengthOfServiceMonths() );
        emEmpPreviousJobsDTO.setLengthOfServiceDays( entity.getLengthOfServiceDays() );
        emEmpPreviousJobsDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpPreviousJobsDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpPreviousJobsDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpPreviousJobsDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emEmpPreviousJobsDTO;
    }

    @Override
    public List<EmEmpPreviousJobs> toEntity(List<EmEmpPreviousJobsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpPreviousJobs> list = new ArrayList<EmEmpPreviousJobs>( dtoList.size() );
        for ( EmEmpPreviousJobsDTO emEmpPreviousJobsDTO : dtoList ) {
            list.add( toEntity( emEmpPreviousJobsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpPreviousJobsDTO> toDto(List<EmEmpPreviousJobs> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpPreviousJobsDTO> list = new ArrayList<EmEmpPreviousJobsDTO>( entityList.size() );
        for ( EmEmpPreviousJobs emEmpPreviousJobs : entityList ) {
            list.add( toDto( emEmpPreviousJobs ) );
        }

        return list;
    }
}
