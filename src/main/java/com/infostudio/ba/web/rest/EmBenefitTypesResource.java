package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmBenefitTypes;

import com.infostudio.ba.repository.EmBenefitTypesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmBenefitTypesDTO;
import com.infostudio.ba.service.mapper.EmBenefitTypesMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EmBenefitTypes.
 */
@RestController
@RequestMapping("/api")
public class EmBenefitTypesResource {

    private final Logger log = LoggerFactory.getLogger(EmBenefitTypesResource.class);

    private static final String ENTITY_NAME = "emBenefitTypes";

    private final EmBenefitTypesRepository emBenefitTypesRepository;

    private final EmBenefitTypesMapper emBenefitTypesMapper;

    public EmBenefitTypesResource(EmBenefitTypesRepository emBenefitTypesRepository, EmBenefitTypesMapper emBenefitTypesMapper) {
        this.emBenefitTypesRepository = emBenefitTypesRepository;
        this.emBenefitTypesMapper = emBenefitTypesMapper;
    }

    /**
     * POST  /em-benefit-types : Create a new emBenefitTypes.
     *
     * @param emBenefitTypesDTO the emBenefitTypesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emBenefitTypesDTO, or with status 400 (Bad Request) if the emBenefitTypes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-benefit-types")
    @Timed
    public ResponseEntity<EmBenefitTypesDTO> createEmBenefitTypes(@RequestBody EmBenefitTypesDTO emBenefitTypesDTO) throws URISyntaxException {
        log.debug("REST request to save EmBenefitTypes : {}", emBenefitTypesDTO);
        if (emBenefitTypesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emBenefitTypes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        String randomCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        while(emBenefitTypesRepository.findByCode(randomCode) != null) {
            randomCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        }
        emBenefitTypesDTO.setCode(randomCode);
        EmBenefitTypes emBenefitTypes = emBenefitTypesMapper.toEntity(emBenefitTypesDTO);
        emBenefitTypes = emBenefitTypesRepository.save(emBenefitTypes);
        EmBenefitTypesDTO result = emBenefitTypesMapper.toDto(emBenefitTypes);
        return ResponseEntity.created(new URI("/api/em-benefit-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-benefit-types : Updates an existing emBenefitTypes.
     *
     * @param emBenefitTypesDTO the emBenefitTypesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emBenefitTypesDTO,
     * or with status 400 (Bad Request) if the emBenefitTypesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emBenefitTypesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-benefit-types")
    @Timed
    public ResponseEntity<EmBenefitTypesDTO> updateEmBenefitTypes(@RequestBody EmBenefitTypesDTO emBenefitTypesDTO) throws URISyntaxException {
        log.debug("REST request to update EmBenefitTypes : {}", emBenefitTypesDTO);
        if (emBenefitTypesDTO.getId() == null) {
            return createEmBenefitTypes(emBenefitTypesDTO);
        }
        EmBenefitTypes emBenefitTypes = emBenefitTypesMapper.toEntity(emBenefitTypesDTO);
        emBenefitTypes = emBenefitTypesRepository.save(emBenefitTypes);
        EmBenefitTypesDTO result = emBenefitTypesMapper.toDto(emBenefitTypes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emBenefitTypesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-benefit-types : get all the emBenefitTypes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emBenefitTypes in body
     */
    @GetMapping("/em-benefit-types")
    @Timed
    public ResponseEntity<List<EmBenefitTypesDTO>> getAllEmBenefitTypes(Pageable pageable) {
        log.debug("REST request to get a page of EmBenefitTypes");
        Page<EmBenefitTypes> page = emBenefitTypesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-benefit-types");
        return new ResponseEntity<>(emBenefitTypesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-benefit-types/:id : get the "id" emBenefitTypes.
     *
     * @param id the id of the emBenefitTypesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emBenefitTypesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-benefit-types/{id}")
    @Timed
    public ResponseEntity<EmBenefitTypesDTO> getEmBenefitTypes(@PathVariable Long id) {
        log.debug("REST request to get EmBenefitTypes : {}", id);
        EmBenefitTypes emBenefitTypes = emBenefitTypesRepository.findOne(id);
        EmBenefitTypesDTO emBenefitTypesDTO = emBenefitTypesMapper.toDto(emBenefitTypes);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emBenefitTypesDTO));
    }

    /**
     * DELETE  /em-benefit-types/:id : delete the "id" emBenefitTypes.
     *
     * @param id the id of the emBenefitTypesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-benefit-types/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmBenefitTypes(@PathVariable Long id) {
        log.debug("REST request to delete EmBenefitTypes : {}", id);
        emBenefitTypesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
