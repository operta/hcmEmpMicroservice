package com.infostudio.ba.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.infostudio.ba.service.EmEmpTaxService;
import com.infostudio.ba.web.rest.errors.BadRequestAlertException;
import com.infostudio.ba.web.rest.util.HeaderUtil;
import com.infostudio.ba.service.dto.EmEmpTaxDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EmEmpTax.
 */
@RestController
@RequestMapping("/api")
public class EmEmpTaxResource {

    private final Logger log = LoggerFactory.getLogger(EmEmpTaxResource.class);

    private static final String ENTITY_NAME = "emEmpTax";

    private final EmEmpTaxService emEmpTaxService;

    public EmEmpTaxResource(EmEmpTaxService emEmpTaxService) {
        this.emEmpTaxService = emEmpTaxService;
    }

    /**
     * POST  /em-emp-taxes : Create a new emEmpTax.
     *
     * @param emEmpTaxDTO the emEmpTaxDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emEmpTaxDTO, or with status 400 (Bad Request) if the emEmpTax has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/em-emp-taxes")
    @Timed
    public ResponseEntity<EmEmpTaxDTO> createEmEmpTax(@RequestBody EmEmpTaxDTO emEmpTaxDTO) throws URISyntaxException {
        log.debug("REST request to save EmEmpTax : {}", emEmpTaxDTO);
        if (emEmpTaxDTO.getId() != null) {
            throw new BadRequestAlertException("A new emEmpTax cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmEmpTaxDTO result = emEmpTaxService.save(emEmpTaxDTO);
        return ResponseEntity.created(new URI("/api/em-emp-taxes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /em-emp-taxes : Updates an existing emEmpTax.
     *
     * @param emEmpTaxDTO the emEmpTaxDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emEmpTaxDTO,
     * or with status 400 (Bad Request) if the emEmpTaxDTO is not valid,
     * or with status 500 (Internal Server Error) if the emEmpTaxDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/em-emp-taxes")
    @Timed
    public ResponseEntity<EmEmpTaxDTO> updateEmEmpTax(@RequestBody EmEmpTaxDTO emEmpTaxDTO) throws URISyntaxException {
        log.debug("REST request to update EmEmpTax : {}", emEmpTaxDTO);
        if (emEmpTaxDTO.getId() == null) {
            return createEmEmpTax(emEmpTaxDTO);
        }
        EmEmpTaxDTO result = emEmpTaxService.save(emEmpTaxDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, emEmpTaxDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /em-emp-taxes : get all the emEmpTaxes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpTaxes in body
     */
    @GetMapping("/em-emp-taxes")
    @Timed
    public List<EmEmpTaxDTO> getAllEmEmpTaxes() {
        log.debug("REST request to get all EmEmpTaxes");
        return emEmpTaxService.findAll();
        }

    /**
     * GET  /em-emp-taxes : get all the emEmpTaxes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of emEmpTaxes in body
     */
    @GetMapping("/em-emp-taxes/employee/{id}")
    @Timed
    public List<EmEmpTaxDTO> getAllEmEmpTaxesByEmployee(@PathVariable Integer id) {
        log.debug("REST request to get all EmEmpTaxes");
        return emEmpTaxService.findByEmployee(id);
    }


    /**
     * GET  /em-emp-taxes/:id : get the "id" emEmpTax.
     *
     * @param id the id of the emEmpTaxDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emEmpTaxDTO, or with status 404 (Not Found)
     */
    @GetMapping("/em-emp-taxes/{id}")
    @Timed
    public ResponseEntity<EmEmpTaxDTO> getEmEmpTax(@PathVariable Long id) {
        log.debug("REST request to get EmEmpTax : {}", id);
        EmEmpTaxDTO emEmpTaxDTO = emEmpTaxService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(emEmpTaxDTO));
    }

    /**
     * DELETE  /em-emp-taxes/:id : delete the "id" emEmpTax.
     *
     * @param id the id of the emEmpTaxDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/em-emp-taxes/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmEmpTax(@PathVariable Long id) {
        log.debug("REST request to delete EmEmpTax : {}", id);
        emEmpTaxService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
