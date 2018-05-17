package com.infostudio.ba.web.rest;

import com.infostudio.ba.HcmEmpMicroserviceApp;

import com.infostudio.ba.domain.EmEmpMetaData;
import com.infostudio.ba.repository.EmEmpMetaDataRepository;
import com.infostudio.ba.service.dto.EmEmpMetaDataDTO;
import com.infostudio.ba.service.mapper.EmEmpMetaDataMapper;
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
 * Test class for the EmEmpMetaDataResource REST controller.
 *
 * @see EmEmpMetaDataResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HcmEmpMicroserviceApp.class)
public class EmEmpMetaDataResourceIntTest {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_VALUE = "BBBBBBBBBB";

    private static final String DEFAULT_DISPLAYVALUE = "AAAAAAAAAA";
    private static final String UPDATED_DISPLAYVALUE = "BBBBBBBBBB";

    private static final Double DEFAULT_ORDERING = 1D;
    private static final Double UPDATED_ORDERING = 2D;

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private EmEmpMetaDataRepository emEmpMetaDataRepository;

    @Autowired
    private EmEmpMetaDataMapper emEmpMetaDataMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEmEmpMetaDataMockMvc;

    private EmEmpMetaData emEmpMetaData;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EmEmpMetaDataResource emEmpMetaDataResource = new EmEmpMetaDataResource(emEmpMetaDataRepository, emEmpMetaDataMapper);
        this.restEmEmpMetaDataMockMvc = MockMvcBuilders.standaloneSetup(emEmpMetaDataResource)
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
    public static EmEmpMetaData createEntity(EntityManager em) {
        EmEmpMetaData emEmpMetaData = new EmEmpMetaData()
            .title(DEFAULT_TITLE)
            .value(DEFAULT_VALUE)
            .displayvalue(DEFAULT_DISPLAYVALUE)
            .ordering(DEFAULT_ORDERING)
            .createdBy(DEFAULT_CREATED_BY)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedBy(DEFAULT_UPDATED_BY)
            .updatedAt(DEFAULT_UPDATED_AT);
        return emEmpMetaData;
    }

    @Before
    public void initTest() {
        emEmpMetaData = createEntity(em);
    }

