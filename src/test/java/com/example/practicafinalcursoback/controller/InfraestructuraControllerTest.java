package com.example.practicafinalcursoback.controller;

import application.controller.InfraestructuraController;
import application.dto.InfraestructuraDTO;
import application.error.GeneralError;
import application.mapper.InfraestructuraMapper;
import application.model.Infraestructura;
import application.repository.InfraestructuraRepository;
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
@ContextConfiguration(classes = {InfraestructuraController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InfraestructuraControllerTest {

    private List<InfraestructuraDTO> infrasDTO;
    private List<Infraestructura> infras;
    @InjectMocks
    private InfraestructuraController controller;
    @MockBean
    private InfraestructuraRepository repository;
    @MockBean
    private InfraestructuraMapper mapper;
    private Infraestructura infra;
    private InfraestructuraDTO infraDTO;

    @BeforeAll
    void beforeAll() {
        controller = new InfraestructuraController(repository, mapper);
        infra = new Infraestructura(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), "tipo_prueba", "foto_uri", 1, 1, "descripcion");
        infraDTO = new InfraestructuraDTO(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), "tipo_prueba", "foto_uri", 1, 1);
        infras = new ArrayList<>();
        infras.add(infra);
        infrasDTO = new ArrayList<>();
        infrasDTO.add(infraDTO);
    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(infras);
        when(mapper.toDTOList(infras)).thenReturn(infrasDTO);
        ResponseEntity<List<InfraestructuraDTO>> response = controller.getAllInfraestructura();
        List<InfraestructuraDTO> responseList = response.getBody();
        assertAll(
                () -> assertTrue(responseList.size() > 0),
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(infras.size(), responseList.size()),
                () -> assertEquals(infrasDTO.size(), responseList.size()),
                () -> assertEquals(infras.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(infrasDTO.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(infras.get(0).getTipo(), responseList.get(0).getTipo()),
                () -> assertEquals(infrasDTO.get(0).getTipo(), responseList.get(0).getTipo()),
                () -> assertEquals(infras.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(infrasDTO.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(infras.get(0).getApertura(), responseList.get(0).getApertura()),
                () -> assertEquals(infrasDTO.get(0).getApertura(), responseList.get(0).getApertura()),
                () -> assertEquals(infras.get(0).getCierre(), responseList.get(0).getCierre()),
                () -> assertEquals(infrasDTO.get(0).getCierre(), responseList.get(0).getCierre())
        );
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTOList(infras);
    }

    @Test
    @Order(2)
    void postInfraestructura() {
        when(repository.insert(infra)).thenReturn(infra);
        when(mapper.toModel(infraDTO)).thenReturn(infra);
        when(mapper.toDTO(infra)).thenReturn(infraDTO);
        ResponseEntity<InfraestructuraDTO> response = controller.postInfraestructura(infraDTO);
        InfraestructuraDTO infraDTOResponse = response.getBody();
        assertAll(
                () -> assertNotNull(infraDTOResponse),
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(infraDTO.getId(), infraDTOResponse.getId()),
                () -> assertEquals(infraDTO.getTipo(), infraDTOResponse.getTipo()),
                () -> assertEquals(infraDTO.getApertura(), infraDTOResponse.getApertura()),
                () -> assertEquals(infraDTO.getCierre(), infraDTOResponse.getCierre()),
                () -> assertEquals(infraDTO.getFoto(), infraDTOResponse.getFoto())
        );
        verify(mapper, times(1)).toModel(infraDTO);
        verify(mapper, times(1)).toDTO(infra);
        verify(repository, times(1)).insert(infra);
    }

    @Test
    @Order(3)
    void getInfraById() {
        when(mapper.toDTO(infra)).thenReturn(infraDTO);
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(infra));
        ResponseEntity response = controller.getInfraestructuraById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        InfraestructuraDTO infraResponse = (InfraestructuraDTO) response.getBody();
        assertAll(
                () -> assertNotNull(infraResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(infraDTO.getId(), infraResponse.getId()),
                () -> assertEquals(infraDTO.getTipo(), infraResponse.getTipo()),
                () -> assertEquals(infraDTO.getApertura(), infraResponse.getApertura()),
                () -> assertEquals(infraDTO.getCierre(), infraResponse.getCierre()),
                () -> assertEquals(infraDTO.getFoto(), infraResponse.getFoto())
        );
        verify(mapper, times(1)).toDTO(infra);
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(4)
    void getInfraByIdError() {
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.getInfraestructuraById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
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
    void getInfraByTipo() {
        when(mapper.toDTOList(infras)).thenReturn(infrasDTO);
        when(repository.findAllByTipo("tipo_prueba")).thenReturn(Optional.of(infras));
        ResponseEntity<List<InfraestructuraDTO>> response = controller.getInfraestructuraByTipo("tipo_prueba");
        List<InfraestructuraDTO> responseList = response.getBody();
        assertAll(
                () -> assertTrue(responseList.size() > 0),
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(infras.size(), responseList.size()),
                () -> assertEquals(infrasDTO.size(), responseList.size()),
                () -> assertEquals(infras.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(infrasDTO.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(infras.get(0).getTipo(), responseList.get(0).getTipo()),
                () -> assertEquals(infrasDTO.get(0).getTipo(), responseList.get(0).getTipo()),
                () -> assertEquals(infras.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(infrasDTO.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(infras.get(0).getApertura(), responseList.get(0).getApertura()),
                () -> assertEquals(infrasDTO.get(0).getApertura(), responseList.get(0).getApertura()),
                () -> assertEquals(infras.get(0).getCierre(), responseList.get(0).getCierre()),
                () -> assertEquals(infrasDTO.get(0).getCierre(), responseList.get(0).getCierre())
        );

        verify(repository, times(1)).findAllByTipo("tipo_prueba");
        verify(mapper, times(1)).toDTOList(infras);
    }

    @Test
    @Order(6)
    void updateInfraestructura() {
        when(repository.save(infra)).thenReturn(infra);
        when(mapper.toModel(infraDTO)).thenReturn(infra);
        when(mapper.toDTO(infra)).thenReturn(infraDTO);
        ResponseEntity response = controller.updateInfaestructura(infraDTO);
        InfraestructuraDTO infraResponse = (InfraestructuraDTO) response.getBody();
        assertAll(
                () -> assertNotNull(infraResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(infraDTO.getId(), infraResponse.getId()),
                () -> assertEquals(infraDTO.getTipo(), infraResponse.getTipo()),
                () -> assertEquals(infraDTO.getApertura(), infraResponse.getApertura()),
                () -> assertEquals(infraDTO.getCierre(), infraResponse.getCierre()),
                () -> assertEquals(infraDTO.getFoto(), infraResponse.getFoto())
        );
        verify(mapper, times(1)).toModel(infraDTO);
        verify(mapper, times(1)).toDTO(infra);
        verify(repository, times(1)).save(infra);
    }

    @Test
    @Order(7)
    void deleteInfraestructura() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.deleteInfraestructura(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode())
        );
        verify(repository, times(1)).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(8)
    void deleteInfraError() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(infra));
        ResponseEntity response = controller.deleteInfraestructura(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
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
