package com.infostudio.ba.web.rest;

import com.infostudio.ba.HcmEmpMicroserviceApp;

import com.infostudio.ba.domain.EmEmpDisabilities;
import com.infostudio.ba.repository.EmEmpDisabilitiesRepository;
import com.infostudio.ba.service.dto.EmEmpDisabilitiesDTO;
import com.infostudio.ba.service.mapper.EmEmpDisabilitiesMapper;
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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.infostudio.ba.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the EmEmpDisabilitiesResource REST controller.
 *
 * @see EmEmpDisabilitiesResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HcmEmpMicroserviceApp.class)
public class EmEmpDisabilitiesResourceIntTest {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Double DEFAULT_PERCENTAGE = 1D;
    private static final Double UPDATED_PERCENTAGE = 2D;

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private EmEmpDisabilitiesRepository emEmpDisabilitiesRepository;

    @Autowired
    private EmEmpDisabilitiesMapper emEmpDisabilitiesMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEmEmpDisabilitiesMockMvc;

    private EmEmpDisabilities emEmpDisabilities;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EmEmpDisabilitiesResource emEmpDisabilitiesResource = new EmEmpDisabilitiesResource(emEmpDisabilitiesRepository, emEmpDisabilitiesMapper);
        this.restEmEmpDisabilitiesMockMvc = MockMvcBuilders.standaloneSetup(emEmpDisabilitiesResource)
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
    public static EmEmpDisabilities createEntity(EntityManager em) {
        EmEmpDisabilities emEmpDisabilities = new EmEmpDisabilities()
            .description(DEFAULT_DESCRIPTION)
            .percentage(DEFAULT_PERCENTAGE)
            .createdBy(DEFAULT_CREATED_BY)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedBy(DEFAULT_UPDATED_BY)
            .updatedAt(DEFAULT_UPDATED_AT);
        return emEmpDisabilities;
    }

    @Before
    public void initTest() {
        emEmpDisabilities = createEntity(em);
    }

