package com.example.practicafinalcursoback.controller;

import application.controller.AlquilerController;
import application.dto.AlquilerDTO;
import application.error.GeneralError;
import application.mapper.AlquilerMapper;
import application.model.Alquiler;
import application.repository.AlquilerRepository;
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
@ContextConfiguration(classes = {AlquilerController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlquilerControllerTest {

    private List<AlquilerDTO> alquileresDTO;
    private List<Alquiler> alquileres;
    @InjectMocks
    private AlquilerController controller;
    @MockBean
    private AlquilerRepository repository;
    @MockBean
    private AlquilerMapper mapper;
    private Alquiler alquiler;
    private AlquilerDTO alquilerDTO;

    @BeforeAll
    void beforeAll() {
        controller = new AlquilerController(repository, mapper);
        alquiler = new Alquiler(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), 20);
        alquilerDTO = new AlquilerDTO(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), 20);
        alquileres = new ArrayList<>();
        alquileres.add(alquiler);
        alquileresDTO = new ArrayList<>();
        alquileresDTO.add(alquilerDTO);
    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(alquileres);
        when(mapper.toDTOList(alquileres)).thenReturn(alquileresDTO);
        ResponseEntity<List<AlquilerDTO>> response = controller.getAllAlquileres();
        List<AlquilerDTO> responseList = response.getBody();
        assertAll(
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(alquileres.size(), responseList.size()),
                () -> assertEquals(alquileresDTO.size(), responseList.size()),
                () -> assertEquals(alquileres.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(alquileresDTO.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(alquileres.get(0).getCoste(), responseList.get(0).getCoste()),
                () -> assertEquals(alquileresDTO.get(0).getCoste(), responseList.get(0).getCoste())
        );
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTOList(alquileres);
    }

    @Test
    @Order(2)
    void postAlquiler() {
        when(repository.insert(alquiler)).thenReturn(alquiler);
        when(mapper.toModel(alquilerDTO)).thenReturn(alquiler);
        when(mapper.toDTO(alquiler)).thenReturn(alquilerDTO);
        ResponseEntity<AlquilerDTO> response = controller.postAlquiler(alquilerDTO);
        AlquilerDTO alquilerDTOresponse = response.getBody();
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(alquilerDTO.getId(), alquilerDTOresponse.getId()),
                () -> assertEquals(alquilerDTO.getCoste(), alquilerDTOresponse.getCoste())
        );
        verify(repository, times(1)).insert(alquiler);
        verify(mapper, times(1)).toDTO(alquiler);
        verify(mapper, times(1)).toModel(alquilerDTO);
    }

    @Test
    @Order(3)
    void getAlquilerById() {
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(alquiler));
        when(mapper.toDTO(alquiler)).thenReturn(alquilerDTO);
        ResponseEntity<AlquilerDTO> response = controller.getAlquilerById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        AlquilerDTO alquilerResponse = response.getBody();
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(alquilerDTO.getId(), alquilerResponse.getId()),
                () -> assertEquals(alquilerDTO.getCoste(), alquilerResponse.getCoste())
        );
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        verify(mapper, times(1)).toDTO(alquiler);
    }

    @Test
    @Order(4)
    void getAlquilerByIdError() {
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.getAlquilerById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
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
    void updateAlquiler() {
        when(repository.save(alquiler)).thenReturn(alquiler);
        when(mapper.toModel(alquilerDTO)).thenReturn(alquiler);
        when(mapper.toDTO(alquiler)).thenReturn(alquilerDTO);
        ResponseEntity response = controller.updateAlquiler(alquilerDTO);
        AlquilerDTO alquilerResponse = (AlquilerDTO) response.getBody();
        assertAll(
                () -> assertNotNull(alquilerResponse),
                () -> assertEquals(alquilerDTO.getId(), alquilerResponse.getId()),
                () -> assertEquals(alquiler.getCoste(), alquilerResponse.getCoste())
        );
        verify(mapper, times(1)).toModel(alquilerDTO);
        verify(mapper, times(1)).toDTO(alquiler);
        verify(repository, times(1)).save(alquiler);
    }

    @Test
    @Order(6)
    void deleteAlquiler() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.deleteAlquiler(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode())
        );
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        verify(repository, times(1)).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(7)
    void deleteAlquilerError() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(alquiler));
        ResponseEntity response = controller.deleteAlquiler(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        GeneralError error = (GeneralError) response.getBody();
        assertAll(
                () -> assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode()),
                () -> assertEquals("Error general.", error.getMessage())
        );
        verify(repository, times(1)).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        verify(repository, times(1)).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }
}
