package com.infostudio.ba.web.rest;

import org.apache.commons.lang.RandomStringUtils;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmInjuryTypes;

import com.infostudio.ba.repository.EmInjuryTypesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmInjuryTypesDTO;
import com.infostudio.ba.service.mapper.EmInjuryTypesMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EmInjuryTypes.
 */
@RestController
@RequestMapping("/api")
public class EmInjuryTypesResource {

    private final Logger log = LoggerFactory.getLogger(EmInjuryTypesResource.class);

    private static final String ENTITY_NAME = "emInjuryTypes";

    private final EmInjuryTypesRepository emInjuryTypesRepository;

    private final EmInjuryTypesMapper emInjuryTypesMapper;

    public EmInjuryTypesResource(EmInjuryTypesRepository emInjuryTypesRepository, EmInjuryTypesMapper emInjuryTypesMapper) {
        this.emInjuryTypesRepository = emInjuryTypesRepository;
        this.emInjuryTypesMapper = emInjuryTypesMapper;
    }

    /**
     * POST  /em-injury-types : Create a new emInjuryTypes.
     *
     * @param emInjuryTypesDTO the emInjuryTypesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emInjuryTypesDTO, or with status 400 (Bad Request) if the emInjuryTypes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-injury-types")
    @Timed
    public ResponseEntity<EmInjuryTypesDTO> createEmInjuryTypes(@Valid @RequestBody EmInjuryTypesDTO emInjuryTypesDTO) throws URISyntaxException {
        log.debug("REST request to save EmInjuryTypes : {}", emInjuryTypesDTO);
        if (emInjuryTypesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emInjuryTypes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        String newCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        while(emInjuryTypesRepository.findByCode(newCode) != null){
            newCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        }
        emInjuryTypesDTO.setCode(newCode);
        EmInjuryTypes emInjuryTypes = emInjuryTypesMapper.toEntity(emInjuryTypesDTO);
        emInjuryTypes = emInjuryTypesRepository.save(emInjuryTypes);
        EmInjuryTypesDTO result = emInjuryTypesMapper.toDto(emInjuryTypes);
        return ResponseEntity.created(new URI("/api/em-injury-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-injury-types : Updates an existing emInjuryTypes.
     *
     * @param emInjuryTypesDTO the emInjuryTypesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emInjuryTypesDTO,
     * or with status 400 (Bad Request) if the emInjuryTypesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emInjuryTypesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-injury-types")
    @Timed
    public ResponseEntity<EmInjuryTypesDTO> updateEmInjuryTypes(@Valid @RequestBody EmInjuryTypesDTO emInjuryTypesDTO) throws URISyntaxException {
        log.debug("REST request to update EmInjuryTypes : {}", emInjuryTypesDTO);
        if (emInjuryTypesDTO.getId() == null) {
            return createEmInjuryTypes(emInjuryTypesDTO);
        }
        EmInjuryTypes emInjuryTypes = emInjuryTypesMapper.toEntity(emInjuryTypesDTO);
        emInjuryTypes = emInjuryTypesRepository.save(emInjuryTypes);
        EmInjuryTypesDTO result = emInjuryTypesMapper.toDto(emInjuryTypes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emInjuryTypesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-injury-types : get all the emInjuryTypes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emInjuryTypes in body
     */
    @GetMapping("/em-injury-types")
    @Timed
    public ResponseEntity<List<EmInjuryTypesDTO>> getAllEmInjuryTypes(Pageable pageable) {
        log.debug("REST request to get a page of EmInjuryTypes");
        Page<EmInjuryTypes> page = emInjuryTypesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-injury-types");
        return new ResponseEntity<>(emInjuryTypesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-injury-types/:id : get the "id" emInjuryTypes.
     *
     * @param id the id of the emInjuryTypesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emInjuryTypesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-injury-types/{id}")
    @Timed
    public ResponseEntity<EmInjuryTypesDTO> getEmInjuryTypes(@PathVariable Long id) {
        log.debug("REST request to get EmInjuryTypes : {}", id);
        EmInjuryTypes emInjuryTypes = emInjuryTypesRepository.findOne(id);
        EmInjuryTypesDTO emInjuryTypesDTO = emInjuryTypesMapper.toDto(emInjuryTypes);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emInjuryTypesDTO));
    }

    /**
     * DELETE  /em-injury-types/:id : delete the "id" emInjuryTypes.
     *
     * @param id the id of the emInjuryTypesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-injury-types/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmInjuryTypes(@PathVariable Long id) {
        log.debug("REST request to delete EmInjuryTypes : {}", id);
        emInjuryTypesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
