package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.Action;
import com.infostudio.ba.domain.EmEmpSalaries;

import com.infostudio.ba.repository.EmEmpSalariesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.AuditUtil;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpSalariesDTO;
import com.infostudio.ba.service.mapper.EmEmpSalariesMapper;
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

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EmEmpSalaries.
 */
@RestController
@RequestMapping("/api")
public class EmEmpSalariesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpSalariesResource.class);

    private static final String ENTITY_NAME = "emEmpSalaries";

    private final EmEmpSalariesRepository emEmpSalariesRepository;

    private final EmEmpSalariesMapper emEmpSalariesMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmpSalariesResource(EmEmpSalariesRepository emEmpSalariesRepository,
                                 EmEmpSalariesMapper emEmpSalariesMapper,
                                 ApplicationEventPublisher applicationEventPublisher) {
        this.emEmpSalariesRepository = emEmpSalariesRepository;
        this.emEmpSalariesMapper = emEmpSalariesMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * POST  /em-emp-salaries : Create a new emEmpSalaries.
     *
     * @param emEmpSalariesDTO the emEmpSalariesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpSalariesDTO, or with status 400 (Bad Request) if the emEmpSalaries has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-salaries")
    @Timed
    public ResponseEntity<EmEmpSalariesDTO> createEmEmpSalaries(@Valid @RequestBody EmEmpSalariesDTO emEmpSalariesDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpSalaries : {}", emEmpSalariesDTO);
        if (emEmpSalariesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpSalaries cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpSalaries emEmpSalaries = emEmpSalariesMapper.toEntity(emEmpSalariesDTO);
        emEmpSalaries = emEmpSalariesRepository.save(emEmpSalaries);
        EmEmpSalariesDTO result = emEmpSalariesMapper.toDto(emEmpSalaries);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.POST
                )
        );
        return ResponseEntity.created(new URI("/api/em-emp-salaries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-salaries : Updates an existing emEmpSalaries.
     *
     * @param emEmpSalariesDTO the emEmpSalariesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpSalariesDTO,
     * or with status 400 (Bad Request) if the emEmpSalariesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpSalariesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-salaries")
    @Timed
    public ResponseEntity<EmEmpSalariesDTO> updateEmEmpSalaries(@Valid @RequestBody EmEmpSalariesDTO emEmpSalariesDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpSalaries : {}", emEmpSalariesDTO);
        if (emEmpSalariesDTO.getId() == null) {
            return createEmEmpSalaries(emEmpSalariesDTO);
        }
        EmEmpSalaries emEmpSalaries = emEmpSalariesMapper.toEntity(emEmpSalariesDTO);
        emEmpSalaries = emEmpSalariesRepository.save(emEmpSalaries);
        EmEmpSalariesDTO result = emEmpSalariesMapper.toDto(emEmpSalaries);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.PUT
                )
        );
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpSalariesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-salaries : get all the emEmpSalaries.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpSalaries in body
     */
    @GetMapping("/em-emp-salaries")
    @Timed
    public ResponseEntity<List<EmEmpSalariesDTO>> getAllEmEmpSalaries(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpSalaries");
        Page<EmEmpSalaries> page = emEmpSalariesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-salaries");
        return new ResponseEntity<>(emEmpSalariesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-salaries/:id : get the "id" emEmpSalaries.
     *
     * @param id the id of the emEmpSalariesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpSalariesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-salaries/{id}")
    @Timed
    public ResponseEntity<EmEmpSalariesDTO> getEmEmpSalaries(@PathVariable Long id) {
        log.debug("REST request to get EmEmpSalaries : {}", id);
        EmEmpSalaries emEmpSalaries = emEmpSalariesRepository.findOne(id);
        EmEmpSalariesDTO emEmpSalariesDTO = emEmpSalariesMapper.toDto(emEmpSalaries);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpSalariesDTO));
    }

    @GetMapping("/em-emp-salaries/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpSalariesDTO>> getEmEmpSalariesByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpSalaries by Employee Id : {}", id);
        List<EmEmpSalaries> emEmpSalaries = emEmpSalariesRepository.findByIdEmployeeId(id);
        List<EmEmpSalariesDTO> emEmpSalariesDTO = emEmpSalariesMapper.toDto(emEmpSalaries);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpSalariesDTO));
    }

    @GetMapping("/em-emp-salaries/last-salary/employee/{id}")
    @Timed
    public ResponseEntity<EmEmpSalariesDTO> getLastEmEmpSalaryForEmpId(@PathVariable Long id){
        log.debug("REST request to get last EmEmpSalaries by Employee Id: {}", id);
        ResponseEntity<List<EmEmpSalariesDTO>> empSalaryResponse = getEmEmpSalariesByEmpId(id);
        if(empSalaryResponse.getStatusCode() == HttpStatus.NOT_FOUND){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EmEmpSalariesDTO lastSalaryForEmp = empSalaryResponse.getBody()
                .stream()
                .max(Comparator.comparing(EmEmpSalariesDTO::getDateFrom))
                .orElse(null);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(lastSalaryForEmp));
    }

    /**
     * DELETE  /em-emp-salaries/:id : delete the "id" emEmpSalaries.
     *
     * @param id the id of the emEmpSalariesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-salaries/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpSalaries(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpSalaries : {}", id);
        EmEmpSalaries salary = emEmpSalariesRepository.findOne(id);
        emEmpSalariesRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        salary.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        salary.getId().toString(),
                        Action.DELETE
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
