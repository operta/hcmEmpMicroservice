package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.Action;
import com.infostudio.ba.domain.EmEmpSkills;

import com.infostudio.ba.repository.EmEmpSkillsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.AuditUtil;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpSkillsDTO;
import com.infostudio.ba.service.mapper.EmEmpSkillsMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.checkerframework.checker.units.qual.Time;
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
 * REST controller for managing EmEmpSkills.
 */
@RestController
@RequestMapping("/api")
public class EmEmpSkillsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpSkillsResource.class);

    private static final String ENTITY_NAME = "emEmpSkills";

    private final EmEmpSkillsRepository emEmpSkillsRepository;

    private final EmEmpSkillsMapper emEmpSkillsMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmpSkillsResource(EmEmpSkillsRepository emEmpSkillsRepository,
                               EmEmpSkillsMapper emEmpSkillsMapper,
                               ApplicationEventPublisher applicationEventPublisher) {
        this.emEmpSkillsRepository = emEmpSkillsRepository;
        this.emEmpSkillsMapper = emEmpSkillsMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostMapping("/em-emp-skills/list")
	@Timed
	public ResponseEntity<Void> createEmEmpSkillsFromList(@RequestBody List<EmEmpSkillsDTO> skills) throws URISyntaxException {
		for (EmEmpSkillsDTO skill : skills) {
			createEmEmpSkills(skill);
		}

		return ResponseEntity.created(new URI("/api/em-emp-skills"))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, null))
				.build();
	}

    /**
     * POST  /em-emp-skills : Create a new emEmpSkills.
     *
     * @param emEmpSkillsDTO the emEmpSkillsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpSkillsDTO, or with status 400 (Bad Request) if the emEmpSkills has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-skills")
    @Timed
    public ResponseEntity<EmEmpSkillsDTO> createEmEmpSkills(@RequestBody EmEmpSkillsDTO emEmpSkillsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpSkills : {}", emEmpSkillsDTO);
        if (emEmpSkillsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpSkills cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpSkills emEmpSkills = emEmpSkillsMapper.toEntity(emEmpSkillsDTO);
        emEmpSkills = emEmpSkillsRepository.save(emEmpSkills);
        EmEmpSkillsDTO result = emEmpSkillsMapper.toDto(emEmpSkills);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.POST
                )
        );
        return ResponseEntity.created(new URI("/api/em-emp-skills/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-skills : Updates an existing emEmpSkills.
     *
     * @param emEmpSkillsDTO the emEmpSkillsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpSkillsDTO,
     * or with status 400 (Bad Request) if the emEmpSkillsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpSkillsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-skills")
    @Timed
    public ResponseEntity<EmEmpSkillsDTO> updateEmEmpSkills(@RequestBody EmEmpSkillsDTO emEmpSkillsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpSkills : {}", emEmpSkillsDTO);
        if (emEmpSkillsDTO.getId() == null) {
            return createEmEmpSkills(emEmpSkillsDTO);
        }
        EmEmpSkills emEmpSkills = emEmpSkillsMapper.toEntity(emEmpSkillsDTO);
        emEmpSkills = emEmpSkillsRepository.save(emEmpSkills);
        EmEmpSkillsDTO result = emEmpSkillsMapper.toDto(emEmpSkills);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.PUT
                )
        );
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpSkillsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-skills : get all the emEmpSkills.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpSkills in body
     */
    @GetMapping("/em-emp-skills")
    @Timed
    public ResponseEntity<List<EmEmpSkillsDTO>> getAllEmEmpSkills(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpSkills");
        Page<EmEmpSkills> page = emEmpSkillsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-skills");
        return new ResponseEntity<>(emEmpSkillsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-skills/:id : get the "id" emEmpSkills.
     *
     * @param id the id of the emEmpSkillsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpSkillsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-skills/{id}")
    @Timed
    public ResponseEntity<EmEmpSkillsDTO> getEmEmpSkills(@PathVariable Long id) {
        log.debug("REST request to get EmEmpSkills : {}", id);
        EmEmpSkills emEmpSkills = emEmpSkillsRepository.findOne(id);
        EmEmpSkillsDTO emEmpSkillsDTO = emEmpSkillsMapper.toDto(emEmpSkills);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpSkillsDTO));
    }

    @GetMapping("/em-emp-skills/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpSkillsDTO>> getEmEmpSkillsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpSkills by Employee Id : {}", id);
        List<EmEmpSkills> emEmpSkills = emEmpSkillsRepository.findByIdEmployeeId(id);
        List<EmEmpSkillsDTO> emEmpSkillsDTO = emEmpSkillsMapper.toDto(emEmpSkills);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpSkillsDTO));
    }

    /**
     * DELETE  /em-emp-skills/:id : delete the "id" emEmpSkills.
     *
     * @param id the id of the emEmpSkillsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-skills/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpSkills(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpSkills : {}", id);
        EmEmpSkills skill = emEmpSkillsRepository.findOne(id);
        emEmpSkillsRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        skill.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        skill.getId().toString(),
                        Action.DELETE
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
