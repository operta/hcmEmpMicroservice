package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.domain.Detail;
import com.infostudio.ba.domain.EmEmpMetaData;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.repository.EmEmpMetaDataRepository;
import com.infostudio.ba.repository.EmEmployeesRepository;
import com.infostudio.ba.service.dto.EmEmpMetaDataDTO;
import com.infostudio.ba.service.dto.EmEmpMetaDataHelperDTO;
import com.infostudio.ba.service.mapper.EmEmpMetaDataMapper;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * REST controller for managing EmEmpMetaData.
 */
@RestController
@RequestMapping("/api")
public class EmEmpMetaDataResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpMetaDataResource.class);

    private static final String ENTITY_NAME = "emEmpMetaData";

    private final EmEmpMetaDataRepository emEmpMetaDataRepository;

    private final EmEmpMetaDataMapper emEmpMetaDataMapper;

    private final EmEmployeesRepository emEmployeesRepository;

    public EmEmpMetaDataResource(EmEmpMetaDataRepository emEmpMetaDataRepository, EmEmpMetaDataMapper emEmpMetaDataMapper,
                                 EmEmployeesRepository emEmployeesRepository) {
        this.emEmpMetaDataRepository = emEmpMetaDataRepository;
        this.emEmpMetaDataMapper = emEmpMetaDataMapper;
        this.emEmployeesRepository = emEmployeesRepository;
    }

    /**
     * POST  /em-emp-meta-data : Create a new emEmpMetaData.
     *
     * @param emEmpMetaDataDTO the emEmpMetaDataDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpMetaDataDTO, or with status 400 (Bad Request) if the emEmpMetaData has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-meta-data")
    @Timed
    public ResponseEntity<EmEmpMetaDataDTO> createEmEmpMetaData(@RequestBody EmEmpMetaDataDTO emEmpMetaDataDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpMetaData : {}", emEmpMetaDataDTO);
        if (emEmpMetaDataDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpMetaData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        if (emEmpMetaDataDTO.getTitle() == null || emEmpMetaDataDTO.getTitle().trim().isEmpty()) {
            throw new BadRequestAlertException("You need to add a title.", ENTITY_NAME, "emEmpMetaDataTitleRequired");
        }
        EmEmpMetaData emEmpMetaData = emEmpMetaDataMapper.toEntity(emEmpMetaDataDTO);
        emEmpMetaData = emEmpMetaDataRepository.save(emEmpMetaData);
        EmEmpMetaDataDTO result = emEmpMetaDataMapper.toDto(emEmpMetaData);
        return ResponseEntity.created(new URI("/api/em-emp-meta-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @PostMapping("/em-emp-meta-data/new")
    public ResponseEntity<EmEmpMetaDataHelperDTO> createMetadataForEmployee(@RequestBody EmEmpMetaDataHelperDTO emEmpMetaDataHelper) {
        log.debug("REST request to save EmEmpMetadata for employee with id: {}", emEmpMetaDataHelper.getIdEmployee());
        if (emEmpMetaDataHelper.getIdEmployee() == null) {
            throw new BadRequestAlertException("Employee id is required.",
                    ENTITY_NAME, "employeeIdRequired");
        }
        if (emEmpMetaDataHelper.getDetails() == null) {
            throw new BadRequestAlertException("You must provide the id of the details associated with the employee",
                    ENTITY_NAME, "detailsRequired");
        }
        boolean employeeExists = emEmployeesRepository.exists(emEmpMetaDataHelper.getIdEmployee());
        if (!employeeExists) {
            String employeeDoesNotExistMessage = String.format("Employee with id %d does not exist", emEmpMetaDataHelper.getIdEmployee());
            throw new BadRequestAlertException(employeeDoesNotExistMessage,
                    ENTITY_NAME, "employeeDoesNotExist");
        }
        long employeeId = emEmpMetaDataHelper.getIdEmployee();

        for (Detail detail : emEmpMetaDataHelper.getDetails()) {
            boolean metaDataWithSameEmployeeAndDetailExist = emEmpMetaDataRepository.existsByIdEmployeeIdAndIdDetail(employeeId, detail.getId().intValue());
            if (metaDataWithSameEmployeeAndDetailExist) {
                throw new BadRequestAlertException("You already are associated with a detail with the given id.",
                        ENTITY_NAME, "idEmployeeAndDetailIdCombinationExists");
            }
        }

        for (Detail detail : emEmpMetaDataHelper.getDetails()) {
            EmEmpMetaData emEmpMetaData = new EmEmpMetaData();
            emEmpMetaData.setIdEmployee(new EmEmployees().withId(emEmpMetaDataHelper.getIdEmployee()));
            emEmpMetaData.setIdDetail(detail.getId().intValue());
            emEmpMetaData.setTitle(detail.getTitle());
            emEmpMetaDataRepository.save(emEmpMetaData);
        }
        return ResponseEntity.created(URI.create("/api/em-emp-meta-data"))
                .body(emEmpMetaDataHelper);
    }

    /**
     * PUT  /em-emp-meta-data : Updates an existing emEmpMetaData.
     *
     * @param emEmpMetaDataDTO the emEmpMetaDataDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpMetaDataDTO,
     * or with status 400 (Bad Request) if the emEmpMetaDataDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpMetaDataDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-meta-data")
    @Timed
    public ResponseEntity<EmEmpMetaDataDTO> updateEmEmpMetaData(@RequestBody EmEmpMetaDataDTO emEmpMetaDataDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpMetaData : {}", emEmpMetaDataDTO);
        if (emEmpMetaDataDTO.getId() == null) {
            return createEmEmpMetaData(emEmpMetaDataDTO);
        }
        EmEmpMetaData emEmpMetaData = emEmpMetaDataMapper.toEntity(emEmpMetaDataDTO);
        emEmpMetaData = emEmpMetaDataRepository.save(emEmpMetaData);
        EmEmpMetaDataDTO result = emEmpMetaDataMapper.toDto(emEmpMetaData);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpMetaDataDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-meta-data : get all the emEmpMetaData.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpMetaData in body
     */
    @GetMapping("/em-emp-meta-data")
    @Timed
    public ResponseEntity<List<EmEmpMetaDataDTO>> getAllEmEmpMetaData(Pageable pageable) {
        log.debug("REST request to get a page of EmEmpMetaData");
        Page<EmEmpMetaData> page = emEmpMetaDataRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/em-emp-meta-data");
        return new ResponseEntity<>(emEmpMetaDataMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /em-emp-meta-data/:id : get the "id" emEmpMetaData.
     *
     * @param id the id of the emEmpMetaDataDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpMetaDataDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-meta-data/{id}")
    @Timed
    public ResponseEntity<EmEmpMetaDataDTO> getEmEmpMetaData(@PathVariable Long id) {
        log.debug("REST request to get EmEmpMetaData : {}", id);
        EmEmpMetaData emEmpMetaData = emEmpMetaDataRepository.findOne(id);
        EmEmpMetaDataDTO emEmpMetaDataDTO = emEmpMetaDataMapper.toDto(emEmpMetaData);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpMetaDataDTO));
    }

    @GetMapping("/em-emp-meta-data/employee/{id}")
    @Timed
    public ResponseEntity<List<EmEmpMetaDataDTO>> getEmEmpMetaDataByEmpId(@PathVariable Long id) {
        log.debug("REST request to get EmEmpMetaData by Employee id : {}", id);
        List<EmEmpMetaData> emEmpMetaData = emEmpMetaDataRepository.findByIdEmployeeId(id);
        List<EmEmpMetaDataDTO> emEmpMetaDataDTO = emEmpMetaDataMapper.toDto(emEmpMetaData);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpMetaDataDTO));
    }

    /**
     * DELETE  /em-emp-meta-data/:id : delete the "id" emEmpMetaData.
     *
     * @param id the id of the emEmpMetaDataDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-meta-data/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpMetaData(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpMetaData : {}", id);
        emEmpMetaDataRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
