package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpDisabilities;

import com.infostudio.ba.repository.EmEmpDisabilitiesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpDisabilitiesDTO;
import com.infostudio.ba.service.mapper.EmEmpDisabilitiesMapper;
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
 * REST controller for managing EmEmpDisabilities.
 */
@RestController
@RequestMapping("/api")
public class EmEmpDisabilitiesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpDisabilitiesResource.class);

    private static final String ENTITY_NAME = "emEmpDisabilities";

    private final EmEmpDisabilitiesRepository emEmpDisabilitiesRepository;

    private final EmEmpDisabilitiesMapper emEmpDisabilitiesMapper;

    public EmEmpDisabilitiesResource(EmEmpDisabilitiesRepository emEmpDisabilitiesRepository, EmEmpDisabilitiesMapper emEmpDisabilitiesMapper) {
        this.emEmpDisabilitiesRepository = emEmpDisabilitiesRepository;
        this.emEmpDisabilitiesMapper = emEmpDisabilitiesMapper;
    }

    /**
     * POST  /em-emp-disabilities : Create a new emEmpDisabilities.
     *
     * @param emEmpDisabilitiesDTO the emEmpDisabilitiesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpDisabilitiesDTO, or with status 400 (Bad Request) if the emEmpDisabilities has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-disabilities")
    @Timed
    public ResponseEntity<EmEmpDisabilitiesDTO> createEmEmpDisabilities(@RequestBody EmEmpDisabilitiesDTO emEmpDisabilitiesDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpDisabilities : {}", emEmpDisabilitiesDTO);
        if (emEmpDisabilitiesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpDisabilities cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpDisabilities emEmpDisabilities = emEmpDisabilitiesMapper.toEntity(emEmpDisabilitiesDTO);
        emEmpDisabilities = emEmpDisabilitiesRepository.save(emEmpDisabilities);
        EmEmpDisabilitiesDTO result = emEmpDisabilitiesMapper.toDto(emEmpDisabilities);
        return ResponseEntity.created(new URI("/api/em-emp-disabilities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-disabilities : Updates an existing emEmpDisabilities.
     *
     * @param emEmpDisabilitiesDTO the emEmpDisabilitiesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpDisabilitiesDTO,
     * or with status 400 (Bad Request) if the emEmpDisabilitiesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpDisabilitiesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-disabilities")
    @Timed
    public ResponseEntity<EmEmpDisabilitiesDTO> updateEmEmpDisabilities(@RequestBody EmEmpDisabilitiesDTO emEmpDisabilitiesDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpDisabilities : {}", emEmpDisabilitiesDTO);
        if (emEmpDisabilitiesDTO.getId() == null) {
            return createEmEmpDisabilities(emEmpDisabilitiesDTO);
        }
        EmEmpDisabilities emEmpDisabilities = emEmpDisabilitiesMapper.toEntity(emEmpDisabilitiesDTO);
        emEmpDisabilities = emEmpDisabilitiesRepository.save(emEmpDisabilities);
        EmEmpDisabilitiesDTO result = emEmpDisabilitiesMapper.toDto(emEmpDisabilities);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpDisabilitiesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-disabilities : get all the emEmpDisabilities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpDisabilities in body
     */
    @GetMapping("/em-emp-disabilities")
    @Timed
    public ResponseEntity<List<EmEmpDisabilitiesDTO>> getAllEmEmpDisabilities(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpDisabilities");
        Page<EmEmpDisabilities> page = emEmpDisabilitiesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-disabilities");
        return new ResponseEntity<>(emEmpDisabilitiesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-disabilities/:id : get the "id" emEmpDisabilities.
     *
     * @param id the id of the emEmpDisabilitiesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpDisabilitiesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-disabilities/{id}")
    @Timed
    public ResponseEntity<EmEmpDisabilitiesDTO> getEmEmpDisabilities(@PathVariable Long id) {
        log.debug("REST request to get EmEmpDisabilities : {}", id);
        EmEmpDisabilities emEmpDisabilities = emEmpDisabilitiesRepository.findOne(id);
        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO = emEmpDisabilitiesMapper.toDto(emEmpDisabilities);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpDisabilitiesDTO));
    }

    /**
     * DELETE  /em-emp-disabilities/:id : delete the "id" emEmpDisabilities.
     *
     * @param id the id of the emEmpDisabilitiesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-disabilities/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpDisabilities(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpDisabilities : {}", id);
        emEmpDisabilitiesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
