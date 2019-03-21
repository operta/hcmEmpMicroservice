package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.Action;
import com.infostudio.ba.domain.EmEmpRewards;

import com.infostudio.ba.repository.EmEmpRewardsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.AuditUtil;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpRewardsDTO;
import com.infostudio.ba.service.mapper.EmEmpRewardsMapper;
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
 * REST controller for managing EmEmpRewards.
 */
@RestController
@RequestMapping("/api")
public class EmEmpRewardsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpRewardsResource.class);

    private static final String ENTITY_NAME = "emEmpRewards";

    private final EmEmpRewardsRepository emEmpRewardsRepository;

    private final EmEmpRewardsMapper emEmpRewardsMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmpRewardsResource(EmEmpRewardsRepository emEmpRewardsRepository,
                                EmEmpRewardsMapper emEmpRewardsMapper,
                                ApplicationEventPublisher applicationEventPublisher) {
        this.emEmpRewardsRepository = emEmpRewardsRepository;
        this.emEmpRewardsMapper = emEmpRewardsMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * POST  /em-emp-rewards : Create a new emEmpRewards.
     *
     * @param emEmpRewardsDTO the emEmpRewardsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpRewardsDTO, or with status 400 (Bad Request) if the emEmpRewards has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-rewards")
    @Timed
    public ResponseEntity<EmEmpRewardsDTO> createEmEmpRewards(@RequestBody EmEmpRewardsDTO emEmpRewardsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpRewards : {}", emEmpRewardsDTO);
        if (emEmpRewardsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpRewards cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpRewards emEmpRewards = emEmpRewardsMapper.toEntity(emEmpRewardsDTO);
        emEmpRewards = emEmpRewardsRepository.save(emEmpRewards);
        EmEmpRewardsDTO result = emEmpRewardsMapper.toDto(emEmpRewards);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.POST
                )
        );
        return ResponseEntity.created(new URI("/api/em-emp-rewards/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-rewards : Updates an existing emEmpRewards.
     *
     * @param emEmpRewardsDTO the emEmpRewardsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpRewardsDTO,
     * or with status 400 (Bad Request) if the emEmpRewardsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpRewardsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-rewards")
    @Timed
    public ResponseEntity<EmEmpRewardsDTO> updateEmEmpRewards(@RequestBody EmEmpRewardsDTO emEmpRewardsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpRewards : {}", emEmpRewardsDTO);
        if (emEmpRewardsDTO.getId() == null) {
            return createEmEmpRewards(emEmpRewardsDTO);
        }
        EmEmpRewards emEmpRewards = emEmpRewardsMapper.toEntity(emEmpRewardsDTO);
        emEmpRewards = emEmpRewardsRepository.save(emEmpRewards);
        EmEmpRewardsDTO result = emEmpRewardsMapper.toDto(emEmpRewards);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getIdEmployeeId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.PUT
                )
        );
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpRewardsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-rewards : get all the emEmpRewards.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpRewards in body
     */
    @GetMapping("/em-emp-rewards")
    @Timed
    public ResponseEntity<List<EmEmpRewardsDTO>> getAllEmEmpRewards(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpRewards");
        Page<EmEmpRewards> page = emEmpRewardsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-rewards");
        return new ResponseEntity<>(emEmpRewardsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-rewards/:id : get the "id" emEmpRewards.
     *
     * @param id the id of the emEmpRewardsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpRewardsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-rewards/{id}")
    @Timed
    public ResponseEntity<EmEmpRewardsDTO> getEmEmpRewards(@PathVariable Long id) {
        log.debug("REST request to get EmEmpRewards : {}", id);
        EmEmpRewards emEmpRewards = emEmpRewardsRepository.findOne(id);
        EmEmpRewardsDTO emEmpRewardsDTO = emEmpRewardsMapper.toDto(emEmpRewards);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpRewardsDTO));
    }

    @GetMapping("/em-emp-rewards/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpRewardsDTO>> getEmEmpRewardsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpRewards by Employee Id : {}", id);
        List<EmEmpRewards> emEmpRewards = emEmpRewardsRepository.findByIdEmployeeId(id);
        List<EmEmpRewardsDTO> emEmpRewardsDTO = emEmpRewardsMapper.toDto(emEmpRewards);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpRewardsDTO));
    }

    /**
     * DELETE  /em-emp-rewards/:id : delete the "id" emEmpRewards.
     *
     * @param id the id of the emEmpRewardsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-rewards/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpRewards(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpRewards : {}", id);
        EmEmpRewards reward = emEmpRewardsRepository.findOne(id);
        emEmpRewardsRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        reward.getIdEmployee().getId().toString(),
                        ENTITY_NAME,
                        reward.getId().toString(),
                        Action.DELETE
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
