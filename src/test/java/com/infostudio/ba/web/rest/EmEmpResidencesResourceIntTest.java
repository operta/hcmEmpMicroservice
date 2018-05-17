package com.infostudio.ba.web.rest;

import com.infostudio.ba.HcmEmpMicroserviceApp;

import com.infostudio.ba.domain.EmEmpResidences;
import com.infostudio.ba.repository.EmEmpResidencesRepository;
import com.infostudio.ba.service.dto.EmEmpResidencesDTO;
import com.infostudio.ba.service.mapper.EmEmpResidencesMapper;
import com.infostudio.ba.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.infostudio.ba.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the EmEmpResidencesResource REST controller.
 *
 * @see EmEmpResidencesResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HcmEmpMicroserviceApp.class)
public class EmEmpResidencesResourceIntTest {

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_FROM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_FROM = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATO_TO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATO_TO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ADDRESS_WORK = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_WORK = "BBBBBBBBBB";

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private EmEmpResidencesRepository emEmpResidencesRepository;

    @Autowired
    private EmEmpResidencesMapper emEmpResidencesMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEmEmpResidencesMockMvc;

    private EmEmpResidences emEmpResidences;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EmEmpResidencesResource emEmpResidencesResource = new EmEmpResidencesResource(emEmpResidencesRepository, emEmpResidencesMapper);
        this.restEmEmpResidencesMockMvc = MockMvcBuilders.standaloneSetup(emEmpResidencesResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EmEmpResidences createEntity(EntityManager em) {
        EmEmpResidences emEmpResidences = new EmEmpResidences()
            .address(DEFAULT_ADDRESS)
            .dateFrom(DEFAULT_DATE_FROM)
            .datoTo(DEFAULT_DATO_TO)
            .addressWork(DEFAULT_ADDRESS_WORK)
            .createdBy(DEFAULT_CREATED_BY)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedBy(DEFAULT_UPDATED_BY)
            .updatedAt(DEFAULT_UPDATED_AT);
        return emEmpResidences;
    }

    @Before
    public void initTest() {
        emEmpResidences = createEntity(em);
    }

    @Test
    @Transactional
    public void createEmEmpResidences() throws Exception {
        int databaseSizeBeforeCreate = emEmpResidencesRepository.findAll().size();

        // Create the EmEmpResidences
        EmEmpResidencesDTO emEmpResidencesDTO = emEmpResidencesMapper.toDto(emEmpResidences);
        restEmEmpResidencesMockMvc.perform(post("/api/em-emp-residences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpResidencesDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpResidences in the database
        List<EmEmpResidences> emEmpResidencesList = emEmpResidencesRepository.findAll();
        assertThat(emEmpResidencesList).hasSize(databaseSizeBeforeCreate + 1);
        EmEmpResidences testEmEmpResidences = emEmpResidencesList.get(emEmpResidencesList.size() - 1);
        assertThat(testEmEmpResidences.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testEmEmpResidences.getDateFrom()).isEqualTo(DEFAULT_DATE_FROM);
        assertThat(testEmEmpResidences.getDatoTo()).isEqualTo(DEFAULT_DATO_TO);
        assertThat(testEmEmpResidences.getAddressWork()).isEqualTo(DEFAULT_ADDRESS_WORK);
        assertThat(testEmEmpResidences.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testEmEmpResidences.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testEmEmpResidences.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testEmEmpResidences.getUpdatedAt()).isEqualTo(DEFAULT_UPDATED_AT);
    }

    @Test
    @Transactional
    public void createEmEmpResidencesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = emEmpResidencesRepository.findAll().size();

        // Create the EmEmpResidences with an existing ID
        emEmpResidences.setId(1L);
        EmEmpResidencesDTO emEmpResidencesDTO = emEmpResidencesMapper.toDto(emEmpResidences);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmEmpResidencesMockMvc.perform(post("/api/em-emp-residences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpResidencesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the EmEmpResidences in the database
        List<EmEmpResidences> emEmpResidencesList = emEmpResidencesRepository.findAll();
        assertThat(emEmpResidencesList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEmEmpResidences() throws Exception {
        // Initialize the database
        emEmpResidencesRepository.saveAndFlush(emEmpResidences);

        // Get all the emEmpResidencesList
        restEmEmpResidencesMockMvc.perform(get("/api/em-emp-residences?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(emEmpResidences.getId().intValue())))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].dateFrom").value(hasItem(DEFAULT_DATE_FROM.toString())))
            .andExpect(jsonPath("$.[*].datoTo").value(hasItem(DEFAULT_DATO_TO.toString())))
            .andExpect(jsonPath("$.[*].addressWork").value(hasItem(DEFAULT_ADDRESS_WORK.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    public void getEmEmpResidences() throws Exception {
        // Initialize the database
        emEmpResidencesRepository.saveAndFlush(emEmpResidences);

        // Get the emEmpResidences
        restEmEmpResidencesMockMvc.perform(get("/api/em-emp-residences/{id}", emEmpResidences.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(emEmpResidences.getId().intValue()))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS.toString()))
            .andExpect(jsonPath("$.dateFrom").value(DEFAULT_DATE_FROM.toString()))
            .andExpect(jsonPath("$.datoTo").value(DEFAULT_DATO_TO.toString()))
            .andExpect(jsonPath("$.addressWork").value(DEFAULT_ADDRESS_WORK.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingEmEmpResidences() throws Exception {
        // Get the emEmpResidences
        restEmEmpResidencesMockMvc.perform(get("/api/em-emp-residences/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEmEmpResidences() throws Exception {
        // Initialize the database
        emEmpResidencesRepository.saveAndFlush(emEmpResidences);
        int databaseSizeBeforeUpdate = emEmpResidencesRepository.findAll().size();

        // Update the emEmpResidences
        EmEmpResidences updatedEmEmpResidences = emEmpResidencesRepository.findOne(emEmpResidences.getId());
        // Disconnect from session so that the updates on updatedEmEmpResidences are not directly saved in db
        em.detach(updatedEmEmpResidences);
        updatedEmEmpResidences
            .address(UPDATED_ADDRESS)
            .dateFrom(UPDATED_DATE_FROM)
            .datoTo(UPDATED_DATO_TO)
            .addressWork(UPDATED_ADDRESS_WORK)
            .createdBy(UPDATED_CREATED_BY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedAt(UPDATED_UPDATED_AT);
        EmEmpResidencesDTO emEmpResidencesDTO = emEmpResidencesMapper.toDto(updatedEmEmpResidences);

        restEmEmpResidencesMockMvc.perform(put("/api/em-emp-residences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpResidencesDTO)))
            .andExpect(status().isOk());

        // Validate the EmEmpResidences in the database
        List<EmEmpResidences> emEmpResidencesList = emEmpResidencesRepository.findAll();
        assertThat(emEmpResidencesList).hasSize(databaseSizeBeforeUpdate);
        EmEmpResidences testEmEmpResidences = emEmpResidencesList.get(emEmpResidencesList.size() - 1);
        assertThat(testEmEmpResidences.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testEmEmpResidences.getDateFrom()).isEqualTo(UPDATED_DATE_FROM);
        assertThat(testEmEmpResidences.getDatoTo()).isEqualTo(UPDATED_DATO_TO);
        assertThat(testEmEmpResidences.getAddressWork()).isEqualTo(UPDATED_ADDRESS_WORK);
        assertThat(testEmEmpResidences.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testEmEmpResidences.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testEmEmpResidences.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testEmEmpResidences.getUpdatedAt()).isEqualTo(UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingEmEmpResidences() throws Exception {
        int databaseSizeBeforeUpdate = emEmpResidencesRepository.findAll().size();

        // Create the EmEmpResidences
        EmEmpResidencesDTO emEmpResidencesDTO = emEmpResidencesMapper.toDto(emEmpResidences);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restEmEmpResidencesMockMvc.perform(put("/api/em-emp-residences")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpResidencesDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpResidences in the database
        List<EmEmpResidences> emEmpResidencesList = emEmpResidencesRepository.findAll();
        assertThat(emEmpResidencesList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteEmEmpResidences() throws Exception {
        // Initialize the database
        emEmpResidencesRepository.saveAndFlush(emEmpResidences);
        int databaseSizeBeforeDelete = emEmpResidencesRepository.findAll().size();

        // Get the emEmpResidences
        restEmEmpResidencesMockMvc.perform(delete("/api/em-emp-residences/{id}", emEmpResidences.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<EmEmpResidences> emEmpResidencesList = emEmpResidencesRepository.findAll();
        assertThat(emEmpResidencesList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpResidences.class);
        EmEmpResidences emEmpResidences1 = new EmEmpResidences();
        emEmpResidences1.setId(1L);
        EmEmpResidences emEmpResidences2 = new EmEmpResidences();
        emEmpResidences2.setId(emEmpResidences1.getId());
        assertThat(emEmpResidences1).isEqualTo(emEmpResidences2);
        emEmpResidences2.setId(2L);
        assertThat(emEmpResidences1).isNotEqualTo(emEmpResidences2);
        emEmpResidences1.setId(null);
        assertThat(emEmpResidences1).isNotEqualTo(emEmpResidences2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpResidencesDTO.class);
        EmEmpResidencesDTO emEmpResidencesDTO1 = new EmEmpResidencesDTO();
        emEmpResidencesDTO1.setId(1L);
        EmEmpResidencesDTO emEmpResidencesDTO2 = new EmEmpResidencesDTO();
        assertThat(emEmpResidencesDTO1).isNotEqualTo(emEmpResidencesDTO2);
        emEmpResidencesDTO2.setId(emEmpResidencesDTO1.getId());
        assertThat(emEmpResidencesDTO1).isEqualTo(emEmpResidencesDTO2);
        emEmpResidencesDTO2.setId(2L);
        assertThat(emEmpResidencesDTO1).isNotEqualTo(emEmpResidencesDTO2);
        emEmpResidencesDTO1.setId(null);
        assertThat(emEmpResidencesDTO1).isNotEqualTo(emEmpResidencesDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(emEmpResidencesMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(emEmpResidencesMapper.fromId(null)).isNull();
    }
}
