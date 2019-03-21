package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.Action;
import com.infostudio.ba.domain.EmEmpSchools;

import com.infostudio.ba.repository.EmEmpSchoolsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.AuditUtil;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpSchoolsDTO;
import com.infostudio.ba.service.mapper.EmEmpSchoolsMapper;
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

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EmEmpSchools.
 */
@RestController
@RequestMapping("/api")
public class EmEmpSchoolsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpSchoolsResource.class);

    private static final String ENTITY_NAME = "emEmpSchools";

    private final EmEmpSchoolsRepository emEmpSchoolsRepository;

    private final EmEmpSchoolsMapper emEmpSchoolsMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmpSchoolsResource(EmEmpSchoolsRepository emEmpSchoolsRepository,
                                EmEmpSchoolsMapper emEmpSchoolsMapper,
                                ApplicationEventPublisher applicationEventPublisher) {
        this.emEmpSchoolsRepository = emEmpSchoolsRepository;
        this.emEmpSchoolsMapper = emEmpSchoolsMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * POST  /em-emp-schools : Create a new emEmpSchools.
     *
     * @param emEmpSchoolsDTO the emEmpSchoolsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpSchoolsDTO, or with status 400 (Bad Request) if the emEmpSchools has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-schools")
    @Timed
    public ResponseEntity<EmEmpSchoolsDTO> createEmEmpSchools(@RequestBody EmEmpSchoolsDTO emEmpSchoolsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpSchools : {}", emEmpSchoolsDTO);
        if (emEmpSchoolsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpSchools cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpSchools emEmpSchools = emEmpSchoolsMapper.toEntity(emEmpSchoolsDTO);
        emEmpSchools = emEmpSchoolsRepository.save(emEmpSchools);
        EmEmpSchoolsDTO result = emEmpSchoolsMapper.toDto(emEmpSchools);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.POST
                )
        );
        return ResponseEntity.created(new URI("/api/em-emp-schools/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-schools : Updates an existing emEmpSchools.
     *
     * @param emEmpSchoolsDTO the emEmpSchoolsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpSchoolsDTO,
     * or with status 400 (Bad Request) if the emEmpSchoolsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpSchoolsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-schools")
    @Timed
    public ResponseEntity<EmEmpSchoolsDTO> updateEmEmpSchools(@RequestBody EmEmpSchoolsDTO emEmpSchoolsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpSchools : {}", emEmpSchoolsDTO);
        if (emEmpSchoolsDTO.getId() == null) {
            return createEmEmpSchools(emEmpSchoolsDTO);
        }
        EmEmpSchools emEmpSchools = emEmpSchoolsMapper.toEntity(emEmpSchoolsDTO);
        emEmpSchools = emEmpSchoolsRepository.save(emEmpSchools);
        EmEmpSchoolsDTO result = emEmpSchoolsMapper.toDto(emEmpSchools);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.PUT
                )
        );
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpSchoolsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-schools : get all the emEmpSchools.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpSchools in body
     */
    @GetMapping("/em-emp-schools")
    @Timed
    public ResponseEntity<List<EmEmpSchoolsDTO>> getAllEmEmpSchools(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpSchools");
        Page<EmEmpSchools> page = emEmpSchoolsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-schools");
        return new ResponseEntity<>(emEmpSchoolsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-schools/:id : get the "id" emEmpSchools.
     *
     * @param id the id of the emEmpSchoolsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpSchoolsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-schools/{id}")
    @Timed
    public ResponseEntity<EmEmpSchoolsDTO> getEmEmpSchools(@PathVariable Long id) {
        log.debug("REST request to get EmEmpSchools : {}", id);
        EmEmpSchools emEmpSchools = emEmpSchoolsRepository.findOne(id);
        EmEmpSchoolsDTO emEmpSchoolsDTO = emEmpSchoolsMapper.toDto(emEmpSchools);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpSchoolsDTO));
    }

    @GetMapping("/em-emp-schools/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpSchoolsDTO>> getEmEmpSchoolsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpSchools by Employee Id: {}", id);
        List<EmEmpSchools> emEmpSchools = emEmpSchoolsRepository.findByIdEmployeeId(id);
        List<EmEmpSchoolsDTO> emEmpSchoolsDTO = emEmpSchoolsMapper.toDto(emEmpSchools);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpSchoolsDTO));
    }

    /**
     * DELETE  /em-emp-schools/:id : delete the "id" emEmpSchools.
     *
     * @param id the id of the emEmpSchoolsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-schools/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpSchools(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpSchools : {}", id);
        EmEmpSchools school = emEmpSchoolsRepository.findOne(id);
        emEmpSchoolsRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        school.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        school.getId().toString(),
                        Action.DELETE
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
