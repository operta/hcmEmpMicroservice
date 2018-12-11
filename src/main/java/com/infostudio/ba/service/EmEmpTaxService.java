package com.infostudio.ba.service;

import com.infostudio.ba.domain.EmEmpTax;
import com.infostudio.ba.repository.EmEmpTaxRepository;
import com.infostudio.ba.service.dto.EmEmpTaxDTO;
import com.infostudio.ba.service.mapper.EmEmpTaxMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing EmEmpTax.
 */
@Service
@Transactional
public class EmEmpTaxService {

    private final Logger log = LoggerFactory.getLogger(EmEmpTaxService.class);

    private final EmEmpTaxRepository emEmpTaxRepository;

    private final EmEmpTaxMapper emEmpTaxMapper;

    public EmEmpTaxService(EmEmpTaxRepository emEmpTaxRepository, EmEmpTaxMapper emEmpTaxMapper) {
        this.emEmpTaxRepository = emEmpTaxRepository;
        this.emEmpTaxMapper = emEmpTaxMapper;
    }

    /**
     * Save a emEmpTax.
     *
     * @param emEmpTaxDTO the entity to save
     * @return the persisted entity
     */
    public EmEmpTaxDTO save(EmEmpTaxDTO emEmpTaxDTO) {
        log.debug("Request to save EmEmpTax : {}", emEmpTaxDTO);
        EmEmpTax emEmpTax = emEmpTaxMapper.toEntity(emEmpTaxDTO);
        emEmpTax = emEmpTaxRepository.save(emEmpTax);
        return emEmpTaxMapper.toDto(emEmpTax);
    }

    /**
     * Get all the emEmpTaxes.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<EmEmpTaxDTO> findAll() {
        log.debug("Request to get all EmEmpTaxes");
        return emEmpTaxRepository.findAll().stream()
            .map(emEmpTaxMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

        /**
     * Get all the emEmpTaxes by employee id.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<EmEmpTaxDTO> findByEmployee(Integer id) {
        log.debug("Request to get all EmEmpTaxes by employee id {}", id);
        return emEmpTaxRepository.findByIdEmployee(id).stream()
            .map(emEmpTaxMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one emEmpTax by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public EmEmpTaxDTO findOne(Long id) {
        log.debug("Request to get EmEmpTax : {}", id);
        EmEmpTax emEmpTax = emEmpTaxRepository.findOne(id);
        return emEmpTaxMapper.toDto(emEmpTax);
    }

    /**
     * Delete the emEmpTax by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete EmEmpTax : {}", id);
        emEmpTaxRepository.delete(id);
    }
}
