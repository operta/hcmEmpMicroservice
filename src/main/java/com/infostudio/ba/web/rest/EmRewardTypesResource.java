package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmRewardTypes;

import com.infostudio.ba.repository.EmRewardTypesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmRewardTypesDTO;
import com.infostudio.ba.service.mapper.EmRewardTypesMapper;
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
 * REST controller for managing EmRewardTypes.
 */
@RestController
@RequestMapping("/api")
public class EmRewardTypesResource {

    private final Logger log = LoggerFactory.getLogger(EmRewardTypesResource.class);

    private static final String ENTITY_NAME = "emRewardTypes";

    private final EmRewardTypesRepository emRewardTypesRepository;

    private final EmRewardTypesMapper emRewardTypesMapper;

    public EmRewardTypesResource(EmRewardTypesRepository emRewardTypesRepository, EmRewardTypesMapper emRewardTypesMapper) {
        this.emRewardTypesRepository = emRewardTypesRepository;
        this.emRewardTypesMapper = emRewardTypesMapper;
    }

    /**
     * POST  /em-reward-types : Create a new emRewardTypes.
     *
     * @param emRewardTypesDTO the emRewardTypesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emRewardTypesDTO, or with status 400 (Bad Request) if the emRewardTypes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-reward-types")
    @Timed
    public ResponseEntity<EmRewardTypesDTO> createEmRewardTypes(@Valid @RequestBody EmRewardTypesDTO emRewardTypesDTO) throws URISyntaxException {
        log.debug("REST request to save EmRewardTypes : {}", emRewardTypesDTO);
        if (emRewardTypesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emRewardTypes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmRewardTypes emRewardTypes = emRewardTypesMapper.toEntity(emRewardTypesDTO);
        emRewardTypes = emRewardTypesRepository.save(emRewardTypes);
        EmRewardTypesDTO result = emRewardTypesMapper.toDto(emRewardTypes);
        return ResponseEntity.created(new URI("/api/em-reward-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-reward-types : Updates an existing emRewardTypes.
     *
     * @param emRewardTypesDTO the emRewardTypesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emRewardTypesDTO,
     * or with status 400 (Bad Request) if the emRewardTypesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emRewardTypesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-reward-types")
    @Timed
    public ResponseEntity<EmRewardTypesDTO> updateEmRewardTypes(@Valid @RequestBody EmRewardTypesDTO emRewardTypesDTO) throws URISyntaxException {
        log.debug("REST request to update EmRewardTypes : {}", emRewardTypesDTO);
        if (emRewardTypesDTO.getId() == null) {
            return createEmRewardTypes(emRewardTypesDTO);
        }
        EmRewardTypes emRewardTypes = emRewardTypesMapper.toEntity(emRewardTypesDTO);
        emRewardTypes = emRewardTypesRepository.save(emRewardTypes);
        EmRewardTypesDTO result = emRewardTypesMapper.toDto(emRewardTypes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emRewardTypesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-reward-types : get all the emRewardTypes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emRewardTypes in body
     */
    @GetMapping("/em-reward-types")
    @Timed
    public ResponseEntity<List<EmRewardTypesDTO>> getAllEmRewardTypes(Pageable pageable) {
        log.debug("REST request to get a page of EmRewardTypes");
        Page<EmRewardTypes> page = emRewardTypesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-reward-types");
        return new ResponseEntity<>(emRewardTypesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-reward-types/:id : get the "id" emRewardTypes.
     *
     * @param id the id of the emRewardTypesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emRewardTypesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-reward-types/{id}")
    @Timed
    public ResponseEntity<EmRewardTypesDTO> getEmRewardTypes(@PathVariable Long id) {
        log.debug("REST request to get EmRewardTypes : {}", id);
        EmRewardTypes emRewardTypes = emRewardTypesRepository.findOne(id);
        EmRewardTypesDTO emRewardTypesDTO = emRewardTypesMapper.toDto(emRewardTypes);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emRewardTypesDTO));
    }

    /**
     * DELETE  /em-reward-types/:id : delete the "id" emRewardTypes.
     *
     * @param id the id of the emRewardTypesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-reward-types/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmRewardTypes(@PathVariable Long id) {
        log.debug("REST request to delete EmRewardTypes : {}", id);
        emRewardTypesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
