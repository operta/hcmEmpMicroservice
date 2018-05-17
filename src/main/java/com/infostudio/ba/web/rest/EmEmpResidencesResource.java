package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpResidences;

import com.infostudio.ba.repository.EmEmpResidencesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpResidencesDTO;
import com.infostudio.ba.service.mapper.EmEmpResidencesMapper;
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
 * REST controller for managing EmEmpResidences.
 */
@RestController
@RequestMapping("/api")
public class EmEmpResidencesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpResidencesResource.class);

    private static final String ENTITY_NAME = "emEmpResidences";

    private final EmEmpResidencesRepository emEmpResidencesRepository;

    private final EmEmpResidencesMapper emEmpResidencesMapper;

    public EmEmpResidencesResource(EmEmpResidencesRepository emEmpResidencesRepository, EmEmpResidencesMapper emEmpResidencesMapper) {
        this.emEmpResidencesRepository = emEmpResidencesRepository;
        this.emEmpResidencesMapper = emEmpResidencesMapper;
    }

    /**
     * POST  /em-emp-residences : Create a new emEmpResidences.
     *
     * @param emEmpResidencesDTO the emEmpResidencesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpResidencesDTO, or with status 400 (Bad Request) if the emEmpResidences has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-residences")
    @Timed
    public ResponseEntity<EmEmpResidencesDTO> createEmEmpResidences(@RequestBody EmEmpResidencesDTO emEmpResidencesDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpResidences : {}", emEmpResidencesDTO);
        if (emEmpResidencesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpResidences cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpResidences emEmpResidences = emEmpResidencesMapper.toEntity(emEmpResidencesDTO);
        emEmpResidences = emEmpResidencesRepository.save(emEmpResidences);
        EmEmpResidencesDTO result = emEmpResidencesMapper.toDto(emEmpResidences);
        return ResponseEntity.created(new URI("/api/em-emp-residences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-residences : Updates an existing emEmpResidences.
     *
     * @param emEmpResidencesDTO the emEmpResidencesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpResidencesDTO,
     * or with status 400 (Bad Request) if the emEmpResidencesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpResidencesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-residences")
    @Timed
    public ResponseEntity<EmEmpResidencesDTO> updateEmEmpResidences(@RequestBody EmEmpResidencesDTO emEmpResidencesDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpResidences : {}", emEmpResidencesDTO);
        if (emEmpResidencesDTO.getId() == null) {
            return createEmEmpResidences(emEmpResidencesDTO);
        }
        EmEmpResidences emEmpResidences = emEmpResidencesMapper.toEntity(emEmpResidencesDTO);
        emEmpResidences = emEmpResidencesRepository.save(emEmpResidences);
        EmEmpResidencesDTO result = emEmpResidencesMapper.toDto(emEmpResidences);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpResidencesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-residences : get all the emEmpResidences.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpResidences in body
     */
    @GetMapping("/em-emp-residences")
    @Timed
    public ResponseEntity<List<EmEmpResidencesDTO>> getAllEmEmpResidences(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpResidences");
        Page<EmEmpResidences> page = emEmpResidencesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-residences");
        return new ResponseEntity<>(emEmpResidencesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-residences/:id : get the "id" emEmpResidences.
     *
     * @param id the id of the emEmpResidencesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpResidencesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-residences/{id}")
    @Timed
    public ResponseEntity<EmEmpResidencesDTO> getEmEmpResidences(@PathVariable Long id) {
        log.debug("REST request to get EmEmpResidences : {}", id);
        EmEmpResidences emEmpResidences = emEmpResidencesRepository.findOne(id);
        EmEmpResidencesDTO emEmpResidencesDTO = emEmpResidencesMapper.toDto(emEmpResidences);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpResidencesDTO));
    }

    /**
     * DELETE  /em-emp-residences/:id : delete the "id" emEmpResidences.
     *
     * @param id the id of the emEmpResidencesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-residences/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpResidences(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpResidences : {}", id);
        emEmpResidencesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
