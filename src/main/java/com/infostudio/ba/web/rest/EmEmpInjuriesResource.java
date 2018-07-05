package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpInjuries;

import com.infostudio.ba.repository.EmEmpInjuriesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpInjuriesDTO;
import com.infostudio.ba.service.mapper.EmEmpInjuriesMapper;
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
 * REST controller for managing EmEmpInjuries.
 */
@RestController
@RequestMapping("/api")
public class EmEmpInjuriesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpInjuriesResource.class);

    private static final String ENTITY_NAME = "emEmpInjuries";

    private final EmEmpInjuriesRepository emEmpInjuriesRepository;

    private final EmEmpInjuriesMapper emEmpInjuriesMapper;

    public EmEmpInjuriesResource(EmEmpInjuriesRepository emEmpInjuriesRepository, EmEmpInjuriesMapper emEmpInjuriesMapper) {
        this.emEmpInjuriesRepository = emEmpInjuriesRepository;
        this.emEmpInjuriesMapper = emEmpInjuriesMapper;
    }

    /**
     * POST  /em-emp-injuries : Create a new emEmpInjuries.
     *
     * @param emEmpInjuriesDTO the emEmpInjuriesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpInjuriesDTO, or with status 400 (Bad Request) if the emEmpInjuries has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-injuries")
    @Timed
    public ResponseEntity<EmEmpInjuriesDTO> createEmEmpInjuries(@RequestBody EmEmpInjuriesDTO emEmpInjuriesDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpInjuries : {}", emEmpInjuriesDTO);
        if (emEmpInjuriesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpInjuries cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpInjuries emEmpInjuries = emEmpInjuriesMapper.toEntity(emEmpInjuriesDTO);
        emEmpInjuries = emEmpInjuriesRepository.save(emEmpInjuries);
        EmEmpInjuriesDTO result = emEmpInjuriesMapper.toDto(emEmpInjuries);
        return ResponseEntity.created(new URI("/api/em-emp-injuries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-injuries : Updates an existing emEmpInjuries.
     *
     * @param emEmpInjuriesDTO the emEmpInjuriesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpInjuriesDTO,
     * or with status 400 (Bad Request) if the emEmpInjuriesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpInjuriesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-injuries")
    @Timed
    public ResponseEntity<EmEmpInjuriesDTO> updateEmEmpInjuries(@RequestBody EmEmpInjuriesDTO emEmpInjuriesDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpInjuries : {}", emEmpInjuriesDTO);
        if (emEmpInjuriesDTO.getId() == null) {
            return createEmEmpInjuries(emEmpInjuriesDTO);
        }
        EmEmpInjuries emEmpInjuries = emEmpInjuriesMapper.toEntity(emEmpInjuriesDTO);
        emEmpInjuries = emEmpInjuriesRepository.save(emEmpInjuries);
        EmEmpInjuriesDTO result = emEmpInjuriesMapper.toDto(emEmpInjuries);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpInjuriesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-injuries : get all the emEmpInjuries.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpInjuries in body
     */
    @GetMapping("/em-emp-injuries")
    @Timed
    public ResponseEntity<List<EmEmpInjuriesDTO>> getAllEmEmpInjuries(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpInjuries");
        Page<EmEmpInjuries> page = emEmpInjuriesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-injuries");
        return new ResponseEntity<>(emEmpInjuriesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-injuries/:id : get the "id" emEmpInjuries.
     *
     * @param id the id of the emEmpInjuriesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpInjuriesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-injuries/{id}")
    @Timed
    public ResponseEntity<EmEmpInjuriesDTO> getEmEmpInjuries(@PathVariable Long id) {
        log.debug("REST request to get EmEmpInjuries : {}", id);
        EmEmpInjuries emEmpInjuries = emEmpInjuriesRepository.findOne(id);
        EmEmpInjuriesDTO emEmpInjuriesDTO = emEmpInjuriesMapper.toDto(emEmpInjuries);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpInjuriesDTO));
    }

    /**
     * GET  /em-emp-injuries/:id
     *
     * @param id
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpInjuriesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-injuries/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpInjuriesDTO>> getEmEmpInjuriesByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpInjuries by Employee : {}", id);
        List<EmEmpInjuries> emEmpInjuries = emEmpInjuriesRepository.findByIdEmployeeId(id);
        List<EmEmpInjuriesDTO> emEmpInjuriesDTO = emEmpInjuriesMapper.toDto(emEmpInjuries);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpInjuriesDTO));
    }

    /**
     * DELETE  /em-emp-injuries/:id : delete the "id" emEmpInjuries.
     *
     * @param id the id of the emEmpInjuriesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-injuries/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpInjuries(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpInjuries : {}", id);
        emEmpInjuriesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