    @Test
    @Transactional
    public void createEmEmpDisabilities() throws Exception {
        int databaseSizeBeforeCreate = emEmpDisabilitiesRepository.findAll().size();

        // Create the EmEmpDisabilities
        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO = emEmpDisabilitiesMapper.toDto(emEmpDisabilities);
        restEmEmpDisabilitiesMockMvc.perform(post("/api/em-emp-disabilities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpDisabilitiesDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpDisabilities in the database
        List<EmEmpDisabilities> emEmpDisabilitiesList = emEmpDisabilitiesRepository.findAll();
        assertThat(emEmpDisabilitiesList).hasSize(databaseSizeBeforeCreate + 1);
        EmEmpDisabilities testEmEmpDisabilities = emEmpDisabilitiesList.get(emEmpDisabilitiesList.size() - 1);
        assertThat(testEmEmpDisabilities.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testEmEmpDisabilities.getPercentage()).isEqualTo(DEFAULT_PERCENTAGE);
        assertThat(testEmEmpDisabilities.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testEmEmpDisabilities.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testEmEmpDisabilities.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testEmEmpDisabilities.getUpdatedAt()).isEqualTo(DEFAULT_UPDATED_AT);
    }

    @Test
    @Transactional
    public void createEmEmpDisabilitiesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = emEmpDisabilitiesRepository.findAll().size();

        // Create the EmEmpDisabilities with an existing ID
        emEmpDisabilities.setId(1L);
        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO = emEmpDisabilitiesMapper.toDto(emEmpDisabilities);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmEmpDisabilitiesMockMvc.perform(post("/api/em-emp-disabilities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpDisabilitiesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the EmEmpDisabilities in the database
        List<EmEmpDisabilities> emEmpDisabilitiesList = emEmpDisabilitiesRepository.findAll();
        assertThat(emEmpDisabilitiesList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEmEmpDisabilities() throws Exception {
        // Initialize the database
        emEmpDisabilitiesRepository.saveAndFlush(emEmpDisabilities);

        // Get all the emEmpDisabilitiesList
        restEmEmpDisabilitiesMockMvc.perform(get("/api/em-emp-disabilities?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(emEmpDisabilities.getId().intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].percentage").value(hasItem(DEFAULT_PERCENTAGE.doubleValue())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    public void getEmEmpDisabilities() throws Exception {
        // Initialize the database
        emEmpDisabilitiesRepository.saveAndFlush(emEmpDisabilities);

        // Get the emEmpDisabilities
        restEmEmpDisabilitiesMockMvc.perform(get("/api/em-emp-disabilities/{id}", emEmpDisabilities.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(emEmpDisabilities.getId().intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.percentage").value(DEFAULT_PERCENTAGE.doubleValue()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingEmEmpDisabilities() throws Exception {
        // Get the emEmpDisabilities
        restEmEmpDisabilitiesMockMvc.perform(get("/api/em-emp-disabilities/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEmEmpDisabilities() throws Exception {
        // Initialize the database
        emEmpDisabilitiesRepository.saveAndFlush(emEmpDisabilities);
        int databaseSizeBeforeUpdate = emEmpDisabilitiesRepository.findAll().size();

        // Update the emEmpDisabilities
        EmEmpDisabilities updatedEmEmpDisabilities = emEmpDisabilitiesRepository.findOne(emEmpDisabilities.getId());
        // Disconnect from session so that the updates on updatedEmEmpDisabilities are not directly saved in db
        em.detach(updatedEmEmpDisabilities);
        updatedEmEmpDisabilities
            .description(UPDATED_DESCRIPTION)
            .percentage(UPDATED_PERCENTAGE)
            .createdBy(UPDATED_CREATED_BY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedAt(UPDATED_UPDATED_AT);
        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO = emEmpDisabilitiesMapper.toDto(updatedEmEmpDisabilities);

        restEmEmpDisabilitiesMockMvc.perform(put("/api/em-emp-disabilities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpDisabilitiesDTO)))
            .andExpect(status().isOk());

        // Validate the EmEmpDisabilities in the database
        List<EmEmpDisabilities> emEmpDisabilitiesList = emEmpDisabilitiesRepository.findAll();
        assertThat(emEmpDisabilitiesList).hasSize(databaseSizeBeforeUpdate);
        EmEmpDisabilities testEmEmpDisabilities = emEmpDisabilitiesList.get(emEmpDisabilitiesList.size() - 1);
        assertThat(testEmEmpDisabilities.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testEmEmpDisabilities.getPercentage()).isEqualTo(UPDATED_PERCENTAGE);
        assertThat(testEmEmpDisabilities.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testEmEmpDisabilities.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testEmEmpDisabilities.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testEmEmpDisabilities.getUpdatedAt()).isEqualTo(UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingEmEmpDisabilities() throws Exception {
        int databaseSizeBeforeUpdate = emEmpDisabilitiesRepository.findAll().size();

        // Create the EmEmpDisabilities
        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO = emEmpDisabilitiesMapper.toDto(emEmpDisabilities);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restEmEmpDisabilitiesMockMvc.perform(put("/api/em-emp-disabilities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpDisabilitiesDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpDisabilities in the database
        List<EmEmpDisabilities> emEmpDisabilitiesList = emEmpDisabilitiesRepository.findAll();
        assertThat(emEmpDisabilitiesList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteEmEmpDisabilities() throws Exception {
        // Initialize the database
        emEmpDisabilitiesRepository.saveAndFlush(emEmpDisabilities);
        int databaseSizeBeforeDelete = emEmpDisabilitiesRepository.findAll().size();

        // Get the emEmpDisabilities
        restEmEmpDisabilitiesMockMvc.perform(delete("/api/em-emp-disabilities/{id}", emEmpDisabilities.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<EmEmpDisabilities> emEmpDisabilitiesList = emEmpDisabilitiesRepository.findAll();
        assertThat(emEmpDisabilitiesList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpDisabilities.class);
        EmEmpDisabilities emEmpDisabilities1 = new EmEmpDisabilities();
        emEmpDisabilities1.setId(1L);
        EmEmpDisabilities emEmpDisabilities2 = new EmEmpDisabilities();
        emEmpDisabilities2.setId(emEmpDisabilities1.getId());
        assertThat(emEmpDisabilities1).isEqualTo(emEmpDisabilities2);
        emEmpDisabilities2.setId(2L);
        assertThat(emEmpDisabilities1).isNotEqualTo(emEmpDisabilities2);
        emEmpDisabilities1.setId(null);
        assertThat(emEmpDisabilities1).isNotEqualTo(emEmpDisabilities2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpDisabilitiesDTO.class);
        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO1 = new EmEmpDisabilitiesDTO();
        emEmpDisabilitiesDTO1.setId(1L);
        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO2 = new EmEmpDisabilitiesDTO();
        assertThat(emEmpDisabilitiesDTO1).isNotEqualTo(emEmpDisabilitiesDTO2);
        emEmpDisabilitiesDTO2.setId(emEmpDisabilitiesDTO1.getId());
        assertThat(emEmpDisabilitiesDTO1).isEqualTo(emEmpDisabilitiesDTO2);
        emEmpDisabilitiesDTO2.setId(2L);
        assertThat(emEmpDisabilitiesDTO1).isNotEqualTo(emEmpDisabilitiesDTO2);
        emEmpDisabilitiesDTO1.setId(null);
        assertThat(emEmpDisabilitiesDTO1).isNotEqualTo(emEmpDisabilitiesDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(emEmpDisabilitiesMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(emEmpDisabilitiesMapper.fromId(null)).isNull();
    }
}
