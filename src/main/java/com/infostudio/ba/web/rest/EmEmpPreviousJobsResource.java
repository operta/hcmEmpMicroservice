package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpPreviousJobs;

import com.infostudio.ba.repository.EmEmpPreviousJobsRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpPreviousJobsDTO;
import com.infostudio.ba.service.mapper.EmEmpPreviousJobsMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * REST controller for managing EmEmpPreviousJobs.
 */
@RestController
@RequestMapping("/api")
public class EmEmpPreviousJobsResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpPreviousJobsResource.class);

    private static final String ENTITY_NAME = "emEmpPreviousJobs";

    private final EmEmpPreviousJobsRepository emEmpPreviousJobsRepository;

    private final EmEmpPreviousJobsMapper emEmpPreviousJobsMapper;

    public EmEmpPreviousJobsResource(EmEmpPreviousJobsRepository emEmpPreviousJobsRepository, EmEmpPreviousJobsMapper emEmpPreviousJobsMapper) {
        this.emEmpPreviousJobsRepository = emEmpPreviousJobsRepository;
        this.emEmpPreviousJobsMapper = emEmpPreviousJobsMapper;
    }

    /**
     * POST  /em-emp-previous-jobs : Create a new emEmpPreviousJobs.
     *
     * @param emEmpPreviousJobsDTO the emEmpPreviousJobsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpPreviousJobsDTO, or with status 400 (Bad Request) if the emEmpPreviousJobs has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-previous-jobs")
    @Timed
    public ResponseEntity<EmEmpPreviousJobsDTO> createEmEmpPreviousJobs(@RequestBody EmEmpPreviousJobsDTO emEmpPreviousJobsDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpPreviousJobs : {}", emEmpPreviousJobsDTO);
        if (emEmpPreviousJobsDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpPreviousJobs cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Long serviceYears = YEARS.between(emEmpPreviousJobsDTO.getDateFrom(), emEmpPreviousJobsDTO.getDateTo());
        LocalDate dateFromWith2MoreYears = emEmpPreviousJobsDTO.getDateFrom().plusYears(serviceYears);
        Long serviceMonths = MONTHS.between(dateFromWith2MoreYears, emEmpPreviousJobsDTO.getDateTo());
        dateFromWith2MoreYears = dateFromWith2MoreYears.plusMonths(serviceMonths);
        Long serviceDays = DAYS.between(dateFromWith2MoreYears, emEmpPreviousJobsDTO.getDateTo());


        emEmpPreviousJobsDTO.setLengthOfServiceDays(serviceDays.intValue());
        emEmpPreviousJobsDTO.setLengthOfServiceMonths(serviceMonths.intValue());
        emEmpPreviousJobsDTO.setLengthOfServiceYears(serviceYears.intValue());


        EmEmpPreviousJobs emEmpPreviousJobs = emEmpPreviousJobsMapper.toEntity(emEmpPreviousJobsDTO);
        /*
        System.out.println("-----------------------------");
        System.out.println(emEmpPreviousJobs);
        */
        emEmpPreviousJobs = emEmpPreviousJobsRepository.save(emEmpPreviousJobs);
        EmEmpPreviousJobsDTO result = emEmpPreviousJobsMapper.toDto(emEmpPreviousJobs);
        return ResponseEntity.created(new URI("/api/em-emp-previous-jobs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-previous-jobs : Updates an existing emEmpPreviousJobs.
     *
     * @param emEmpPreviousJobsDTO the emEmpPreviousJobsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpPreviousJobsDTO,
     * or with status 400 (Bad Request) if the emEmpPreviousJobsDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpPreviousJobsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-previous-jobs")
    @Timed
    public ResponseEntity<EmEmpPreviousJobsDTO> updateEmEmpPreviousJobs(@RequestBody EmEmpPreviousJobsDTO emEmpPreviousJobsDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpPreviousJobs : {}", emEmpPreviousJobsDTO);
        if (emEmpPreviousJobsDTO.getId() == null) {
            return createEmEmpPreviousJobs(emEmpPreviousJobsDTO);
        }
        EmEmpPreviousJobs emEmpPreviousJobs = emEmpPreviousJobsMapper.toEntity(emEmpPreviousJobsDTO);
        emEmpPreviousJobs = emEmpPreviousJobsRepository.save(emEmpPreviousJobs);
        EmEmpPreviousJobsDTO result = emEmpPreviousJobsMapper.toDto(emEmpPreviousJobs);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpPreviousJobsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-previous-jobs : get all the emEmpPreviousJobs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpPreviousJobs in body
     */
    @GetMapping("/em-emp-previous-jobs")
    @Timed
    public ResponseEntity<List<EmEmpPreviousJobsDTO>> getAllEmEmpPreviousJobs(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpPreviousJobs");
        Page<EmEmpPreviousJobs> page = emEmpPreviousJobsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-previous-jobs");
        return new ResponseEntity<>(emEmpPreviousJobsMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-previous-jobs/:id : get the "id" emEmpPreviousJobs.
     *
     * @param id the id of the emEmpPreviousJobsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpPreviousJobsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-previous-jobs/{id}")
    @Timed
    public ResponseEntity<EmEmpPreviousJobsDTO> getEmEmpPreviousJobs(@PathVariable Long id) {
        log.debug("REST request to get EmEmpPreviousJobs : {}", id);
        EmEmpPreviousJobs emEmpPreviousJobs = emEmpPreviousJobsRepository.findOne(id);
        EmEmpPreviousJobsDTO emEmpPreviousJobsDTO = emEmpPreviousJobsMapper.toDto(emEmpPreviousJobs);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpPreviousJobsDTO));
    }

    @GetMapping("/em-emp-previous-jobs/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpPreviousJobsDTO>> getEmEmpPreviousJobsByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpPreviousJobs by Employee Id : {}", id);
        List<EmEmpPreviousJobs> emEmpPreviousJobs = emEmpPreviousJobsRepository.findByIdEmployeeId(id);
        List<EmEmpPreviousJobsDTO> emEmpPreviousJobsDTO = emEmpPreviousJobsMapper.toDto(emEmpPreviousJobs);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpPreviousJobsDTO));
    }

    /**
     * DELETE  /em-emp-previous-jobs/:id : delete the "id" emEmpPreviousJobs.
     *
     * @param id the id of the emEmpPreviousJobsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-previous-jobs/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpPreviousJobs(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpPreviousJobs : {}", id);
        emEmpPreviousJobsRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
