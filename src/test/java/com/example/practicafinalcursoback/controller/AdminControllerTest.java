package com.example.practicafinalcursoback.controller;

import application.controller.AdminController;
import application.dto.AdminDTO;
import application.mapper.AdminMapper;
import application.model.Admin;
import application.repository.AdminRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ContextConfiguration(classes = {AdminController.class})
@DataMongoTest
@EnableMongoRepositories(basePackages = {"java.application.repository.*"})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JacksonTester<AdminDTO> jacksonTester;

    private ObjectMapper objectMapper;
    @InjectMocks
    private AdminController controller;
    @MockBean
    private AdminRepository repository;
    @MockBean
    private AdminMapper mapper;
    private Admin admin;

    @BeforeAll
    private void beforeAll() {
        admin = new Admin("Admin", "admin@gmail.com", "admin", "foto");
        objectMapper = new ObjectMapper();
    }

    @Test
    @Order(1)
    void getAll() throws Exception {
        when(repository.findAll()).thenReturn(List.of(admin));
        MockHttpServletResponse response = mockMvc.perform(get("/admin/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        List<Admin> admins = mapper.toModelList(List.of(objectMapper.readValue(response.getContentAsString(), AdminDTO[].class)));
        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.OK.value())
        );
        verify(repository, times(1)).findAll();
    }

    @Test
    @Order(2)
    void postAdmin() {

    }

    @Test
    @Order(3)
    void getAdminById() {

    }

    @Test
    @Order(4)
    void updateAdmin() {

    }

    @Test
    @Order(5)
    void deleteAdmin() {

    }
}
