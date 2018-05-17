package com.infostudio.ba.web.rest;

import com.infostudio.ba.HcmEmpMicroserviceApp;

import com.infostudio.ba.domain.EmEmpContacts;
import com.infostudio.ba.repository.EmEmpContactsRepository;
import com.infostudio.ba.service.dto.EmEmpContactsDTO;
import com.infostudio.ba.service.mapper.EmEmpContactsMapper;
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
 * Test class for the EmEmpContactsResource REST controller.
 *
 * @see EmEmpContactsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HcmEmpMicroserviceApp.class)
public class EmEmpContactsResourceIntTest {

    private static final String DEFAULT_CONTACT = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private EmEmpContactsRepository emEmpContactsRepository;

    @Autowired
    private EmEmpContactsMapper emEmpContactsMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEmEmpContactsMockMvc;

    private EmEmpContacts emEmpContacts;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EmEmpContactsResource emEmpContactsResource = new EmEmpContactsResource(emEmpContactsRepository, emEmpContactsMapper);
        this.restEmEmpContactsMockMvc = MockMvcBuilders.standaloneSetup(emEmpContactsResource)
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
    public static EmEmpContacts createEntity(EntityManager em) {
        EmEmpContacts emEmpContacts = new EmEmpContacts()
            .contact(DEFAULT_CONTACT)
            .description(DEFAULT_DESCRIPTION)
            .createdBy(DEFAULT_CREATED_BY)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedBy(DEFAULT_UPDATED_BY)
            .updatedAt(DEFAULT_UPDATED_AT);
        return emEmpContacts;
    }

    @Before
    public void initTest() {
        emEmpContacts = createEntity(em);
    }

