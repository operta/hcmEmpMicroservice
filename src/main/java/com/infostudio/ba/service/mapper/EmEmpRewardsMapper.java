package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpRewardsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpRewards and its DTO EmEmpRewardsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class, EmRewardTypesMapper.class})
public interface EmEmpRewardsMapper extends EntityMapper<EmEmpRewardsDTO, EmEmpRewards> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    @Mapping(source = "idReward.id", target = "idRewardId")
    @Mapping(source = "idReward.name", target = "idRewardName")
    EmEmpRewardsDTO toDto(EmEmpRewards emEmpRewards);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    @Mapping(source = "idRewardId", target = "idReward")
    EmEmpRewards toEntity(EmEmpRewardsDTO emEmpRewardsDTO);

    default EmEmpRewards fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpRewards emEmpRewards = new EmEmpRewards();
        emEmpRewards.setId(id);
        return emEmpRewards;
    }
}
