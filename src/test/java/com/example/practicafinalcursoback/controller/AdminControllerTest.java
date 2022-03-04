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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes = {AdminController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdminControllerTest {

    private List<AdminDTO> adminsDTO;
    private List<Admin> admins;
    @InjectMocks
    private AdminController controller;
    @MockBean
    private AdminRepository repository;
    @MockBean
    private AdminMapper mapper;
    private Admin admin;
    private AdminDTO adminDTO;

    @BeforeAll
    void beforeAll() {
        controller = new AdminController(repository, mapper);
        admin = new Admin(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), "Admin", "admin@gmail.com", "admin", "foto");
        adminDTO = new AdminDTO(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), "Admin", "admin@gmail.com", "admin", "foto");
        admins = new ArrayList<>();
        admins.add(admin);
        adminsDTO = new ArrayList<>();
        adminsDTO.add(adminDTO);
    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(admins);
        when(mapper.toDTOList(admins)).thenReturn(adminsDTO);
        ResponseEntity<List<AdminDTO>> response = controller.getAllAdmin();
        List<AdminDTO> responseList = response.getBody();
        assertAll(
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(admins.size(), responseList.size()),
                () -> assertEquals(adminsDTO.size(), responseList.size()),
                () -> assertEquals(admins.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(adminsDTO.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(admins.get(0).getCorreo(), responseList.get(0).getEmail()),
                () -> assertEquals(adminsDTO.get(0).getEmail(), responseList.get(0).getEmail()),
                () -> assertEquals(admins.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(adminsDTO.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(admins.get(0).getNombre(), responseList.get(0).getNombre()),
                () -> assertEquals(adminsDTO.get(0).getNombre(), responseList.get(0).getNombre()),
                () -> assertEquals(admins.get(0).getPassword(), responseList.get(0).getPassword()),
                () -> assertEquals(adminsDTO.get(0).getPassword(), responseList.get(0).getPassword())
        );
        verify(repository, times(1)).findAll();
    }

    @Test
    @Order(2)
    void postAdmin() {
        when(repository.insert(admin)).thenReturn(admin);
        when(mapper.toModel(adminDTO)).thenReturn(admin);
        ResponseEntity<AdminDTO> response = controller.postAdmin(adminDTO);
        AdminDTO adminDTOResponse = response.getBody();
        //asserts
        verify(repository, times(1)).insert(admin);
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
