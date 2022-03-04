package com.example.practicafinalcursoback.controller;

import application.controller.AdminController;
import application.controller.InfraestructuraController;
import application.dto.AdminDTO;
import application.dto.InfraestructuraDTO;
import application.mapper.InfraestructuraMapper;
import application.model.Admin;
import application.model.Alquiler;
import application.model.Infraestructura;
import application.repository.InfraestructuraRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@ContextConfiguration(classes = {InfraestructuraController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InfraestructuraControllerTest {
/*
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
        infra = new Infraestructura(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), new ArrayList<Alquiler>(), "admin@gmail.com", "admin", "foto");
        infraDTO = new InfraestructuraDTO(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), "Admin", "admin@gmail.com", "admin", "foto");
        infras = new ArrayList<>();
        infras.add(infra);
        infrasDTO = new ArrayList<>();
        infrasDTO.add(infraDTO);
    }
    */

    // TODO: TERMINAR ESTO, LOLI DEL FUTURO
}
