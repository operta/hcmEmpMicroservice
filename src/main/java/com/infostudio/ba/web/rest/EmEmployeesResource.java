package com.infostudio.ba.web.rest;

import com.infostudio.ba.domain.Action;
import com.infostudio.ba.web.rest.util.AuditUtil;
import org.apache.commons.lang.RandomStringUtils;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpOrgWorkPlaces;
import com.infostudio.ba.domain.EmEmployees;

import com.infostudio.ba.repository.EmEmpOrgWorkPlacesRepository;
import com.infostudio.ba.repository.EmEmployeesRepository;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmployeesDTO;
import com.infostudio.ba.service.mapper.EmEmployeesMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.time.LocalDate;
import java.util.*;

/**
 * REST controller for managing EmEmployees.
 */
@RestController
@RequestMapping("/api")
public class EmEmployeesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmployeesResource.class);

    private static final String ENTITY_NAME = "emEmployees";

    private static final String ARCHIVED = "N";

    private final EmEmployeesRepository emEmployeesRepository;

    private final EmEmpOrgWorkPlacesRepository emEmpOrgWorkPlacesRepository;

    private final EmEmployeesMapper emEmployeesMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public EmEmployeesResource(EmEmployeesRepository emEmployeesRepository,
                               EmEmployeesMapper emEmployeesMapper,
                               EmEmpOrgWorkPlacesRepository emEmpOrgWorkPlacesRepository,
                               ApplicationEventPublisher applicationEventPublisher) {
        this.emEmployeesRepository = emEmployeesRepository;
        this.emEmployeesMapper = emEmployeesMapper;
        this.emEmpOrgWorkPlacesRepository = emEmpOrgWorkPlacesRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * POST  /em-employees : Create a new emEmployees.
     *
     * @param emEmployeesDTO the emEmployeesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmployeesDTO, or with status 400 (Bad Request) if the emEmployees has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-employees")
    @Timed
    public ResponseEntity<EmEmployeesDTO> createEmEmployees(@Valid @RequestBody EmEmployeesDTO emEmployeesDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmployees : {}", emEmployeesDTO);
        if (emEmployeesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmployees cannot already have an ID", ENTITY_NAME, "idexists");
        }
        String newCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        while(emEmployeesRepository.findByCode(newCode) != null){
            newCode = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        }
        emEmployeesDTO.setCode(newCode);
        if(emEmployeesDTO.getIdUser() == null){
            throw new BadRequestAlertException("An employee must have a user account associated with him", ENTITY_NAME, "idexists");
        }
        EmEmployees possibleEmployee = emEmployeesRepository.findByIdUser(emEmployeesDTO.getIdUser());
        if(possibleEmployee != null){
            throw new BadRequestAlertException("A user can only have one employee associated with him", ENTITY_NAME, "idexists");
        }
        emEmployeesDTO.setArchived("N");
        EmEmployees emEmployees = emEmployeesMapper.toEntity(emEmployeesDTO);
        emEmployees = emEmployeesRepository.save(emEmployees);
        EmEmployeesDTO result = emEmployeesMapper.toDto(emEmployees);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.POST
                )
        );
        return ResponseEntity.created(new URI("/api/em-employees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-employees : Updates an existing emEmployees.
     *
     * @param emEmployeesDTO the emEmployeesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmployeesDTO,
     * or with status 400 (Bad Request) if the emEmployeesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmployeesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-employees")
    @Timed
    public ResponseEntity<EmEmployeesDTO> updateEmEmployees(@Valid @RequestBody EmEmployeesDTO emEmployeesDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmployees : {}", emEmployeesDTO);
        if (emEmployeesDTO.getId() == null) {
            return createEmEmployees(emEmployeesDTO);
        }
        if (emEmployeesDTO.getCode() == null){
            throw new BadRequestAlertException("Code attribute of employee must not be null", ENTITY_NAME,
                    "codenull");
        }
        if (!emEmployeesDTO.getArchived().equals("Y") && !emEmployeesDTO.getArchived().equals("N")){
            throw new BadRequestAlertException("Archived cannot have value different from 'Y' or 'N'", ENTITY_NAME,
                    "archivedoutofbounds");
        }
        EmEmployees emEmployees = emEmployeesMapper.toEntity(emEmployeesDTO);
        emEmployees = emEmployeesRepository.save(emEmployees);
        EmEmployeesDTO result = emEmployeesMapper.toDto(emEmployees);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        result.getId().toString(),
                        ENTITY_NAME,
                        result.getId().toString(),
                        Action.PUT
                )
        );
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmployeesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-employees : get all the emEmployees.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmployees in body
     */
    @GetMapping("/em-employees")
    @Timed
    public ResponseEntity<List<EmEmployeesDTO>> getAllEmEmployees(
            @RequestParam(value = "fromDate", required = false) LocalDate fromDate,
            @RequestParam(value = "toDate", required = false) LocalDate toDate,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "qualificationId", required = false) Integer qualificationId,
            @RequestParam(value = "archived", required = false) String archived,
            Pageable pageable) {
        log.debug("REST request to get a page of EmEmployees");

        if(archived == null){
            archived = ARCHIVED;
        }else if(!archived.equals("N") && !archived.equals("Y")){
            throw new BadRequestAlertException("Archived cannot have field different from 'Y' or 'N'", ENTITY_NAME,
                    "archivedoutofbounds");
        }

        Set<EmEmployees> allEmps = new HashSet<>(emEmployeesRepository.findAllByArchived(archived));
        if(fromDate != null){
            Set<EmEmployees> empsFromDate = new HashSet<>(emEmployeesRepository.findAllByHireDateGreaterThanEqual(fromDate));
            allEmps.retainAll(empsFromDate);
        }
        if(toDate != null){
            Set<EmEmployees> empsToDate = new HashSet<>(emEmployeesRepository.findAllByHireDateLessThanEqual(toDate));
            allEmps.retainAll(empsToDate);
        }
        if(name != null){
            Set<EmEmployees> empsByName = new HashSet<>(emEmployeesRepository.findAllByNameContains(name));
            allEmps.retainAll(empsByName);
        }
        if(surname != null){
            Set<EmEmployees> empsBySurname = new HashSet<>(emEmployeesRepository.findAllBySurnameContains(surname));
            allEmps.retainAll(empsBySurname);
        }
        if(qualificationId != null){
            Set<EmEmployees> empsByQualification = new HashSet<>(emEmployeesRepository.findAllByIdQualification(qualificationId));
            allEmps.retainAll(empsByQualification);
        }
        List<EmEmployees> emEmployees = new ArrayList<>(allEmps);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > allEmps.size() ? allEmps.size() : (start + pageable.getPageSize());
        Page<EmEmployees> page = new PageImpl<>(emEmployees.subList(start, end), pageable, emEmployees.size());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-employees");
        return new ResponseEntity<>(emEmployeesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-employees/:id : get the "id" emEmployees.
     *
     * @param id the id of the emEmployeesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmployeesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-employees/{id}")
    @Timed
    public ResponseEntity<EmEmployeesDTO> getEmEmployees(@PathVariable Long id) {
        log.debug("REST request to get EmEmployees : {}", id);
        EmEmployees emEmployees = emEmployeesRepository.findOne(id);
        EmEmployeesDTO emEmployeesDTO = emEmployeesMapper.toDto(emEmployees);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmployeesDTO));
    }

    /**
     * GET  /em-employees/user/:id .
     *
     * @param id the id of the user to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmployeesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-employees/user/{id}")
    @Timed
    public ResponseEntity<EmEmployeesDTO> getEmEmployeesByUserId(@PathVariable Long id) {
        log.debug("REST request to get EmEmployees by user id : {}", id);
        EmEmployees emEmployees = emEmployeesRepository.findByIdUser(id.intValue());
        EmEmployeesDTO emEmployeesDTO = emEmployeesMapper.toDto(emEmployees);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmployeesDTO));
    }

    /**
     * DELETE  /em-employees/:id : delete the "id" emEmployees.
     *
     * @param id the id of the emEmployeesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-employees/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmployees(@PathVariable Long id) {
        log.debug("REST request to delete EmEmployees : {}", id);
        emEmployeesRepository.delete(id);
        applicationEventPublisher.publishEvent(
                AuditUtil.createAuditEvent(
                        id.toString(),
                        ENTITY_NAME,
                        id.toString(),
                        Action.POST
                )
        );
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
