package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpBenefits;

import com.infostudio.ba.repository.EmEmpBenefitsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpBenefitsDTO;
import com.infostudio.ba.service.mapper.EmEmpBenefitsMapper;
import io.github.jhipster.web.util.ResponseUtil;
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
 * REST controller for managing EmEmpBenefits.
 */
@RestController
@RequestMapping("/api")
public class EmEmpBenefitsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpBenefitsResource.class);

    private static final String ENTITY_NAME = "emEmpBenefits";

    private final EmEmpBenefitsRepository emEmpBenefitsRepository;

    private final EmEmpBenefitsMapper emEmpBenefitsMapper;

    public EmEmpBenefitsResource(EmEmpBenefitsRepository emEmpBenefitsRepository, EmEmpBenefitsMapper emEmpBenefitsMapper) {
        this.emEmpBenefitsRepository = emEmpBenefitsRepository;
        this.emEmpBenefitsMapper = emEmpBenefitsMapper;
    }

    /**
     * POST  /em-emp-benefits : Create a new emEmpBenefits.
     *
     * @param emEmpBenefitsDTO the emEmpBenefitsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpBenefitsDTO, or with status 400 (Bad Request) if the emEmpBenefits has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-benefits")
    @Timed
    public ResponseEntity<EmEmpBenefitsDTO> createEmEmpBenefits(@RequestBody EmEmpBenefitsDTO emEmpBenefitsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpBenefits : {}", emEmpBenefitsDTO);
        if (emEmpBenefitsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpBenefits cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpBenefits emEmpBenefits = emEmpBenefitsMapper.toEntity(emEmpBenefitsDTO);
        emEmpBenefits = emEmpBenefitsRepository.save(emEmpBenefits);
        EmEmpBenefitsDTO result = emEmpBenefitsMapper.toDto(emEmpBenefits);
        return ResponseEntity.created(new URI("/api/em-emp-benefits/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-benefits : Updates an existing emEmpBenefits.
     *
     * @param emEmpBenefitsDTO the emEmpBenefitsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpBenefitsDTO,
     * or with status 400 (Bad Request) if the emEmpBenefitsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpBenefitsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-benefits")
    @Timed
    public ResponseEntity<EmEmpBenefitsDTO> updateEmEmpBenefits(@RequestBody EmEmpBenefitsDTO emEmpBenefitsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpBenefits : {}", emEmpBenefitsDTO);
        if (emEmpBenefitsDTO.getId() == null) {
            return createEmEmpBenefits(emEmpBenefitsDTO);
        }
        EmEmpBenefits emEmpBenefits = emEmpBenefitsMapper.toEntity(emEmpBenefitsDTO);
        emEmpBenefits = emEmpBenefitsRepository.save(emEmpBenefits);
        EmEmpBenefitsDTO result = emEmpBenefitsMapper.toDto(emEmpBenefits);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpBenefitsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-benefits : get all the emEmpBenefits.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpBenefits in body
     */
    @GetMapping("/em-emp-benefits")
    @Timed
    public ResponseEntity<List<EmEmpBenefitsDTO>> getAllEmEmpBenefits(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpBenefits");
        Page<EmEmpBenefits> page = emEmpBenefitsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-benefits");
        return new ResponseEntity<>(emEmpBenefitsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-benefits/:id : get the "id" emEmpBenefits.
     *
     * @param id the id of the emEmpBenefitsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpBenefitsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-benefits/{id}")
    @Timed
    public ResponseEntity<EmEmpBenefitsDTO> getEmEmpBenefits(@PathVariable Long id) {
        log.debug("REST request to get EmEmpBenefits : {}", id);
        EmEmpBenefits emEmpBenefits = emEmpBenefitsRepository.findOne(id);
        EmEmpBenefitsDTO emEmpBenefitsDTO = emEmpBenefitsMapper.toDto(emEmpBenefits);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpBenefitsDTO));
    }

    /**
     * DELETE  /em-emp-benefits/:id : delete the "id" emEmpBenefits.
     *
     * @param id the id of the emEmpBenefitsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-benefits/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpBenefits(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpBenefits : {}", id);
        emEmpBenefitsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