    @Test
    @Transactional
    public void createEmEmpMetaData() throws Exception {
        int databaseSizeBeforeCreate = emEmpMetaDataRepository.findAll().size();

        // Create the EmEmpMetaData
        EmEmpMetaDataDTO emEmpMetaDataDTO = emEmpMetaDataMapper.toDto(emEmpMetaData);
        restEmEmpMetaDataMockMvc.perform(post("/api/em-emp-meta-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpMetaDataDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpMetaData in the database
        List<EmEmpMetaData> emEmpMetaDataList = emEmpMetaDataRepository.findAll();
        assertThat(emEmpMetaDataList).hasSize(databaseSizeBeforeCreate + 1);
        EmEmpMetaData testEmEmpMetaData = emEmpMetaDataList.get(emEmpMetaDataList.size() - 1);
        assertThat(testEmEmpMetaData.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testEmEmpMetaData.getValue()).isEqualTo(DEFAULT_VALUE);
        assertThat(testEmEmpMetaData.getDisplayvalue()).isEqualTo(DEFAULT_DISPLAYVALUE);
        assertThat(testEmEmpMetaData.getOrdering()).isEqualTo(DEFAULT_ORDERING);
        assertThat(testEmEmpMetaData.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testEmEmpMetaData.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testEmEmpMetaData.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testEmEmpMetaData.getUpdatedAt()).isEqualTo(DEFAULT_UPDATED_AT);
    }

    @Test
    @Transactional
    public void createEmEmpMetaDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = emEmpMetaDataRepository.findAll().size();

        // Create the EmEmpMetaData with an existing ID
        emEmpMetaData.setId(1L);
        EmEmpMetaDataDTO emEmpMetaDataDTO = emEmpMetaDataMapper.toDto(emEmpMetaData);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmEmpMetaDataMockMvc.perform(post("/api/em-emp-meta-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpMetaDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the EmEmpMetaData in the database
        List<EmEmpMetaData> emEmpMetaDataList = emEmpMetaDataRepository.findAll();
        assertThat(emEmpMetaDataList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEmEmpMetaData() throws Exception {
        // Initialize the database
        emEmpMetaDataRepository.saveAndFlush(emEmpMetaData);

        // Get all the emEmpMetaDataList
        restEmEmpMetaDataMockMvc.perform(get("/api/em-emp-meta-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(emEmpMetaData.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].value").value(hasItem(DEFAULT_VALUE.toString())))
            .andExpect(jsonPath("$.[*].displayvalue").value(hasItem(DEFAULT_DISPLAYVALUE.toString())))
            .andExpect(jsonPath("$.[*].ordering").value(hasItem(DEFAULT_ORDERING.doubleValue())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    public void getEmEmpMetaData() throws Exception {
        // Initialize the database
        emEmpMetaDataRepository.saveAndFlush(emEmpMetaData);

        // Get the emEmpMetaData
        restEmEmpMetaDataMockMvc.perform(get("/api/em-emp-meta-data/{id}", emEmpMetaData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(emEmpMetaData.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.value").value(DEFAULT_VALUE.toString()))
            .andExpect(jsonPath("$.displayvalue").value(DEFAULT_DISPLAYVALUE.toString()))
            .andExpect(jsonPath("$.ordering").value(DEFAULT_ORDERING.doubleValue()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingEmEmpMetaData() throws Exception {
        // Get the emEmpMetaData
        restEmEmpMetaDataMockMvc.perform(get("/api/em-emp-meta-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEmEmpMetaData() throws Exception {
        // Initialize the database
        emEmpMetaDataRepository.saveAndFlush(emEmpMetaData);
        int databaseSizeBeforeUpdate = emEmpMetaDataRepository.findAll().size();

        // Update the emEmpMetaData
        EmEmpMetaData updatedEmEmpMetaData = emEmpMetaDataRepository.findOne(emEmpMetaData.getId());
        // Disconnect from session so that the updates on updatedEmEmpMetaData are not directly saved in db
        em.detach(updatedEmEmpMetaData);
        updatedEmEmpMetaData
            .title(UPDATED_TITLE)
            .value(UPDATED_VALUE)
            .displayvalue(UPDATED_DISPLAYVALUE)
            .ordering(UPDATED_ORDERING)
            .createdBy(UPDATED_CREATED_BY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedAt(UPDATED_UPDATED_AT);
        EmEmpMetaDataDTO emEmpMetaDataDTO = emEmpMetaDataMapper.toDto(updatedEmEmpMetaData);

        restEmEmpMetaDataMockMvc.perform(put("/api/em-emp-meta-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpMetaDataDTO)))
            .andExpect(status().isOk());

        // Validate the EmEmpMetaData in the database
        List<EmEmpMetaData> emEmpMetaDataList = emEmpMetaDataRepository.findAll();
        assertThat(emEmpMetaDataList).hasSize(databaseSizeBeforeUpdate);
        EmEmpMetaData testEmEmpMetaData = emEmpMetaDataList.get(emEmpMetaDataList.size() - 1);
        assertThat(testEmEmpMetaData.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testEmEmpMetaData.getValue()).isEqualTo(UPDATED_VALUE);
        assertThat(testEmEmpMetaData.getDisplayvalue()).isEqualTo(UPDATED_DISPLAYVALUE);
        assertThat(testEmEmpMetaData.getOrdering()).isEqualTo(UPDATED_ORDERING);
        assertThat(testEmEmpMetaData.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testEmEmpMetaData.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testEmEmpMetaData.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testEmEmpMetaData.getUpdatedAt()).isEqualTo(UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingEmEmpMetaData() throws Exception {
        int databaseSizeBeforeUpdate = emEmpMetaDataRepository.findAll().size();

        // Create the EmEmpMetaData
        EmEmpMetaDataDTO emEmpMetaDataDTO = emEmpMetaDataMapper.toDto(emEmpMetaData);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restEmEmpMetaDataMockMvc.perform(put("/api/em-emp-meta-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpMetaDataDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpMetaData in the database
        List<EmEmpMetaData> emEmpMetaDataList = emEmpMetaDataRepository.findAll();
        assertThat(emEmpMetaDataList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteEmEmpMetaData() throws Exception {
        // Initialize the database
        emEmpMetaDataRepository.saveAndFlush(emEmpMetaData);
        int databaseSizeBeforeDelete = emEmpMetaDataRepository.findAll().size();

        // Get the emEmpMetaData
        restEmEmpMetaDataMockMvc.perform(delete("/api/em-emp-meta-data/{id}", emEmpMetaData.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<EmEmpMetaData> emEmpMetaDataList = emEmpMetaDataRepository.findAll();
        assertThat(emEmpMetaDataList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpMetaData.class);
        EmEmpMetaData emEmpMetaData1 = new EmEmpMetaData();
        emEmpMetaData1.setId(1L);
        EmEmpMetaData emEmpMetaData2 = new EmEmpMetaData();
        emEmpMetaData2.setId(emEmpMetaData1.getId());
        assertThat(emEmpMetaData1).isEqualTo(emEmpMetaData2);
        emEmpMetaData2.setId(2L);
        assertThat(emEmpMetaData1).isNotEqualTo(emEmpMetaData2);
        emEmpMetaData1.setId(null);
        assertThat(emEmpMetaData1).isNotEqualTo(emEmpMetaData2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpMetaDataDTO.class);
        EmEmpMetaDataDTO emEmpMetaDataDTO1 = new EmEmpMetaDataDTO();
        emEmpMetaDataDTO1.setId(1L);
        EmEmpMetaDataDTO emEmpMetaDataDTO2 = new EmEmpMetaDataDTO();
        assertThat(emEmpMetaDataDTO1).isNotEqualTo(emEmpMetaDataDTO2);
        emEmpMetaDataDTO2.setId(emEmpMetaDataDTO1.getId());
        assertThat(emEmpMetaDataDTO1).isEqualTo(emEmpMetaDataDTO2);
        emEmpMetaDataDTO2.setId(2L);
        assertThat(emEmpMetaDataDTO1).isNotEqualTo(emEmpMetaDataDTO2);
        emEmpMetaDataDTO1.setId(null);
        assertThat(emEmpMetaDataDTO1).isNotEqualTo(emEmpMetaDataDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(emEmpMetaDataMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(emEmpMetaDataMapper.fromId(null)).isNull();
    }
}
