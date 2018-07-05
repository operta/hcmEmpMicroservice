package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpIdentifications;

import com.infostudio.ba.repository.EmEmpIdentificationsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpIdentificationsDTO;
import com.infostudio.ba.service.mapper.EmEmpIdentificationsMapper;
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
 * REST controller for managing EmEmpIdentifications.
 */
@RestController
@RequestMapping("/api")
public class EmEmpIdentificationsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpIdentificationsResource.class);

    private static final String ENTITY_NAME = "emEmpIdentifications";

    private final EmEmpIdentificationsRepository emEmpIdentificationsRepository;

    private final EmEmpIdentificationsMapper emEmpIdentificationsMapper;

    public EmEmpIdentificationsResource(EmEmpIdentificationsRepository emEmpIdentificationsRepository, EmEmpIdentificationsMapper emEmpIdentificationsMapper) {
        this.emEmpIdentificationsRepository = emEmpIdentificationsRepository;
        this.emEmpIdentificationsMapper = emEmpIdentificationsMapper;
    }

    /**
     * POST  /em-emp-identifications : Create a new emEmpIdentifications.
     *
     * @param emEmpIdentificationsDTO the emEmpIdentificationsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpIdentificationsDTO, or with status 400 (Bad Request) if the emEmpIdentifications has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-identifications")
    @Timed
    public ResponseEntity<EmEmpIdentificationsDTO> createEmEmpIdentifications(@Valid @RequestBody EmEmpIdentificationsDTO emEmpIdentificationsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpIdentifications : {}", emEmpIdentificationsDTO);
        if (emEmpIdentificationsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpIdentifications cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpIdentifications emEmpIdentifications = emEmpIdentificationsMapper.toEntity(emEmpIdentificationsDTO);
        emEmpIdentifications = emEmpIdentificationsRepository.save(emEmpIdentifications);
        EmEmpIdentificationsDTO result = emEmpIdentificationsMapper.toDto(emEmpIdentifications);
        return ResponseEntity.created(new URI("/api/em-emp-identifications/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-identifications : Updates an existing emEmpIdentifications.
     *
     * @param emEmpIdentificationsDTO the emEmpIdentificationsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpIdentificationsDTO,
     * or with status 400 (Bad Request) if the emEmpIdentificationsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpIdentificationsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-identifications")
    @Timed
    public ResponseEntity<EmEmpIdentificationsDTO> updateEmEmpIdentifications(@Valid @RequestBody EmEmpIdentificationsDTO emEmpIdentificationsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpIdentifications : {}", emEmpIdentificationsDTO);
        if (emEmpIdentificationsDTO.getId() == null) {
            return createEmEmpIdentifications(emEmpIdentificationsDTO);
        }
        EmEmpIdentifications emEmpIdentifications = emEmpIdentificationsMapper.toEntity(emEmpIdentificationsDTO);
        emEmpIdentifications = emEmpIdentificationsRepository.save(emEmpIdentifications);
        EmEmpIdentificationsDTO result = emEmpIdentificationsMapper.toDto(emEmpIdentifications);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpIdentificationsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-identifications : get all the emEmpIdentifications.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpIdentifications in body
     */
    @GetMapping("/em-emp-identifications")
    @Timed
    public ResponseEntity<List<EmEmpIdentificationsDTO>> getAllEmEmpIdentifications(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpIdentifications");
        Page<EmEmpIdentifications> page = emEmpIdentificationsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-identifications");
        return new ResponseEntity<>(emEmpIdentificationsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-identifications/:id : get the "id" emEmpIdentifications.
     *
     * @param id the id of the emEmpIdentificationsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpIdentificationsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-identifications/{id}")
    @Timed
    public ResponseEntity<EmEmpIdentificationsDTO> getEmEmpIdentifications(@PathVariable Long id) {
        log.debug("REST request to get EmEmpIdentifications : {}", id);
        EmEmpIdentifications emEmpIdentifications = emEmpIdentificationsRepository.findOne(id);
        EmEmpIdentificationsDTO emEmpIdentificationsDTO = emEmpIdentificationsMapper.toDto(emEmpIdentifications);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpIdentificationsDTO));
    }

    /**
     * GET  /em-emp-identifications/employee/:id
     *
     * @param id
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpIdentificationsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-identifications/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpIdentificationsDTO>> getEmEmpIdentificationsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpIdentifications by Employee Id : {}", id);
        List<EmEmpIdentifications> emEmpIdentifications = emEmpIdentificationsRepository.findByIdEmployeeId(id);
        List<EmEmpIdentificationsDTO> emEmpIdentificationsDTO = emEmpIdentificationsMapper.toDto(emEmpIdentifications);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpIdentificationsDTO));
    }

    /**
     * DELETE  /em-emp-identifications/:id : delete the "id" emEmpIdentifications.
     *
     * @param id the id of the emEmpIdentificationsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-identifications/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpIdentifications(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpIdentifications : {}", id);
        emEmpIdentificationsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
