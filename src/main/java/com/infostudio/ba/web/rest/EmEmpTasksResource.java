package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpTasks;
import com.infostudio.ba.repository.EmEmpTasksRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.AuditUtil;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.service.dto.EmEmpTasksDTO;
import com.infostudio.ba.service.mapper.EmEmpTasksMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EmEmpTasks.
 */
@RestController
@RequestMapping("/api")
public class EmEmpTasksResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpTasksResource.class);

    private static final String ENTITY_NAME = "emEmpTasks";

    private final EmEmpTasksRepository emEmpTasksRepository;

    private final EmEmpTasksMapper emEmpTasksMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmpTasksResource(EmEmpTasksRepository emEmpTasksRepository, EmEmpTasksMapper emEmpTasksMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.emEmpTasksRepository = emEmpTasksRepository;
        this.emEmpTasksMapper = emEmpTasksMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * POST  /em-emp-tasks : Create a new emEmpTasks.
     *
     * @param emEmpTasksDTO the emEmpTasksDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpTasksDTO, or with status 400 (Bad Request) if the emEmpTasks has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-tasks")
    @Timed
    public ResponseEntity<EmEmpTasksDTO> createEmEmpTasks(@Valid @RequestBody EmEmpTasksDTO emEmpTasksDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpTasks : {}", emEmpTasksDTO);
        if (emEmpTasksDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpTasks cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpTasks emEmpTasks = emEmpTasksMapper.toEntity(emEmpTasksDTO);
        emEmpTasks = emEmpTasksRepository.save(emEmpTasks);
        EmEmpTasksDTO result = emEmpTasksMapper.toDto(emEmpTasks);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        emEmpTasks.getIdEmployee().toString(),
                        HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()).toString()
                )
        );
        return ResponseEntity.created(new URI("/api/em-emp-tasks/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * PUT  /em-emp-tasks : Updates an existing emEmpTasks.
     *
     * @param emEmpTasksDTO the emEmpTasksDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpTasksDTO,
     * or with status 400 (Bad Request) if the emEmpTasksDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpTasksDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-tasks")
    @Timed
    public ResponseEntity<EmEmpTasksDTO> updateEmEmpTasks(@Valid @RequestBody EmEmpTasksDTO emEmpTasksDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpTasks : {}", emEmpTasksDTO);
        if (emEmpTasksDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EmEmpTasks emEmpTasks = emEmpTasksMapper.toEntity(emEmpTasksDTO);
        emEmpTasks = emEmpTasksRepository.save(emEmpTasks);
        EmEmpTasksDTO result = emEmpTasksMapper.toDto(emEmpTasks);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        emEmpTasks.getIdEmployee().toString(),
                        HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getId().toString()).toString()
                )
        );
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpTasksDTO.getId().toString()))
                .body(result);
    }

    /**
     * GET  /em-emp-tasks : get all the emEmpTasks.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpTasks in body
     */
    @GetMapping("/em-emp-tasks")
    @Timed
    public List<EmEmpTasksDTO> getAllEmEmpTasks() {
        log.debug("REST request to get all EmEmpTasks");
        List<EmEmpTasks> emEmpTasks = emEmpTasksRepository.findAll();
        return emEmpTasksMapper.toDto(emEmpTasks);
    }

    /**
     * GET  /em-emp-tasks/:id : get the "id" emEmpTasks.
     *
     * @param id the id of the emEmpTasksDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpTasksDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-tasks/{id}")
    @Timed
    public ResponseEntity<EmEmpTasksDTO> getEmEmpTasks(@PathVariable Long id) {
        log.debug("REST request to get EmEmpTasks : {}", id);
        EmEmpTasksDTO emEmpTasksDTO = emEmpTasksMapper.toDto(emEmpTasksRepository.findOne(id));
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpTasksDTO));
    }

    @GetMapping("/em-emp-tasks/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpTasksDTO>> getEmEmpTasksByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpTasks by Employee Id : {}", id);
        List<EmEmpTasksDTO> emEmpTasksDTO = emEmpTasksMapper.toDto(emEmpTasksRepository.findByIdEmployee(id.intValue()));
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpTasksDTO));
    }

    /**
     * DELETE  /em-emp-tasks/:id : delete the "id" emEmpTasks.
     *
     * @param id the id of the emEmpTasksDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-tasks/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpTasks(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpTasks : {}", id);
        EmEmpTasks emEmpTasks = emEmpTasksRepository.findOne(id);
        emEmpTasksRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        emEmpTasks.getIdEmployee().toString(),
                        HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString()).toString()
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
