package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpAccomplishments;

import com.infostudio.ba.repository.EmEmpAccomplishmentsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpAccomplishmentsDTO;
import com.infostudio.ba.service.mapper.EmEmpAccomplishmentsMapper;
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
 * REST controller for managing EmEmpAccomplishments.
 */
@RestController
@RequestMapping("/api")
public class EmEmpAccomplishmentsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpAccomplishmentsResource.class);

    private static final String ENTITY_NAME = "emEmpAccomplishments";

    private final EmEmpAccomplishmentsRepository emEmpAccomplishmentsRepository;

    private final EmEmpAccomplishmentsMapper emEmpAccomplishmentsMapper;

    public EmEmpAccomplishmentsResource(EmEmpAccomplishmentsRepository emEmpAccomplishmentsRepository, EmEmpAccomplishmentsMapper emEmpAccomplishmentsMapper) {
        this.emEmpAccomplishmentsRepository = emEmpAccomplishmentsRepository;
        this.emEmpAccomplishmentsMapper = emEmpAccomplishmentsMapper;
    }

    /**
     * POST  /em-emp-accomplishments : Create a new emEmpAccomplishments.
     *
     * @param emEmpAccomplishmentsDTO the emEmpAccomplishmentsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpAccomplishmentsDTO, or with status 400 (Bad Request) if the emEmpAccomplishments has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-accomplishments")
    @Timed
    public ResponseEntity<EmEmpAccomplishmentsDTO> createEmEmpAccomplishments(@Valid @RequestBody EmEmpAccomplishmentsDTO emEmpAccomplishmentsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpAccomplishments : {}", emEmpAccomplishmentsDTO);
        if (emEmpAccomplishmentsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpAccomplishments cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpAccomplishments emEmpAccomplishments = emEmpAccomplishmentsMapper.toEntity(emEmpAccomplishmentsDTO);
        emEmpAccomplishments = emEmpAccomplishmentsRepository.save(emEmpAccomplishments);
        EmEmpAccomplishmentsDTO result = emEmpAccomplishmentsMapper.toDto(emEmpAccomplishments);
        return ResponseEntity.created(new URI("/api/em-emp-accomplishments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-accomplishments : Updates an existing emEmpAccomplishments.
     *
     * @param emEmpAccomplishmentsDTO the emEmpAccomplishmentsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpAccomplishmentsDTO,
     * or with status 400 (Bad Request) if the emEmpAccomplishmentsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpAccomplishmentsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-accomplishments")
    @Timed
    public ResponseEntity<EmEmpAccomplishmentsDTO> updateEmEmpAccomplishments(@Valid @RequestBody EmEmpAccomplishmentsDTO emEmpAccomplishmentsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpAccomplishments : {}", emEmpAccomplishmentsDTO);
        if (emEmpAccomplishmentsDTO.getId() == null) {
            return createEmEmpAccomplishments(emEmpAccomplishmentsDTO);
        }
        EmEmpAccomplishments emEmpAccomplishments = emEmpAccomplishmentsMapper.toEntity(emEmpAccomplishmentsDTO);
        emEmpAccomplishments = emEmpAccomplishmentsRepository.save(emEmpAccomplishments);
        EmEmpAccomplishmentsDTO result = emEmpAccomplishmentsMapper.toDto(emEmpAccomplishments);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpAccomplishmentsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-accomplishments : get all the emEmpAccomplishments.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpAccomplishments in body
     */
    @GetMapping("/em-emp-accomplishments")
    @Timed
    public ResponseEntity<List<EmEmpAccomplishmentsDTO>> getAllEmEmpAccomplishments(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpAccomplishments");
        Page<EmEmpAccomplishments> page = emEmpAccomplishmentsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-accomplishments");
        return new ResponseEntity<>(emEmpAccomplishmentsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-accomplishments/:id : get the "id" emEmpAccomplishments.
     *
     * @param id the id of the emEmpAccomplishmentsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpAccomplishmentsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-accomplishments/{id}")
    @Timed
    public ResponseEntity<EmEmpAccomplishmentsDTO> getEmEmpAccomplishments(@PathVariable Long id) {
        log.debug("REST request to get EmEmpAccomplishments : {}", id);
        EmEmpAccomplishments emEmpAccomplishments = emEmpAccomplishmentsRepository.findOne(id);
        EmEmpAccomplishmentsDTO emEmpAccomplishmentsDTO = emEmpAccomplishmentsMapper.toDto(emEmpAccomplishments);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpAccomplishmentsDTO));
    }

    /**
     * GET  /em-emp-accomplishments/employee/:id.
     *
     * @param id
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpAccomplishmentsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-accomplishments/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpAccomplishmentsDTO>> getEmEmpAccomplishmentsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpAccomplishments by EmployeeId: {}", id);
        Page<EmEmpAccomplishments> page = emEmpAccomplishmentsRepository.findByIdEmployeeId(id);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-accomplishments");
        return new ResponseEntity<>(emEmpAccomplishmentsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * DELETE  /em-emp-accomplishments/:id : delete the "id" emEmpAccomplishments.
     *
     * @param id the id of the emEmpAccomplishmentsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-accomplishments/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpAccomplishments(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpAccomplishments : {}", id);
        emEmpAccomplishmentsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
