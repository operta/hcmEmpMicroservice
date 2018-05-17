package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpNotes;

import com.infostudio.ba.repository.EmEmpNotesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpNotesDTO;
import com.infostudio.ba.service.mapper.EmEmpNotesMapper;
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
 * REST controller for managing EmEmpNotes.
 */
@RestController
@RequestMapping("/api")
public class EmEmpNotesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpNotesResource.class);

    private static final String ENTITY_NAME = "emEmpNotes";

    private final EmEmpNotesRepository emEmpNotesRepository;

    private final EmEmpNotesMapper emEmpNotesMapper;

    public EmEmpNotesResource(EmEmpNotesRepository emEmpNotesRepository, EmEmpNotesMapper emEmpNotesMapper) {
        this.emEmpNotesRepository = emEmpNotesRepository;
        this.emEmpNotesMapper = emEmpNotesMapper;
    }

    /**
     * POST  /em-emp-notes : Create a new emEmpNotes.
     *
     * @param emEmpNotesDTO the emEmpNotesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpNotesDTO, or with status 400 (Bad Request) if the emEmpNotes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-notes")
    @Timed
    public ResponseEntity<EmEmpNotesDTO> createEmEmpNotes(@Valid @RequestBody EmEmpNotesDTO emEmpNotesDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpNotes : {}", emEmpNotesDTO);
        if (emEmpNotesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpNotes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpNotes emEmpNotes = emEmpNotesMapper.toEntity(emEmpNotesDTO);
        emEmpNotes = emEmpNotesRepository.save(emEmpNotes);
        EmEmpNotesDTO result = emEmpNotesMapper.toDto(emEmpNotes);
        return ResponseEntity.created(new URI("/api/em-emp-notes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-notes : Updates an existing emEmpNotes.
     *
     * @param emEmpNotesDTO the emEmpNotesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpNotesDTO,
     * or with status 400 (Bad Request) if the emEmpNotesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpNotesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-notes")
    @Timed
    public ResponseEntity<EmEmpNotesDTO> updateEmEmpNotes(@Valid @RequestBody EmEmpNotesDTO emEmpNotesDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpNotes : {}", emEmpNotesDTO);
        if (emEmpNotesDTO.getId() == null) {
            return createEmEmpNotes(emEmpNotesDTO);
        }
        EmEmpNotes emEmpNotes = emEmpNotesMapper.toEntity(emEmpNotesDTO);
        emEmpNotes = emEmpNotesRepository.save(emEmpNotes);
        EmEmpNotesDTO result = emEmpNotesMapper.toDto(emEmpNotes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpNotesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-notes : get all the emEmpNotes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpNotes in body
     */
    @GetMapping("/em-emp-notes")
    @Timed
    public ResponseEntity<List<EmEmpNotesDTO>> getAllEmEmpNotes(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpNotes");
        Page<EmEmpNotes> page = emEmpNotesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-notes");
        return new ResponseEntity<>(emEmpNotesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-notes/:id : get the "id" emEmpNotes.
     *
     * @param id the id of the emEmpNotesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpNotesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-notes/{id}")
    @Timed
    public ResponseEntity<EmEmpNotesDTO> getEmEmpNotes(@PathVariable Long id) {
        log.debug("REST request to get EmEmpNotes : {}", id);
        EmEmpNotes emEmpNotes = emEmpNotesRepository.findOne(id);
        EmEmpNotesDTO emEmpNotesDTO = emEmpNotesMapper.toDto(emEmpNotes);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpNotesDTO));
    }

    /**
     * DELETE  /em-emp-notes/:id : delete the "id" emEmpNotes.
     *
     * @param id the id of the emEmpNotesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-notes/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpNotes(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpNotes : {}", id);
        emEmpNotesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
