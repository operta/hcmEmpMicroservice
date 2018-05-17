package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpCitizenships;

import com.infostudio.ba.repository.EmEmpCitizenshipsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpCitizenshipsDTO;
import com.infostudio.ba.service.mapper.EmEmpCitizenshipsMapper;
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
 * REST controller for managing EmEmpCitizenships.
 */
@RestController
@RequestMapping("/api")
public class EmEmpCitizenshipsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpCitizenshipsResource.class);

    private static final String ENTITY_NAME = "emEmpCitizenships";

    private final EmEmpCitizenshipsRepository emEmpCitizenshipsRepository;

    private final EmEmpCitizenshipsMapper emEmpCitizenshipsMapper;

    public EmEmpCitizenshipsResource(EmEmpCitizenshipsRepository emEmpCitizenshipsRepository, EmEmpCitizenshipsMapper emEmpCitizenshipsMapper) {
        this.emEmpCitizenshipsRepository = emEmpCitizenshipsRepository;
        this.emEmpCitizenshipsMapper = emEmpCitizenshipsMapper;
    }

    /**
     * POST  /em-emp-citizenships : Create a new emEmpCitizenships.
     *
     * @param emEmpCitizenshipsDTO the emEmpCitizenshipsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpCitizenshipsDTO, or with status 400 (Bad Request) if the emEmpCitizenships has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-citizenships")
    @Timed
    public ResponseEntity<EmEmpCitizenshipsDTO> createEmEmpCitizenships(@RequestBody EmEmpCitizenshipsDTO emEmpCitizenshipsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpCitizenships : {}", emEmpCitizenshipsDTO);
        if (emEmpCitizenshipsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpCitizenships cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpCitizenships emEmpCitizenships = emEmpCitizenshipsMapper.toEntity(emEmpCitizenshipsDTO);
        emEmpCitizenships = emEmpCitizenshipsRepository.save(emEmpCitizenships);
        EmEmpCitizenshipsDTO result = emEmpCitizenshipsMapper.toDto(emEmpCitizenships);
        return ResponseEntity.created(new URI("/api/em-emp-citizenships/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-citizenships : Updates an existing emEmpCitizenships.
     *
     * @param emEmpCitizenshipsDTO the emEmpCitizenshipsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpCitizenshipsDTO,
     * or with status 400 (Bad Request) if the emEmpCitizenshipsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpCitizenshipsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-citizenships")
    @Timed
    public ResponseEntity<EmEmpCitizenshipsDTO> updateEmEmpCitizenships(@RequestBody EmEmpCitizenshipsDTO emEmpCitizenshipsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpCitizenships : {}", emEmpCitizenshipsDTO);
        if (emEmpCitizenshipsDTO.getId() == null) {
            return createEmEmpCitizenships(emEmpCitizenshipsDTO);
        }
        EmEmpCitizenships emEmpCitizenships = emEmpCitizenshipsMapper.toEntity(emEmpCitizenshipsDTO);
        emEmpCitizenships = emEmpCitizenshipsRepository.save(emEmpCitizenships);
        EmEmpCitizenshipsDTO result = emEmpCitizenshipsMapper.toDto(emEmpCitizenships);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpCitizenshipsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-citizenships : get all the emEmpCitizenships.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpCitizenships in body
     */
    @GetMapping("/em-emp-citizenships")
    @Timed
    public ResponseEntity<List<EmEmpCitizenshipsDTO>> getAllEmEmpCitizenships(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpCitizenships");
        Page<EmEmpCitizenships> page = emEmpCitizenshipsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-citizenships");
        return new ResponseEntity<>(emEmpCitizenshipsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-citizenships/:id : get the "id" emEmpCitizenships.
     *
     * @param id the id of the emEmpCitizenshipsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpCitizenshipsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-citizenships/{id}")
    @Timed
    public ResponseEntity<EmEmpCitizenshipsDTO> getEmEmpCitizenships(@PathVariable Long id) {
        log.debug("REST request to get EmEmpCitizenships : {}", id);
        EmEmpCitizenships emEmpCitizenships = emEmpCitizenshipsRepository.findOne(id);
        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO = emEmpCitizenshipsMapper.toDto(emEmpCitizenships);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpCitizenshipsDTO));
    }

    /**
     * DELETE  /em-emp-citizenships/:id : delete the "id" emEmpCitizenships.
     *
     * @param id the id of the emEmpCitizenshipsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-citizenships/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpCitizenships(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpCitizenships : {}", id);
        emEmpCitizenshipsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
