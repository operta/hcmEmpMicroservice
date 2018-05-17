package com.infostudio.ba.web.rest;

import com.infostudio.ba.HcmEmpMicroserviceApp;

import com.infostudio.ba.domain.EmEmpCitizenships;
import com.infostudio.ba.repository.EmEmpCitizenshipsRepository;
import com.infostudio.ba.service.dto.EmEmpCitizenshipsDTO;
import com.infostudio.ba.service.mapper.EmEmpCitizenshipsMapper;
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
 * Test class for the EmEmpCitizenshipsResource REST controller.
 *
 * @see EmEmpCitizenshipsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HcmEmpMicroserviceApp.class)
public class EmEmpCitizenshipsResourceIntTest {

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private EmEmpCitizenshipsRepository emEmpCitizenshipsRepository;

    @Autowired
    private EmEmpCitizenshipsMapper emEmpCitizenshipsMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEmEmpCitizenshipsMockMvc;

    private EmEmpCitizenships emEmpCitizenships;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EmEmpCitizenshipsResource emEmpCitizenshipsResource = new EmEmpCitizenshipsResource(emEmpCitizenshipsRepository, emEmpCitizenshipsMapper);
        this.restEmEmpCitizenshipsMockMvc = MockMvcBuilders.standaloneSetup(emEmpCitizenshipsResource)
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
    public static EmEmpCitizenships createEntity(EntityManager em) {
        EmEmpCitizenships emEmpCitizenships = new EmEmpCitizenships()
            .createdBy(DEFAULT_CREATED_BY)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedBy(DEFAULT_UPDATED_BY)
            .updatedAt(DEFAULT_UPDATED_AT);
        return emEmpCitizenships;
    }

    @Before
    public void initTest() {
        emEmpCitizenships = createEntity(em);
    }

