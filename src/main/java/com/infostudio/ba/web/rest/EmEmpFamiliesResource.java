package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpFamilies;

import com.infostudio.ba.repository.EmEmpFamiliesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpFamiliesDTO;
import com.infostudio.ba.service.mapper.EmEmpFamiliesMapper;
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
 * REST controller for managing EmEmpFamilies.
 */
@RestController
@RequestMapping("/api")
public class EmEmpFamiliesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpFamiliesResource.class);

    private static final String ENTITY_NAME = "emEmpFamilies";

    private final EmEmpFamiliesRepository emEmpFamiliesRepository;

    private final EmEmpFamiliesMapper emEmpFamiliesMapper;

    public EmEmpFamiliesResource(EmEmpFamiliesRepository emEmpFamiliesRepository, EmEmpFamiliesMapper emEmpFamiliesMapper) {
        this.emEmpFamiliesRepository = emEmpFamiliesRepository;
        this.emEmpFamiliesMapper = emEmpFamiliesMapper;
    }

    /**
     * POST  /em-emp-families : Create a new emEmpFamilies.
     *
     * @param emEmpFamiliesDTO the emEmpFamiliesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpFamiliesDTO, or with status 400 (Bad Request) if the emEmpFamilies has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-families")
    @Timed
    public ResponseEntity<EmEmpFamiliesDTO> createEmEmpFamilies(@Valid @RequestBody EmEmpFamiliesDTO emEmpFamiliesDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpFamilies : {}", emEmpFamiliesDTO);
        if (emEmpFamiliesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpFamilies cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpFamilies emEmpFamilies = emEmpFamiliesMapper.toEntity(emEmpFamiliesDTO);
        emEmpFamilies = emEmpFamiliesRepository.save(emEmpFamilies);
        EmEmpFamiliesDTO result = emEmpFamiliesMapper.toDto(emEmpFamilies);
        return ResponseEntity.created(new URI("/api/em-emp-families/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-families : Updates an existing emEmpFamilies.
     *
     * @param emEmpFamiliesDTO the emEmpFamiliesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpFamiliesDTO,
     * or with status 400 (Bad Request) if the emEmpFamiliesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpFamiliesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-families")
    @Timed
    public ResponseEntity<EmEmpFamiliesDTO> updateEmEmpFamilies(@Valid @RequestBody EmEmpFamiliesDTO emEmpFamiliesDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpFamilies : {}", emEmpFamiliesDTO);
        if (emEmpFamiliesDTO.getId() == null) {
            return createEmEmpFamilies(emEmpFamiliesDTO);
        }
        EmEmpFamilies emEmpFamilies = emEmpFamiliesMapper.toEntity(emEmpFamiliesDTO);
        emEmpFamilies = emEmpFamiliesRepository.save(emEmpFamilies);
        EmEmpFamiliesDTO result = emEmpFamiliesMapper.toDto(emEmpFamilies);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpFamiliesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-families : get all the emEmpFamilies.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpFamilies in body
     */
    @GetMapping("/em-emp-families")
    @Timed
    public ResponseEntity<List<EmEmpFamiliesDTO>> getAllEmEmpFamilies(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpFamilies");
        Page<EmEmpFamilies> page = emEmpFamiliesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-families");
        return new ResponseEntity<>(emEmpFamiliesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-families/:id : get the "id" emEmpFamilies.
     *
     * @param id the id of the emEmpFamiliesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpFamiliesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-families/{id}")
    @Timed
    public ResponseEntity<EmEmpFamiliesDTO> getEmEmpFamilies(@PathVariable Long id) {
        log.debug("REST request to get EmEmpFamilies : {}", id);
        EmEmpFamilies emEmpFamilies = emEmpFamiliesRepository.findOne(id);
        EmEmpFamiliesDTO emEmpFamiliesDTO = emEmpFamiliesMapper.toDto(emEmpFamilies);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpFamiliesDTO));
    }

    /**
     * DELETE  /em-emp-families/:id : delete the "id" emEmpFamilies.
     *
     * @param id the id of the emEmpFamiliesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-families/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpFamilies(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpFamilies : {}", id);
        emEmpFamiliesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
