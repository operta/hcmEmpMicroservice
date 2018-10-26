package com.infostudio.ba.web.rest;

import org.apache.commons.lang.RandomStringUtils;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmBorrowingTypes;

import com.infostudio.ba.repository.EmBorrowingTypesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmBorrowingTypesDTO;
import com.infostudio.ba.service.mapper.EmBorrowingTypesMapper;
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
 * REST controller for managing EmBorrowingTypes.
 */
@RestController
@RequestMapping("/api")
public class EmBorrowingTypesResource {

    private final Logger log = LoggerFactory.getLogger(EmBorrowingTypesResource.class);

    private static final String ENTITY_NAME = "emBorrowingTypes";

    private final EmBorrowingTypesRepository emBorrowingTypesRepository;

    private final EmBorrowingTypesMapper emBorrowingTypesMapper;

    public EmBorrowingTypesResource(EmBorrowingTypesRepository emBorrowingTypesRepository, EmBorrowingTypesMapper emBorrowingTypesMapper) {
        this.emBorrowingTypesRepository = emBorrowingTypesRepository;
        this.emBorrowingTypesMapper = emBorrowingTypesMapper;
    }

    /**
     * POST  /em-borrowing-types : Create a new emBorrowingTypes.
     *
     * @param emBorrowingTypesDTO the emBorrowingTypesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emBorrowingTypesDTO, or with status 400 (Bad Request) if the emBorrowingTypes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-borrowing-types")
    @Timed
    public ResponseEntity<EmBorrowingTypesDTO> createEmBorrowingTypes(@Valid @RequestBody EmBorrowingTypesDTO emBorrowingTypesDTO) throws URISyntaxException {
        log.debug("REST request to save EmBorrowingTypes : {}", emBorrowingTypesDTO);
        if (emBorrowingTypesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emBorrowingTypes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        String newCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        while(emBorrowingTypesRepository.findByCode(newCode) != null){
            newCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        }
        emBorrowingTypesDTO.setCode(newCode);
        EmBorrowingTypes emBorrowingTypes = emBorrowingTypesMapper.toEntity(emBorrowingTypesDTO);
        emBorrowingTypes = emBorrowingTypesRepository.save(emBorrowingTypes);
        EmBorrowingTypesDTO result = emBorrowingTypesMapper.toDto(emBorrowingTypes);
        return ResponseEntity.created(new URI("/api/em-borrowing-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-borrowing-types : Updates an existing emBorrowingTypes.
     *
     * @param emBorrowingTypesDTO the emBorrowingTypesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emBorrowingTypesDTO,
     * or with status 400 (Bad Request) if the emBorrowingTypesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emBorrowingTypesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-borrowing-types")
    @Timed
    public ResponseEntity<EmBorrowingTypesDTO> updateEmBorrowingTypes(@Valid @RequestBody EmBorrowingTypesDTO emBorrowingTypesDTO) throws URISyntaxException {
        log.debug("REST request to update EmBorrowingTypes : {}", emBorrowingTypesDTO);
        if (emBorrowingTypesDTO.getId() == null) {
            return createEmBorrowingTypes(emBorrowingTypesDTO);
        }
        EmBorrowingTypes emBorrowingTypes = emBorrowingTypesMapper.toEntity(emBorrowingTypesDTO);
        emBorrowingTypes = emBorrowingTypesRepository.save(emBorrowingTypes);
        EmBorrowingTypesDTO result = emBorrowingTypesMapper.toDto(emBorrowingTypes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emBorrowingTypesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-borrowing-types : get all the emBorrowingTypes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emBorrowingTypes in body
     */
    @GetMapping("/em-borrowing-types")
    @Timed
    public ResponseEntity<List<EmBorrowingTypesDTO>> getAllEmBorrowingTypes(Pageable pageable) {
        log.debug("REST request to get a page of EmBorrowingTypes");
        Page<EmBorrowingTypes> page = emBorrowingTypesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-borrowing-types");
        return new ResponseEntity<>(emBorrowingTypesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-borrowing-types/:id : get the "id" emBorrowingTypes.
     *
     * @param id the id of the emBorrowingTypesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emBorrowingTypesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-borrowing-types/{id}")
    @Timed
    public ResponseEntity<EmBorrowingTypesDTO> getEmBorrowingTypes(@PathVariable Long id) {
        log.debug("REST request to get EmBorrowingTypes : {}", id);
        EmBorrowingTypes emBorrowingTypes = emBorrowingTypesRepository.findOne(id);
        EmBorrowingTypesDTO emBorrowingTypesDTO = emBorrowingTypesMapper.toDto(emBorrowingTypes);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emBorrowingTypesDTO));
    }

    /**
     * DELETE  /em-borrowing-types/:id : delete the "id" emBorrowingTypes.
     *
     * @param id the id of the emBorrowingTypesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-borrowing-types/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmBorrowingTypes(@PathVariable Long id) {
        log.debug("REST request to delete EmBorrowingTypes : {}", id);
        emBorrowingTypesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
