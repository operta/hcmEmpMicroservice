package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpRewards;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.domain.EmRewardTypes;
import com.infostudio.ba.service.dto.EmEmpRewardsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-05T15:00:57+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class EmEmpRewardsMapperImpl implements EmEmpRewardsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;
    @Autowired
    private EmRewardTypesMapper emRewardTypesMapper;

    @Override
    public List<EmEmpRewards> toEntity(List<EmEmpRewardsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpRewards> list = new ArrayList<EmEmpRewards>( dtoList.size() );
        for ( EmEmpRewardsDTO emEmpRewardsDTO : dtoList ) {
            list.add( toEntity( emEmpRewardsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpRewardsDTO> toDto(List<EmEmpRewards> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpRewardsDTO> list = new ArrayList<EmEmpRewardsDTO>( entityList.size() );
        for ( EmEmpRewards emEmpRewards : entityList ) {
            list.add( toDto( emEmpRewards ) );
        }

        return list;
    }

    @Override
    public EmEmpRewardsDTO toDto(EmEmpRewards emEmpRewards) {
        if ( emEmpRewards == null ) {
            return null;
        }

        EmEmpRewardsDTO emEmpRewardsDTO = new EmEmpRewardsDTO();

        Long id = emEmpRewardsIdRewardId( emEmpRewards );
        if ( id != null ) {
            emEmpRewardsDTO.setIdRewardId( id );
        }
        String name = emEmpRewardsIdRewardName( emEmpRewards );
        if ( name != null ) {
            emEmpRewardsDTO.setIdRewardName( name );
        }
        Long id1 = emEmpRewardsIdEmployeeId( emEmpRewards );
        if ( id1 != null ) {
            emEmpRewardsDTO.setIdEmployeeId( id1 );
        }
        emEmpRewardsDTO.setId( emEmpRewards.getId() );
        emEmpRewardsDTO.setDescription( emEmpRewards.getDescription() );
        emEmpRewardsDTO.setDateReward( emEmpRewards.getDateReward() );
        emEmpRewardsDTO.setAmount( emEmpRewards.getAmount() );
        emEmpRewardsDTO.setRewardedBy( emEmpRewards.getRewardedBy() );
        emEmpRewardsDTO.setCreatedBy( emEmpRewards.getCreatedBy() );
        emEmpRewardsDTO.setCreatedAt( emEmpRewards.getCreatedAt() );
        emEmpRewardsDTO.setUpdatedBy( emEmpRewards.getUpdatedBy() );
        emEmpRewardsDTO.setUpdatedAt( emEmpRewards.getUpdatedAt() );

        return emEmpRewardsDTO;
    }

    @Override
    public EmEmpRewards toEntity(EmEmpRewardsDTO emEmpRewardsDTO) {
        if ( emEmpRewardsDTO == null ) {
            return null;
        }

        EmEmpRewards emEmpRewards = new EmEmpRewards();

        emEmpRewards.setIdReward( emRewardTypesMapper.fromId( emEmpRewardsDTO.getIdRewardId() ) );
        emEmpRewards.setIdEmployee( emEmployeesMapper.fromId( emEmpRewardsDTO.getIdEmployeeId() ) );
        emEmpRewards.setCreatedBy( emEmpRewardsDTO.getCreatedBy() );
        emEmpRewards.setCreatedAt( emEmpRewardsDTO.getCreatedAt() );
        emEmpRewards.setUpdatedBy( emEmpRewardsDTO.getUpdatedBy() );
        emEmpRewards.setUpdatedAt( emEmpRewardsDTO.getUpdatedAt() );
        emEmpRewards.setId( emEmpRewardsDTO.getId() );
        emEmpRewards.setDescription( emEmpRewardsDTO.getDescription() );
        emEmpRewards.setDateReward( emEmpRewardsDTO.getDateReward() );
        emEmpRewards.setAmount( emEmpRewardsDTO.getAmount() );
        emEmpRewards.setRewardedBy( emEmpRewardsDTO.getRewardedBy() );

        return emEmpRewards;
    }

    private Long emEmpRewardsIdRewardId(EmEmpRewards emEmpRewards) {
        if ( emEmpRewards == null ) {
            return null;
        }
        EmRewardTypes idReward = emEmpRewards.getIdReward();
        if ( idReward == null ) {
            return null;
        }
        Long id = idReward.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String emEmpRewardsIdRewardName(EmEmpRewards emEmpRewards) {
        if ( emEmpRewards == null ) {
            return null;
        }
        EmRewardTypes idReward = emEmpRewards.getIdReward();
        if ( idReward == null ) {
            return null;
        }
        String name = idReward.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long emEmpRewardsIdEmployeeId(EmEmpRewards emEmpRewards) {
        if ( emEmpRewards == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpRewards.getIdEmployee();
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
