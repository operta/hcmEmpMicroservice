package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.Action;
import com.infostudio.ba.domain.EmEmpContacts;
import com.infostudio.ba.domain.EmEmpEmgContacts;

import com.infostudio.ba.repository.EmEmpEmgContactsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.AuditUtil;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpEmgContactsDTO;
import com.infostudio.ba.service.mapper.EmEmpEmgContactsMapper;
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
 * REST controller for managing EmEmpEmgContacts.
 */
@RestController
@RequestMapping("/api")
public class EmEmpEmgContactsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpEmgContactsResource.class);

    private static final String ENTITY_NAME = "emEmpEmgContacts";

    private final EmEmpEmgContactsRepository emEmpEmgContactsRepository;

    private final EmEmpEmgContactsMapper emEmpEmgContactsMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmpEmgContactsResource(EmEmpEmgContactsRepository emEmpEmgContactsRepository,
                                    EmEmpEmgContactsMapper emEmpEmgContactsMapper,
                                    ApplicationEventPublisher applicationEventPublisher) {
        this.emEmpEmgContactsRepository = emEmpEmgContactsRepository;
        this.emEmpEmgContactsMapper = emEmpEmgContactsMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * POST  /em-emp-emg-contacts : Create a new emEmpEmgContacts.
     *
     * @param emEmpEmgContactsDTO the emEmpEmgContactsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpEmgContactsDTO, or with status 400 (Bad Request) if the emEmpEmgContacts has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-emg-contacts")
    @Timed
    public ResponseEntity<EmEmpEmgContactsDTO> createEmEmpEmgContacts(@RequestBody EmEmpEmgContactsDTO emEmpEmgContactsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpEmgContacts : {}", emEmpEmgContactsDTO);
        if (emEmpEmgContactsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpEmgContacts cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpEmgContacts emEmpEmgContacts = emEmpEmgContactsMapper.toEntity(emEmpEmgContactsDTO);
        emEmpEmgContacts = emEmpEmgContactsRepository.save(emEmpEmgContacts);
        EmEmpEmgContactsDTO result = emEmpEmgContactsMapper.toDto(emEmpEmgContacts);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.POST
                )
        );
        return ResponseEntity.created(new URI("/api/em-emp-emg-contacts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-emg-contacts : Updates an existing emEmpEmgContacts.
     *
     * @param emEmpEmgContactsDTO the emEmpEmgContactsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpEmgContactsDTO,
     * or with status 400 (Bad Request) if the emEmpEmgContactsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpEmgContactsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-emg-contacts")
    @Timed
    public ResponseEntity<EmEmpEmgContactsDTO> updateEmEmpEmgContacts(@RequestBody EmEmpEmgContactsDTO emEmpEmgContactsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpEmgContacts : {}", emEmpEmgContactsDTO);
        if (emEmpEmgContactsDTO.getId() == null) {
            return createEmEmpEmgContacts(emEmpEmgContactsDTO);
        }
        EmEmpEmgContacts emEmpEmgContacts = emEmpEmgContactsMapper.toEntity(emEmpEmgContactsDTO);
        emEmpEmgContacts = emEmpEmgContactsRepository.save(emEmpEmgContacts);
        EmEmpEmgContactsDTO result = emEmpEmgContactsMapper.toDto(emEmpEmgContacts);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.PUT
                )
        );
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpEmgContactsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-emg-contacts : get all the emEmpEmgContacts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpEmgContacts in body
     */
    @GetMapping("/em-emp-emg-contacts")
    @Timed
    public ResponseEntity<List<EmEmpEmgContactsDTO>> getAllEmEmpEmgContacts(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpEmgContacts");
        Page<EmEmpEmgContacts> page = emEmpEmgContactsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-emg-contacts");
        return new ResponseEntity<>(emEmpEmgContactsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-emg-contacts/:id : get the "id" emEmpEmgContacts.
     *
     * @param id the id of the emEmpEmgContactsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpEmgContactsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-emg-contacts/{id}")
    @Timed
    public ResponseEntity<EmEmpEmgContactsDTO> getEmEmpEmgContacts(@PathVariable Long id) {
        log.debug("REST request to get EmEmpEmgContacts : {}", id);
        EmEmpEmgContacts emEmpEmgContacts = emEmpEmgContactsRepository.findOne(id);
        EmEmpEmgContactsDTO emEmpEmgContactsDTO = emEmpEmgContactsMapper.toDto(emEmpEmgContacts);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpEmgContactsDTO));
    }

    @GetMapping("/em-emp-emg-contacts/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpEmgContactsDTO>> getEmEmpEmgContactsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpEmgContacts : {}", id);
        List<EmEmpEmgContacts> emEmpEmgContacts = emEmpEmgContactsRepository.findByIdEmployeeId(id);
        List<EmEmpEmgContactsDTO> emEmpEmgContactsDTO = emEmpEmgContactsMapper.toDto(emEmpEmgContacts);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpEmgContactsDTO));
    }

    /**
     * DELETE  /em-emp-emg-contacts/:id : delete the "id" emEmpEmgContacts.
     *
     * @param id the id of the emEmpEmgContactsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-emg-contacts/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpEmgContacts(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpEmgContacts : {}", id);
        EmEmpEmgContacts contact = emEmpEmgContactsRepository.findOne(id);
        emEmpEmgContactsRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        contact.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        contact.getId().toString(),
                        Action.DELETE
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
