package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpDocuments;

import com.infostudio.ba.repository.EmEmpDocumentsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpDocumentsDTO;
import com.infostudio.ba.service.mapper.EmEmpDocumentsMapper;
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
 * REST controller for managing EmEmpDocuments.
 */
@RestController
@RequestMapping("/api")
public class EmEmpDocumentsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpDocumentsResource.class);

    private static final String ENTITY_NAME = "emEmpDocuments";

    private final EmEmpDocumentsRepository emEmpDocumentsRepository;

    private final EmEmpDocumentsMapper emEmpDocumentsMapper;

    public EmEmpDocumentsResource(EmEmpDocumentsRepository emEmpDocumentsRepository, EmEmpDocumentsMapper emEmpDocumentsMapper) {
        this.emEmpDocumentsRepository = emEmpDocumentsRepository;
        this.emEmpDocumentsMapper = emEmpDocumentsMapper;
    }

    /**
     * POST  /em-emp-documents : Create a new emEmpDocuments.
     *
     * @param emEmpDocumentsDTO the emEmpDocumentsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpDocumentsDTO, or with status 400 (Bad Request) if the emEmpDocuments has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-documents")
    @Timed
    public ResponseEntity<EmEmpDocumentsDTO> createEmEmpDocuments(@Valid @RequestBody EmEmpDocumentsDTO emEmpDocumentsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpDocuments : {}", emEmpDocumentsDTO);
        if (emEmpDocumentsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpDocuments cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpDocuments emEmpDocuments = emEmpDocumentsMapper.toEntity(emEmpDocumentsDTO);
        emEmpDocuments = emEmpDocumentsRepository.save(emEmpDocuments);
        EmEmpDocumentsDTO result = emEmpDocumentsMapper.toDto(emEmpDocuments);
        return ResponseEntity.created(new URI("/api/em-emp-documents/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-documents : Updates an existing emEmpDocuments.
     *
     * @param emEmpDocumentsDTO the emEmpDocumentsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpDocumentsDTO,
     * or with status 400 (Bad Request) if the emEmpDocumentsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpDocumentsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-documents")
    @Timed
    public ResponseEntity<EmEmpDocumentsDTO> updateEmEmpDocuments(@Valid @RequestBody EmEmpDocumentsDTO emEmpDocumentsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpDocuments : {}", emEmpDocumentsDTO);
        if (emEmpDocumentsDTO.getId() == null) {
            return createEmEmpDocuments(emEmpDocumentsDTO);
        }
        EmEmpDocuments emEmpDocuments = emEmpDocumentsMapper.toEntity(emEmpDocumentsDTO);
        emEmpDocuments = emEmpDocumentsRepository.save(emEmpDocuments);
        EmEmpDocumentsDTO result = emEmpDocumentsMapper.toDto(emEmpDocuments);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpDocumentsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-documents : get all the emEmpDocuments.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpDocuments in body
     */
    @GetMapping("/em-emp-documents")
    @Timed
    public ResponseEntity<List<EmEmpDocumentsDTO>> getAllEmEmpDocuments(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpDocuments");
        Page<EmEmpDocuments> page = emEmpDocumentsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-documents");
        return new ResponseEntity<>(emEmpDocumentsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-documents/:id : get the "id" emEmpDocuments.
     *
     * @param id the id of the emEmpDocumentsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpDocumentsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-documents/{id}")
    @Timed
    public ResponseEntity<EmEmpDocumentsDTO> getEmEmpDocuments(@PathVariable Long id) {
        log.debug("REST request to get EmEmpDocuments : {}", id);
        EmEmpDocuments emEmpDocuments = emEmpDocumentsRepository.findOne(id);
        EmEmpDocumentsDTO emEmpDocumentsDTO = emEmpDocumentsMapper.toDto(emEmpDocuments);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpDocumentsDTO));
    }

    /**
     * GET  /em-emp-documents/employee/:id : get the "id" emEmpDocuments.
     *
     * @param id
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpDocumentsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-documents/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpDocumentsDTO>> getEmEmpDocumentsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpDocuments by Employee id : {}", id);
        List<EmEmpDocuments> emEmpDocuments = emEmpDocumentsRepository.findByIdEmployeeId(id);
        List<EmEmpDocumentsDTO> emEmpDocumentsDTO = emEmpDocumentsMapper.toDto(emEmpDocuments);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpDocumentsDTO));
    }

    /**
     * DELETE  /em-emp-documents/:id : delete the "id" emEmpDocuments.
     *
     * @param id the id of the emEmpDocumentsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-documents/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpDocuments(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpDocuments : {}", id);
        emEmpDocumentsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
