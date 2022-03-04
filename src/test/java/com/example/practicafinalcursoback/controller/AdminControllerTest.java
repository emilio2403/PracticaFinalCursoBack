package com.example.practicafinalcursoback.controller;

import application.controller.AdminController;
import application.dto.AdminDTO;
import application.error.GeneralError;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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
                () -> assertTrue(responseList.size() > 0),
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
        verify(mapper, times(1)).toDTOList(admins);
    }

    @Test
    @Order(2)
    void postAdmin() {
        when(repository.insert(admin)).thenReturn(admin);
        when(mapper.toModel(adminDTO)).thenReturn(admin);
        when(mapper.toDTO(admin)).thenReturn(adminDTO);
        ResponseEntity<AdminDTO> response = controller.postAdmin(adminDTO);
        AdminDTO adminDTOResponse = response.getBody();
        assertAll(
                () -> assertNotNull(adminDTOResponse),
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(adminDTO.getId(), adminDTOResponse.getId()),
                () -> assertEquals(adminDTO.getNombre(), adminDTOResponse.getNombre()),
                () -> assertEquals(adminDTO.getPassword(), adminDTOResponse.getPassword()),
                () -> assertEquals(adminDTO.getEmail(), adminDTOResponse.getEmail()),
                () -> assertEquals(adminDTO.getFoto(), adminDTOResponse.getFoto())
        );
        verify(mapper, times(1)).toModel(adminDTO);
        verify(mapper, times(1)).toDTO(admin);
        verify(repository, times(1)).insert(admin);
    }

    @Test
    @Order(3)
    void getAdminById() {
        when(mapper.toDTO(admin)).thenReturn(adminDTO);
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(admin));
        ResponseEntity response = controller.getAdminById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        AdminDTO adminResponse = (AdminDTO) response.getBody();
        assertAll(
                () -> assertNotNull(adminResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(adminDTO.getId(), adminResponse.getId()),
                () -> assertEquals(adminDTO.getNombre(), adminResponse.getNombre()),
                () -> assertEquals(adminDTO.getPassword(), adminResponse.getPassword()),
                () -> assertEquals(adminDTO.getEmail(), adminResponse.getEmail()),
                () -> assertEquals(adminDTO.getFoto(), adminResponse.getFoto())
        );
        verify(mapper, times(1)).toDTO(admin);
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(4)
    void getAdminByIdError() {
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.getAdminById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        GeneralError error = (GeneralError) response.getBody();
        assertAll(
                () -> assertNotNull(error),
                () -> assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode()),
                () -> assertEquals("Error general.", error.getMessage())
        );
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(5)
    void updateAdmin() {
        when(repository.save(admin)).thenReturn(admin);
        when(mapper.toModel(adminDTO)).thenReturn(admin);
        when(mapper.toDTO(admin)).thenReturn(adminDTO);
        ResponseEntity response = controller.updateAdmin(adminDTO);
        AdminDTO adminResponse = (AdminDTO) response.getBody();
        assertAll(
                () -> assertNotNull(adminResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(adminDTO.getId(), adminResponse.getId()),
                () -> assertEquals(adminDTO.getNombre(), adminResponse.getNombre()),
                () -> assertEquals(adminDTO.getPassword(), adminResponse.getPassword()),
                () -> assertEquals(adminDTO.getEmail(), adminResponse.getEmail()),
                () -> assertEquals(adminDTO.getFoto(), adminResponse.getFoto())
        );
        verify(mapper, times(1)).toModel(adminDTO);
        verify(mapper, times(1)).toDTO(admin);
        verify(repository, times(1)).save(admin);
    }

    @Test
    @Order(6)
    void deleteAdmin() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.deleteAdmin(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode())
        );
        verify(repository, times(1)).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(7)
    void deleteAdminError() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(admin));
        ResponseEntity response = controller.deleteAdmin(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        GeneralError error = (GeneralError) response.getBody();
        assertAll(
                () -> assertNotNull(error),
                () -> assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode()),
                () -> assertEquals("Error general.", error.getMessage())
        );
        verify(repository, times(1)).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }
}