    @Test
    @Transactional
    public void createEmEmpContacts() throws Exception {
        int databaseSizeBeforeCreate = emEmpContactsRepository.findAll().size();

        // Create the EmEmpContacts
        EmEmpContactsDTO emEmpContactsDTO = emEmpContactsMapper.toDto(emEmpContacts);
        restEmEmpContactsMockMvc.perform(post("/api/em-emp-contacts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpContactsDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpContacts in the database
        List<EmEmpContacts> emEmpContactsList = emEmpContactsRepository.findAll();
        assertThat(emEmpContactsList).hasSize(databaseSizeBeforeCreate + 1);
        EmEmpContacts testEmEmpContacts = emEmpContactsList.get(emEmpContactsList.size() - 1);
        assertThat(testEmEmpContacts.getContact()).isEqualTo(DEFAULT_CONTACT);
        assertThat(testEmEmpContacts.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testEmEmpContacts.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testEmEmpContacts.getCreatedAt()).isEqualTo(DEFAULT_CREATED_AT);
        assertThat(testEmEmpContacts.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testEmEmpContacts.getUpdatedAt()).isEqualTo(DEFAULT_UPDATED_AT);
    }

    @Test
    @Transactional
    public void createEmEmpContactsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = emEmpContactsRepository.findAll().size();

        // Create the EmEmpContacts with an existing ID
        emEmpContacts.setId(1L);
        EmEmpContactsDTO emEmpContactsDTO = emEmpContactsMapper.toDto(emEmpContacts);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmEmpContactsMockMvc.perform(post("/api/em-emp-contacts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpContactsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the EmEmpContacts in the database
        List<EmEmpContacts> emEmpContactsList = emEmpContactsRepository.findAll();
        assertThat(emEmpContactsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEmEmpContacts() throws Exception {
        // Initialize the database
        emEmpContactsRepository.saveAndFlush(emEmpContacts);

        // Get all the emEmpContactsList
        restEmEmpContactsMockMvc.perform(get("/api/em-emp-contacts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(emEmpContacts.getId().intValue())))
            .andExpect(jsonPath("$.[*].contact").value(hasItem(DEFAULT_CONTACT.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    public void getEmEmpContacts() throws Exception {
        // Initialize the database
        emEmpContactsRepository.saveAndFlush(emEmpContacts);

        // Get the emEmpContacts
        restEmEmpContactsMockMvc.perform(get("/api/em-emp-contacts/{id}", emEmpContacts.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(emEmpContacts.getId().intValue()))
            .andExpect(jsonPath("$.contact").value(DEFAULT_CONTACT.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingEmEmpContacts() throws Exception {
        // Get the emEmpContacts
        restEmEmpContactsMockMvc.perform(get("/api/em-emp-contacts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEmEmpContacts() throws Exception {
        // Initialize the database
        emEmpContactsRepository.saveAndFlush(emEmpContacts);
        int databaseSizeBeforeUpdate = emEmpContactsRepository.findAll().size();

        // Update the emEmpContacts
        EmEmpContacts updatedEmEmpContacts = emEmpContactsRepository.findOne(emEmpContacts.getId());
        // Disconnect from session so that the updates on updatedEmEmpContacts are not directly saved in db
        em.detach(updatedEmEmpContacts);
        updatedEmEmpContacts
            .contact(UPDATED_CONTACT)
            .description(UPDATED_DESCRIPTION)
            .createdBy(UPDATED_CREATED_BY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedAt(UPDATED_UPDATED_AT);
        EmEmpContactsDTO emEmpContactsDTO = emEmpContactsMapper.toDto(updatedEmEmpContacts);

        restEmEmpContactsMockMvc.perform(put("/api/em-emp-contacts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpContactsDTO)))
            .andExpect(status().isOk());

        // Validate the EmEmpContacts in the database
        List<EmEmpContacts> emEmpContactsList = emEmpContactsRepository.findAll();
        assertThat(emEmpContactsList).hasSize(databaseSizeBeforeUpdate);
        EmEmpContacts testEmEmpContacts = emEmpContactsList.get(emEmpContactsList.size() - 1);
        assertThat(testEmEmpContacts.getContact()).isEqualTo(UPDATED_CONTACT);
        assertThat(testEmEmpContacts.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testEmEmpContacts.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testEmEmpContacts.getCreatedAt()).isEqualTo(UPDATED_CREATED_AT);
        assertThat(testEmEmpContacts.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testEmEmpContacts.getUpdatedAt()).isEqualTo(UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    public void updateNonExistingEmEmpContacts() throws Exception {
        int databaseSizeBeforeUpdate = emEmpContactsRepository.findAll().size();

        // Create the EmEmpContacts
        EmEmpContactsDTO emEmpContactsDTO = emEmpContactsMapper.toDto(emEmpContacts);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restEmEmpContactsMockMvc.perform(put("/api/em-emp-contacts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emEmpContactsDTO)))
            .andExpect(status().isCreated());

        // Validate the EmEmpContacts in the database
        List<EmEmpContacts> emEmpContactsList = emEmpContactsRepository.findAll();
        assertThat(emEmpContactsList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteEmEmpContacts() throws Exception {
        // Initialize the database
        emEmpContactsRepository.saveAndFlush(emEmpContacts);
        int databaseSizeBeforeDelete = emEmpContactsRepository.findAll().size();

        // Get the emEmpContacts
        restEmEmpContactsMockMvc.perform(delete("/api/em-emp-contacts/{id}", emEmpContacts.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<EmEmpContacts> emEmpContactsList = emEmpContactsRepository.findAll();
        assertThat(emEmpContactsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpContacts.class);
        EmEmpContacts emEmpContacts1 = new EmEmpContacts();
        emEmpContacts1.setId(1L);
        EmEmpContacts emEmpContacts2 = new EmEmpContacts();
        emEmpContacts2.setId(emEmpContacts1.getId());
        assertThat(emEmpContacts1).isEqualTo(emEmpContacts2);
        emEmpContacts2.setId(2L);
        assertThat(emEmpContacts1).isNotEqualTo(emEmpContacts2);
        emEmpContacts1.setId(null);
        assertThat(emEmpContacts1).isNotEqualTo(emEmpContacts2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmEmpContactsDTO.class);
        EmEmpContactsDTO emEmpContactsDTO1 = new EmEmpContactsDTO();
        emEmpContactsDTO1.setId(1L);
        EmEmpContactsDTO emEmpContactsDTO2 = new EmEmpContactsDTO();
        assertThat(emEmpContactsDTO1).isNotEqualTo(emEmpContactsDTO2);
        emEmpContactsDTO2.setId(emEmpContactsDTO1.getId());
        assertThat(emEmpContactsDTO1).isEqualTo(emEmpContactsDTO2);
        emEmpContactsDTO2.setId(2L);
        assertThat(emEmpContactsDTO1).isNotEqualTo(emEmpContactsDTO2);
        emEmpContactsDTO1.setId(null);
        assertThat(emEmpContactsDTO1).isNotEqualTo(emEmpContactsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(emEmpContactsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(emEmpContactsMapper.fromId(null)).isNull();
    }
}
