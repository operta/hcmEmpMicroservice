package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.EmEmpOrgWorkPlaces;

import com.infostudio.ba.domain.EmEmpSalaries;
import com.infostudio.ba.repository.EmEmpOrgWorkPlacesRepository;
import com.infostudio.ba.repository.EmEmpSalariesRepository;
import com.infostudio.ba.service.proxy.CoreMicroserviceProxy;
import com.infostudio.ba.service.proxy.model.OgOrgWorkPlaces;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import com.infostudio.ba.service.dto.EmEmpOrgWorkPlacesDTO;
import com.infostudio.ba.service.mapper.EmEmpOrgWorkPlacesMapper;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EmEmpOrgWorkPlaces.
 */
@RestController
@RequestMapping("/api")
public class EmEmpOrgWorkPlacesResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpOrgWorkPlacesResource.class);

    private static final String ENTITY_NAME = "emEmpOrgWorkPlaces";

    private final EmEmpOrgWorkPlacesRepository emEmpOrgWorkPlacesRepository;

    private final EmEmpSalariesRepository emEmpSalariesRepository;

    private final EmEmpOrgWorkPlacesMapper emEmpOrgWorkPlacesMapper;

    private final CoreMicroserviceProxy coreMicroserviceProxy;

    public EmEmpOrgWorkPlacesResource(EmEmpOrgWorkPlacesRepository emEmpOrgWorkPlacesRepository,
                                      EmEmpOrgWorkPlacesMapper emEmpOrgWorkPlacesMapper,
                                      EmEmpSalariesRepository emEmpSalariesRepository,
                                      CoreMicroserviceProxy coreMicroserviceProxy) {
        this.emEmpOrgWorkPlacesRepository = emEmpOrgWorkPlacesRepository;
        this.emEmpOrgWorkPlacesMapper = emEmpOrgWorkPlacesMapper;
        this.emEmpSalariesRepository = emEmpSalariesRepository;
        this.coreMicroserviceProxy = coreMicroserviceProxy;
    }

    public void createEmEmpSalary(EmEmpOrgWorkPlaces emEmpOrgWorkPlaces, String auth){
        EmEmpSalaries emEmpSalaries = new EmEmpSalaries();
        emEmpSalaries.setDateFrom(emEmpOrgWorkPlaces.getDateFrom());
        emEmpSalaries.setDateTo(emEmpOrgWorkPlaces.getDateTo());
        emEmpSalaries.setIdEmployee(emEmpOrgWorkPlaces.getIdEmployee());
        emEmpSalaries.setWorkHistoryCoefficient(emEmpOrgWorkPlaces.getWorkHistoryCoefficient());
        emEmpSalaries.setIdContractType(emEmpOrgWorkPlaces.getIdContractType());

        OgOrgWorkPlaces ogOrgWorkPlaces = coreMicroserviceProxy.getOgOrgWorkPlaceById((long)emEmpOrgWorkPlaces.getIdOrgWorkPlace(),
                auth).getBody();
        emEmpSalaries.setIdWorkPlace((int)(long)ogOrgWorkPlaces.getIdWorkPlaceId());
        emEmpSalariesRepository.save(emEmpSalaries);
    }

    /**
     * POST  /em-emp-org-work-places : Create a new emEmpOrgWorkPlaces.
     *
     * @param emEmpOrgWorkPlacesDTO the emEmpOrgWorkPlacesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpOrgWorkPlacesDTO, or with status 400 (Bad Request) if the emEmpOrgWorkPlaces has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-org-work-places")
    @Timed
    public ResponseEntity<EmEmpOrgWorkPlacesDTO> createEmEmpOrgWorkPlaces(@Valid @RequestBody EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO,
                                                                          @RequestHeader("Authorization") String auth) throws URISyntaxException {
        log.debug("REST request to save EmEmpOrgWorkPlaces : {}", emEmpOrgWorkPlacesDTO);
        if (emEmpOrgWorkPlacesDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpOrgWorkPlaces cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpOrgWorkPlaces emEmpOrgWorkPlaces = emEmpOrgWorkPlacesMapper.toEntity(emEmpOrgWorkPlacesDTO);
        emEmpOrgWorkPlaces = emEmpOrgWorkPlacesRepository.save(emEmpOrgWorkPlaces);
        // createEmEmpSalary(emEmpOrgWorkPlaces, auth);
        EmEmpOrgWorkPlacesDTO result = emEmpOrgWorkPlacesMapper.toDto(emEmpOrgWorkPlaces);
        return ResponseEntity.created(new URI("/api/em-emp-org-work-places/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-org-work-places : Updates an existing emEmpOrgWorkPlaces.
     *
     * @param emEmpOrgWorkPlacesDTO the emEmpOrgWorkPlacesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpOrgWorkPlacesDTO,
     * or with status 400 (Bad Request) if the emEmpOrgWorkPlacesDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpOrgWorkPlacesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-org-work-places")
    @Timed
    public ResponseEntity<EmEmpOrgWorkPlacesDTO> updateEmEmpOrgWorkPlaces(@Valid @RequestBody EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO,
                                                                          @RequestHeader("Authorization") String auth) throws URISyntaxException {
        log.debug("REST request to update EmEmpOrgWorkPlaces : {}", emEmpOrgWorkPlacesDTO);
        if (emEmpOrgWorkPlacesDTO.getId() == null) {
            return createEmEmpOrgWorkPlaces(emEmpOrgWorkPlacesDTO, auth);
        }
        EmEmpOrgWorkPlaces emEmpOrgWorkPlaces = emEmpOrgWorkPlacesMapper.toEntity(emEmpOrgWorkPlacesDTO);
        emEmpOrgWorkPlaces = emEmpOrgWorkPlacesRepository.save(emEmpOrgWorkPlaces);
        createEmEmpSalary(emEmpOrgWorkPlaces, auth);
        EmEmpOrgWorkPlacesDTO result = emEmpOrgWorkPlacesMapper.toDto(emEmpOrgWorkPlaces);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpOrgWorkPlacesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-org-work-places : get all the emEmpOrgWorkPlaces.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpOrgWorkPlaces in body
     */
    @GetMapping("/em-emp-org-work-places")
    @Timed
    public ResponseEntity<List<EmEmpOrgWorkPlacesDTO>> getAllEmEmpOrgWorkPlaces(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpOrgWorkPlaces");
        Page<EmEmpOrgWorkPlaces> page = emEmpOrgWorkPlacesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-org-work-places");
        return new ResponseEntity<>(emEmpOrgWorkPlacesMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-org-work-places/:id : get the "id" emEmpOrgWorkPlaces.
     *
     * @param id the id of the emEmpOrgWorkPlacesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpOrgWorkPlacesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-org-work-places/{id}")
    @Timed
    public ResponseEntity<EmEmpOrgWorkPlacesDTO> getEmEmpOrgWorkPlaces(@PathVariable Long id) {
        log.debug("REST request to get EmEmpOrgWorkPlaces : {}", id);
        EmEmpOrgWorkPlaces emEmpOrgWorkPlaces = emEmpOrgWorkPlacesRepository.findOne(id);
        EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO = emEmpOrgWorkPlacesMapper.toDto(emEmpOrgWorkPlaces);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpOrgWorkPlacesDTO));
    }

    @GetMapping("/em-emp-org-work-places/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpOrgWorkPlacesDTO>> getEmEmpOrgWorkPlacesByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpOrgWorkPlaces by Employee id : {}", id);
        List<EmEmpOrgWorkPlaces> emEmpOrgWorkPlaces = emEmpOrgWorkPlacesRepository.findByIdEmployeeId(id);
        List<EmEmpOrgWorkPlacesDTO> emEmpOrgWorkPlacesDTO = emEmpOrgWorkPlacesMapper.toDto(emEmpOrgWorkPlaces);
        return new ResponseEntity<>(emEmpOrgWorkPlacesDTO, null, HttpStatus.OK);
    }

    @GetMapping("/em-emp-org-work-places/last/employee/{id}")
    @Timed
    public ResponseEntity<EmEmpOrgWorkPlacesDTO> getLastEmEmpOrgWorkPlacesByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpOrgWorkPlaces by Employee id : {}", id);
        EmEmpOrgWorkPlaces emEmpOrgWorkPlaces = emEmpOrgWorkPlacesRepository.findLastOrgWorkPlace(id);
        EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO = emEmpOrgWorkPlacesMapper.toDto(emEmpOrgWorkPlaces);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpOrgWorkPlacesDTO));
    }
    @GetMapping("/em-emp-org-work-places/all/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpOrgWorkPlacesDTO>> getAllEmEmpOrgWorkPlacesByEmpId(@PathVariable Long id) {
        log.debug("REST request to get all EmEmpOrgWorkPlaces by Employee id : {}", id);
        List<EmEmpOrgWorkPlaces> emEmpOrgWorkPlacesList = emEmpOrgWorkPlacesRepository.findAllByIdEmployeeIdAndDateToIsNullOrDateToGreaterThanEqual(id,
                LocalDate.now());
        List<EmEmpOrgWorkPlacesDTO> emEmpOrgWorkPlacesDTOList = emEmpOrgWorkPlacesMapper.toDto(emEmpOrgWorkPlacesList);
        return ResponseEntity.ok(emEmpOrgWorkPlacesDTOList);
    }

    @GetMapping("/em-emp-org-work-places/last")
    @Timed
    public ResponseEntity<List<EmEmpOrgWorkPlacesDTO>> getLastEmEmpOrgWorkPlacesForAll() {
        log.debug("REST request to get Last EmEmpOrgWorkPlaces");
        List<EmEmpOrgWorkPlaces> emEmpOrgWorkPlaces = emEmpOrgWorkPlacesRepository.findLastOrgWorkPlaces();
        List<EmEmpOrgWorkPlacesDTO> emEmpOrgWorkPlacesDTO = emEmpOrgWorkPlacesMapper.toDto(emEmpOrgWorkPlaces);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpOrgWorkPlacesDTO));
    }

    /**
     * DELETE  /em-emp-org-work-places/:id : delete the "id" emEmpOrgWorkPlaces.
     *
     * @param id the id of the emEmpOrgWorkPlacesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-org-work-places/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpOrgWorkPlaces(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpOrgWorkPlaces : {}", id);
        emEmpOrgWorkPlacesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
