package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.Action;
import com.infostudio.ba.domain.EmEmpBorrowings;

import com.infostudio.ba.repository.EmEmpBorrowingsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.AuditUtil;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpBorrowingsDTO;
import com.infostudio.ba.service.mapper.EmEmpBorrowingsMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
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
 * REST controller for managing EmEmpBorrowings.
 */
@RestController
@RequestMapping("/api")
public class EmEmpBorrowingsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpBorrowingsResource.class);

    private static final String ENTITY_NAME = "emEmpBorrowings";

    private final EmEmpBorrowingsRepository emEmpBorrowingsRepository;

    private final EmEmpBorrowingsMapper emEmpBorrowingsMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmpBorrowingsResource(EmEmpBorrowingsRepository emEmpBorrowingsRepository,
                                   EmEmpBorrowingsMapper emEmpBorrowingsMapper,
                                   ApplicationEventPublisher applicationEventPublisher) {
        this.emEmpBorrowingsRepository = emEmpBorrowingsRepository;
        this.emEmpBorrowingsMapper = emEmpBorrowingsMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * POST  /em-emp-borrowings : Create a new emEmpBorrowings.
     *
     * @param emEmpBorrowingsDTO the emEmpBorrowingsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpBorrowingsDTO, or with status 400 (Bad Request) if the emEmpBorrowings has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-borrowings")
    @Timed
    public ResponseEntity<EmEmpBorrowingsDTO> createEmEmpBorrowings(@Valid @RequestBody EmEmpBorrowingsDTO emEmpBorrowingsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpBorrowings : {}", emEmpBorrowingsDTO);
        if (emEmpBorrowingsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpBorrowings cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpBorrowings emEmpBorrowings = emEmpBorrowingsMapper.toEntity(emEmpBorrowingsDTO);
        emEmpBorrowings = emEmpBorrowingsRepository.save(emEmpBorrowings);
        EmEmpBorrowingsDTO result = emEmpBorrowingsMapper.toDto(emEmpBorrowings);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.POST
                )
        );
        return ResponseEntity.created(new URI("/api/em-emp-borrowings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-borrowings : Updates an existing emEmpBorrowings.
     *
     * @param emEmpBorrowingsDTO the emEmpBorrowingsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpBorrowingsDTO,
     * or with status 400 (Bad Request) if the emEmpBorrowingsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpBorrowingsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-borrowings")
    @Timed
    public ResponseEntity<EmEmpBorrowingsDTO> updateEmEmpBorrowings(@Valid @RequestBody EmEmpBorrowingsDTO emEmpBorrowingsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpBorrowings : {}", emEmpBorrowingsDTO);
        if (emEmpBorrowingsDTO.getId() == null) {
            return createEmEmpBorrowings(emEmpBorrowingsDTO);
        }
        EmEmpBorrowings emEmpBorrowings = emEmpBorrowingsMapper.toEntity(emEmpBorrowingsDTO);
        emEmpBorrowings = emEmpBorrowingsRepository.save(emEmpBorrowings);
        EmEmpBorrowingsDTO result = emEmpBorrowingsMapper.toDto(emEmpBorrowings);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.PUT
                )
        );
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpBorrowingsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-borrowings : get all the emEmpBorrowings.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpBorrowings in body
     */
    @GetMapping("/em-emp-borrowings")
    @Timed
    public ResponseEntity<List<EmEmpBorrowingsDTO>> getAllEmEmpBorrowings(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpBorrowings");
        Page<EmEmpBorrowings> page = emEmpBorrowingsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-borrowings");
        return new ResponseEntity<>(emEmpBorrowingsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-borrowings/:id : get the "id" emEmpBorrowings.
     *
     * @param id the id of the emEmpBorrowingsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpBorrowingsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-borrowings/{id}")
    @Timed
    public ResponseEntity<EmEmpBorrowingsDTO> getEmEmpBorrowings(@PathVariable Long id) {
        log.debug("REST request to get EmEmpBorrowings : {}", id);
        EmEmpBorrowings emEmpBorrowings = emEmpBorrowingsRepository.findOne(id);
        EmEmpBorrowingsDTO emEmpBorrowingsDTO = emEmpBorrowingsMapper.toDto(emEmpBorrowings);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpBorrowingsDTO));
    }

    /**
     * GET  /em-emp-borrowings/employee/:id.
     *
     * @param id
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpBorrowingsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-borrowings/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpBorrowingsDTO>> getEmEmpBorrowingsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpBorrowings by Employee Id : {}", id);
        List<EmEmpBorrowings> emEmpBorrowings = emEmpBorrowingsRepository.findByIdEmployeeId(id);
        List<EmEmpBorrowingsDTO> emEmpBorrowingsDTO = emEmpBorrowingsMapper.toDto(emEmpBorrowings);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpBorrowingsDTO));
    }

    /**
     * DELETE  /em-emp-borrowings/:id : delete the "id" emEmpBorrowings.
     *
     * @param id the id of the emEmpBorrowingsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-borrowings/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpBorrowings(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpBorrowings : {}", id);
        EmEmpBorrowings borrowing = emEmpBorrowingsRepository.findOne(id);
        emEmpBorrowingsRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        borrowing.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        borrowing.getId().toString(),
                        Action.DELETE
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