    @Test
    @Transactional
    public void createEmEmpCitizenships() throws Exception {
        int databaseSizeBeforeCreate = emEmpCitizenshipsRepository.findAll().size();

        // Create the EmEmpCitizenships
        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO = emEmpCitizenshipsMapper.toDto(emEmpCitizenships);
        restEmEmpCitizenshipsMockMvc.perform(post("/api/em-emp-citizenships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpCitizenshipsDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpCitizenships in the database
        List<EmEmpCitizenships> emEmpCitizenshipsList = emEmpCitizenshipsRepository.findAll();
        assertThat(emEmpCitizenshipsList).hasSize(databaseSizeBeforeCreate + 1);
        EmEmpCitizenships testEmEmpCitizenships = emEmpCitizenshipsList.get(emEmpCitizenshipsList.size() - 1);
        assertThat(testEmEmpCitizenships.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testEmEmpCitizenships.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testEmEmpCitizenships.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testEmEmpCitizenships.getUpdatedAt()).isEqualTo(DEFAULT_UPDATED_AT);
    }

    @Test
    @Transactional
    public void createEmEmpCitizenshipsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = emEmpCitizenshipsRepository.findAll().size();

        // Create the EmEmpCitizenships with an existing ID
        emEmpCitizenships.setId(1L);
        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO = emEmpCitizenshipsMapper.toDto(emEmpCitizenships);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmEmpCitizenshipsMockMvc.perform(post("/api/em-emp-citizenships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpCitizenshipsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the EmEmpCitizenships in the database
        List<EmEmpCitizenships> emEmpCitizenshipsList = emEmpCitizenshipsRepository.findAll();
        assertThat(emEmpCitizenshipsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEmEmpCitizenships() throws Exception {
        // Initialize the database
        emEmpCitizenshipsRepository.saveAndFlush(emEmpCitizenships);

        // Get all the emEmpCitizenshipsList
        restEmEmpCitizenshipsMockMvc.perform(get("/api/em-emp-citizenships?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(emEmpCitizenships.getId().intValue())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    public void getEmEmpCitizenships() throws Exception {
        // Initialize the database
        emEmpCitizenshipsRepository.saveAndFlush(emEmpCitizenships);

        // Get the emEmpCitizenships
        restEmEmpCitizenshipsMockMvc.perform(get("/api/em-emp-citizenships/{id}", emEmpCitizenships.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(emEmpCitizenships.getId().intValue()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingEmEmpCitizenships() throws Exception {
        // Get the emEmpCitizenships
        restEmEmpCitizenshipsMockMvc.perform(get("/api/em-emp-citizenships/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEmEmpCitizenships() throws Exception {
        // Initialize the database
        emEmpCitizenshipsRepository.saveAndFlush(emEmpCitizenships);
        int databaseSizeBeforeUpdate = emEmpCitizenshipsRepository.findAll().size();

        // Update the emEmpCitizenships
        EmEmpCitizenships updatedEmEmpCitizenships = emEmpCitizenshipsRepository.findOne(emEmpCitizenships.getId());
        // Disconnect from session so that the updates on updatedEmEmpCitizenships are not directly saved in db
        em.detach(updatedEmEmpCitizenships);
        updatedEmEmpCitizenships
            .createdBy(UPDATED_CREATED_BY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedAt(UPDATED_UPDATED_AT);
        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO = emEmpCitizenshipsMapper.toDto(updatedEmEmpCitizenships);

        restEmEmpCitizenshipsMockMvc.perform(put("/api/em-emp-citizenships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpCitizenshipsDTO)))
            .andExpect(status().isOk());

        // Validate the EmEmpCitizenships in the database
        List<EmEmpCitizenships> emEmpCitizenshipsList = emEmpCitizenshipsRepository.findAll();
        assertThat(emEmpCitizenshipsList).hasSize(databaseSizeBeforeUpdate);
        EmEmpCitizenships testEmEmpCitizenships = emEmpCitizenshipsList.get(emEmpCitizenshipsList.size() - 1);
        assertThat(testEmEmpCitizenships.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testEmEmpCitizenships.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testEmEmpCitizenships.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testEmEmpCitizenships.getUpdatedAt()).isEqualTo(UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingEmEmpCitizenships() throws Exception {
        int databaseSizeBeforeUpdate = emEmpCitizenshipsRepository.findAll().size();

        // Create the EmEmpCitizenships
        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO = emEmpCitizenshipsMapper.toDto(emEmpCitizenships);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restEmEmpCitizenshipsMockMvc.perform(put("/api/em-emp-citizenships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpCitizenshipsDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpCitizenships in the database
        List<EmEmpCitizenships> emEmpCitizenshipsList = emEmpCitizenshipsRepository.findAll();
        assertThat(emEmpCitizenshipsList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteEmEmpCitizenships() throws Exception {
        // Initialize the database
        emEmpCitizenshipsRepository.saveAndFlush(emEmpCitizenships);
        int databaseSizeBeforeDelete = emEmpCitizenshipsRepository.findAll().size();

        // Get the emEmpCitizenships
        restEmEmpCitizenshipsMockMvc.perform(delete("/api/em-emp-citizenships/{id}", emEmpCitizenships.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<EmEmpCitizenships> emEmpCitizenshipsList = emEmpCitizenshipsRepository.findAll();
        assertThat(emEmpCitizenshipsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpCitizenships.class);
        EmEmpCitizenships emEmpCitizenships1 = new EmEmpCitizenships();
        emEmpCitizenships1.setId(1L);
        EmEmpCitizenships emEmpCitizenships2 = new EmEmpCitizenships();
        emEmpCitizenships2.setId(emEmpCitizenships1.getId());
        assertThat(emEmpCitizenships1).isEqualTo(emEmpCitizenships2);
        emEmpCitizenships2.setId(2L);
        assertThat(emEmpCitizenships1).isNotEqualTo(emEmpCitizenships2);
        emEmpCitizenships1.setId(null);
        assertThat(emEmpCitizenships1).isNotEqualTo(emEmpCitizenships2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpCitizenshipsDTO.class);
        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO1 = new EmEmpCitizenshipsDTO();
        emEmpCitizenshipsDTO1.setId(1L);
        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO2 = new EmEmpCitizenshipsDTO();
        assertThat(emEmpCitizenshipsDTO1).isNotEqualTo(emEmpCitizenshipsDTO2);
        emEmpCitizenshipsDTO2.setId(emEmpCitizenshipsDTO1.getId());
        assertThat(emEmpCitizenshipsDTO1).isEqualTo(emEmpCitizenshipsDTO2);
        emEmpCitizenshipsDTO2.setId(2L);
        assertThat(emEmpCitizenshipsDTO1).isNotEqualTo(emEmpCitizenshipsDTO2);
        emEmpCitizenshipsDTO1.setId(null);
        assertThat(emEmpCitizenshipsDTO1).isNotEqualTo(emEmpCitizenshipsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(emEmpCitizenshipsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(emEmpCitizenshipsMapper.fromId(null)).isNull();
    }
}
