package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpContacts;

import com.infostudio.ba.repository.EmEmpContactsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpContactsDTO;
import com.infostudio.ba.service.mapper.EmEmpContactsMapper;
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
 * REST controller for managing EmEmpContacts.
 */
@RestController
@RequestMapping("/api")
public class EmEmpContactsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpContactsResource.class);

    private static final String ENTITY_NAME = "emEmpContacts";

    private final EmEmpContactsRepository emEmpContactsRepository;

    private final EmEmpContactsMapper emEmpContactsMapper;

    public EmEmpContactsResource(EmEmpContactsRepository emEmpContactsRepository, EmEmpContactsMapper emEmpContactsMapper) {
        this.emEmpContactsRepository = emEmpContactsRepository;
        this.emEmpContactsMapper = emEmpContactsMapper;
    }

    /**
     * POST  /em-emp-contacts : Create a new emEmpContacts.
     *
     * @param emEmpContactsDTO the emEmpContactsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpContactsDTO, or with status 400 (Bad Request) if the emEmpContacts has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-contacts")
    @Timed
    public ResponseEntity<EmEmpContactsDTO> createEmEmpContacts(@RequestBody EmEmpContactsDTO emEmpContactsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpContacts : {}", emEmpContactsDTO);
        if (emEmpContactsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpContacts cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpContacts emEmpContacts = emEmpContactsMapper.toEntity(emEmpContactsDTO);
        emEmpContacts = emEmpContactsRepository.save(emEmpContacts);
        EmEmpContactsDTO result = emEmpContactsMapper.toDto(emEmpContacts);
        return ResponseEntity.created(new URI("/api/em-emp-contacts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-contacts : Updates an existing emEmpContacts.
     *
     * @param emEmpContactsDTO the emEmpContactsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpContactsDTO,
     * or with status 400 (Bad Request) if the emEmpContactsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpContactsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-contacts")
    @Timed
    public ResponseEntity<EmEmpContactsDTO> updateEmEmpContacts(@RequestBody EmEmpContactsDTO emEmpContactsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpContacts : {}", emEmpContactsDTO);
        if (emEmpContactsDTO.getId() == null) {
            return createEmEmpContacts(emEmpContactsDTO);
        }
        EmEmpContacts emEmpContacts = emEmpContactsMapper.toEntity(emEmpContactsDTO);
        emEmpContacts = emEmpContactsRepository.save(emEmpContacts);
        EmEmpContactsDTO result = emEmpContactsMapper.toDto(emEmpContacts);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpContactsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-contacts : get all the emEmpContacts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpContacts in body
     */
    @GetMapping("/em-emp-contacts")
    @Timed
    public ResponseEntity<List<EmEmpContactsDTO>> getAllEmEmpContacts(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpContacts");
        Page<EmEmpContacts> page = emEmpContactsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-contacts");
        return new ResponseEntity<>(emEmpContactsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-contacts/:id : get the "id" emEmpContacts.
     *
     * @param id the id of the emEmpContactsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpContactsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-contacts/{id}")
    @Timed
    public ResponseEntity<EmEmpContactsDTO> getEmEmpContacts(@PathVariable Long id) {
        log.debug("REST request to get EmEmpContacts : {}", id);
        EmEmpContacts emEmpContacts = emEmpContactsRepository.findOne(id);
        EmEmpContactsDTO emEmpContactsDTO = emEmpContactsMapper.toDto(emEmpContacts);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpContactsDTO));
    }

    /**
     * DELETE  /em-emp-contacts/:id : delete the "id" emEmpContacts.
     *
     * @param id the id of the emEmpContactsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-contacts/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpContacts(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpContacts : {}", id);
        emEmpContactsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
