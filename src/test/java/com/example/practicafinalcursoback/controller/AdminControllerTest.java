package com.example.practicafinalcursoback.controller;

import application.controller.AdminController;
import application.dto.AdminDTO;
import application.mapper.AdminMapper;
import application.model.Admin;
import application.repository.AdminRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {AdminController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdminControllerTest {

    private final List<Admin> admins = new ArrayList();
    @InjectMocks
    private AdminController controller;
    @MockBean
    private AdminRepository repository;
    @MockBean
    private AdminMapper mapper;
    private Admin admin;

    @BeforeAll
    void beforeAll() {
        controller = new AdminController(repository, mapper);
        admin = new Admin("Admin", "admin@gmail.com", "admin", "foto");
        admins.add(admin);
    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(admins);
        ResponseEntity<List<AdminDTO>> response = controller.getAllAdmin();
        //assertAll(
        //        () -> assertEquals(response.getStatusCode(), HttpStatus.OK.value())
        //);
        //verify(repository, times(1)).findAll();
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
