package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmPenalties;

import com.infostudio.ba.repository.EmPenaltiesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmPenaltiesDTO;
import com.infostudio.ba.service.mapper.EmPenaltiesMapper;
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
 * REST controller for managing EmPenalties.
 */
@RestController
@RequestMapping("/api")
public class EmPenaltiesResource {

    private final Logger log = LoggerFactory.getLogger(EmPenaltiesResource.class);

    private static final String ENTITY_NAME = "emPenalties";

    private final EmPenaltiesRepository emPenaltiesRepository;

    private final EmPenaltiesMapper emPenaltiesMapper;

    public EmPenaltiesResource(EmPenaltiesRepository emPenaltiesRepository, EmPenaltiesMapper emPenaltiesMapper) {
        this.emPenaltiesRepository = emPenaltiesRepository;
        this.emPenaltiesMapper = emPenaltiesMapper;
    }

    /**
     * POST  /em-penalties : Create a new emPenalties.
     *
     * @param emPenaltiesDTO the emPenaltiesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emPenaltiesDTO, or with status 400 (Bad Request) if the emPenalties has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-penalties")
    @Timed
    public ResponseEntity<EmPenaltiesDTO> createEmPenalties(@RequestBody EmPenaltiesDTO emPenaltiesDTO) throws URISyntaxException {
        log.debug("REST request to save EmPenalties : {}", emPenaltiesDTO);
        if (emPenaltiesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emPenalties cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmPenalties emPenalties = emPenaltiesMapper.toEntity(emPenaltiesDTO);
        emPenalties = emPenaltiesRepository.save(emPenalties);
        EmPenaltiesDTO result = emPenaltiesMapper.toDto(emPenalties);
        return ResponseEntity.created(new URI("/api/em-penalties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-penalties : Updates an existing emPenalties.
     *
     * @param emPenaltiesDTO the emPenaltiesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emPenaltiesDTO,
     * or with status 400 (Bad Request) if the emPenaltiesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emPenaltiesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-penalties")
    @Timed
    public ResponseEntity<EmPenaltiesDTO> updateEmPenalties(@RequestBody EmPenaltiesDTO emPenaltiesDTO) throws URISyntaxException {
        log.debug("REST request to update EmPenalties : {}", emPenaltiesDTO);
        if (emPenaltiesDTO.getId() == null) {
            return createEmPenalties(emPenaltiesDTO);
        }
        EmPenalties emPenalties = emPenaltiesMapper.toEntity(emPenaltiesDTO);
        emPenalties = emPenaltiesRepository.save(emPenalties);
        EmPenaltiesDTO result = emPenaltiesMapper.toDto(emPenalties);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emPenaltiesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-penalties : get all the emPenalties.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emPenalties in body
     */
    @GetMapping("/em-penalties")
    @Timed
    public ResponseEntity<List<EmPenaltiesDTO>> getAllEmPenalties(Pageable pageable) {
        log.debug("REST request to get a page of EmPenalties");
        Page<EmPenalties> page = emPenaltiesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-penalties");
        return new ResponseEntity<>(emPenaltiesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-penalties/:id : get the "id" emPenalties.
     *
     * @param id the id of the emPenaltiesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emPenaltiesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-penalties/{id}")
    @Timed
    public ResponseEntity<EmPenaltiesDTO> getEmPenalties(@PathVariable Long id) {
        log.debug("REST request to get EmPenalties : {}", id);
        EmPenalties emPenalties = emPenaltiesRepository.findOne(id);
        EmPenaltiesDTO emPenaltiesDTO = emPenaltiesMapper.toDto(emPenalties);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emPenaltiesDTO));
    }

    @GetMapping("/em-penalties/employee/{id}")
    @Timed
    public ResponseEntity<List<EmPenaltiesDTO>> getEmPenaltiesByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmPenalties by Employee Id: {}", id);
        List<EmPenalties> emPenalties = emPenaltiesRepository.findByIdEmployeeId(id);
        List<EmPenaltiesDTO> emPenaltiesDTO = emPenaltiesMapper.toDto(emPenalties);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emPenaltiesDTO));
    }

    /**
     * DELETE  /em-penalties/:id : delete the "id" emPenalties.
     *
     * @param id the id of the emPenaltiesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-penalties/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmPenalties(@PathVariable Long id) {
        log.debug("REST request to delete EmPenalties : {}", id);
        emPenaltiesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
