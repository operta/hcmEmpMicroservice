package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmBorrowingTypes;
import com.infostudio.ba.service.dto.EmBorrowingTypesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-26T11:29:22+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.200.v20180612-0641, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class EmBorrowingTypesMapperImpl implements EmBorrowingTypesMapper {

    @Override
    public EmBorrowingTypes toEntity(EmBorrowingTypesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmBorrowingTypes emBorrowingTypes = new EmBorrowingTypes();

        emBorrowingTypes.setCreatedBy( dto.getCreatedBy() );
        emBorrowingTypes.setCreatedAt( dto.getCreatedAt() );
        emBorrowingTypes.setUpdatedBy( dto.getUpdatedBy() );
        emBorrowingTypes.setUpdatedAt( dto.getUpdatedAt() );
        emBorrowingTypes.setId( dto.getId() );
        emBorrowingTypes.setCode( dto.getCode() );
        emBorrowingTypes.setName( dto.getName() );
        emBorrowingTypes.setDescription( dto.getDescription() );

        return emBorrowingTypes;
    }

    @Override
    public EmBorrowingTypesDTO toDto(EmBorrowingTypes entity) {
        if ( entity == null ) {
            return null;
        }

        EmBorrowingTypesDTO emBorrowingTypesDTO = new EmBorrowingTypesDTO();

        emBorrowingTypesDTO.setId( entity.getId() );
        emBorrowingTypesDTO.setCode( entity.getCode() );
        emBorrowingTypesDTO.setName( entity.getName() );
        emBorrowingTypesDTO.setDescription( entity.getDescription() );
        emBorrowingTypesDTO.setCreatedBy( entity.getCreatedBy() );
        emBorrowingTypesDTO.setCreatedAt( entity.getCreatedAt() );
        emBorrowingTypesDTO.setUpdatedBy( entity.getUpdatedBy() );
        emBorrowingTypesDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emBorrowingTypesDTO;
    }

    @Override
    public List<EmBorrowingTypes> toEntity(List<EmBorrowingTypesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmBorrowingTypes> list = new ArrayList<EmBorrowingTypes>( dtoList.size() );
        for ( EmBorrowingTypesDTO emBorrowingTypesDTO : dtoList ) {
            list.add( toEntity( emBorrowingTypesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmBorrowingTypesDTO> toDto(List<EmBorrowingTypes> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmBorrowingTypesDTO> list = new ArrayList<EmBorrowingTypesDTO>( entityList.size() );
        for ( EmBorrowingTypes emBorrowingTypes : entityList ) {
            list.add( toDto( emBorrowingTypes ) );
        }

        return list;
    }
}
