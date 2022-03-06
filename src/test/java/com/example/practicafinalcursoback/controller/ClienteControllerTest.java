package com.example.practicafinalcursoback.controller;

import application.controller.ClienteController;
import application.dto.ClienteDTO;
import application.error.GeneralError;
import application.mapper.ClienteMapper;
import application.model.Cliente;
import application.repository.ClienteRepository;
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
@ContextConfiguration(classes = {ClienteController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteControllerTest {

    private List<ClienteDTO> clientesDTO;
    private List<Cliente> clientes;
    @InjectMocks
    private ClienteController controller;
    @MockBean
    private ClienteRepository repository;
    @MockBean
    private ClienteMapper mapper;
    private Cliente cliente;
    private ClienteDTO clienteDTO;

    @BeforeAll
    void beforeAll() {
        controller = new ClienteController(repository, mapper);
        cliente = new Cliente(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), "Cliente", "cliente@gmail.com", "cliente", "foto");
        clienteDTO = new ClienteDTO(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"), "Cliente", "cliente@gmail.com", "cliente", "foto");
        clientes = new ArrayList<>();
        clientes.add(cliente);
        clientesDTO = new ArrayList<>();
        clientesDTO.add(clienteDTO);
    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(clientes);
        when(mapper.toDTOList(clientes)).thenReturn(clientesDTO);
        ResponseEntity<List<ClienteDTO>> response = controller.findAll();
        List<ClienteDTO> responseList = response.getBody();
        assertAll(
                () -> assertTrue(responseList.size() > 0),
                () -> assertEquals(response.getStatusCode(), HttpStatus.FOUND),
                () -> assertEquals(clientes.size(), responseList.size()),
                () -> assertEquals(clientesDTO.size(), responseList.size()),
                () -> assertEquals(clientes.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(clientesDTO.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(clientes.get(0).getCorreo(), responseList.get(0).getCorreo()),
                () -> assertEquals(clientesDTO.get(0).getCorreo(), responseList.get(0).getCorreo()),
                () -> assertEquals(clientes.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(clientesDTO.get(0).getFoto(), responseList.get(0).getFoto()),
                () -> assertEquals(clientes.get(0).getNombre(), responseList.get(0).getNombre()),
                () -> assertEquals(clientesDTO.get(0).getNombre(), responseList.get(0).getNombre()),
                () -> assertEquals(clientes.get(0).getPassword(), responseList.get(0).getPassword()),
                () -> assertEquals(clientesDTO.get(0).getPassword(), responseList.get(0).getPassword())
        );
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTOList(clientes);
    }

    @Test
    @Order(2)
    void postCliente() {
        when(repository.insert(cliente)).thenReturn(cliente);
        when(mapper.toModel(clienteDTO)).thenReturn(cliente);
        when(mapper.toDTO(cliente)).thenReturn(clienteDTO);
        ResponseEntity<ClienteDTO> response = controller.postClient(clienteDTO);
        ClienteDTO clienteDTOResponse = response.getBody();
        assertAll(
                () -> assertNotNull(clienteDTOResponse),
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(clienteDTO.getId(), clienteDTOResponse.getId()),
                () -> assertEquals(clienteDTO.getNombre(), clienteDTOResponse.getNombre()),
                () -> assertEquals(clienteDTO.getPassword(), clienteDTOResponse.getPassword()),
                () -> assertEquals(clienteDTO.getCorreo(), clienteDTOResponse.getCorreo()),
                () -> assertEquals(clienteDTO.getFoto(), clienteDTOResponse.getFoto())
        );
        verify(mapper, times(1)).toModel(clienteDTO);
        verify(mapper, times(1)).toDTO(cliente);
        verify(repository, times(1)).insert(cliente);
    }

    @Test
    @Order(3)
    void getClienteById() {
        when(mapper.toDTO(cliente)).thenReturn(clienteDTO);
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(cliente));
        ResponseEntity response = controller.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        ClienteDTO clienteResponse = (ClienteDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(clienteDTO.getId(), clienteResponse.getId()),
                () -> assertEquals(clienteDTO.getNombre(), clienteResponse.getNombre()),
                () -> assertEquals(clienteDTO.getPassword(), clienteResponse.getPassword()),
                () -> assertEquals(clienteDTO.getCorreo(), clienteResponse.getCorreo()),
                () -> assertEquals(clienteDTO.getFoto(), clienteResponse.getFoto())
        );
        verify(mapper, times(1)).toDTO(cliente);
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(4)
    void getClienteByIdError() {
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
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
    void updateCliente() {
        when(repository.save(cliente)).thenReturn(cliente);
        when(mapper.toModel(clienteDTO)).thenReturn(cliente);
        when(mapper.toDTO(cliente)).thenReturn(clienteDTO);
        ResponseEntity response = controller.putClient(clienteDTO);
        ClienteDTO clienteResponse = (ClienteDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(clienteDTO.getId(), clienteResponse.getId()),
                () -> assertEquals(clienteDTO.getNombre(), clienteResponse.getNombre()),
                () -> assertEquals(clienteDTO.getPassword(), clienteResponse.getPassword()),
                () -> assertEquals(clienteDTO.getCorreo(), clienteResponse.getCorreo()),
                () -> assertEquals(clienteDTO.getFoto(), clienteResponse.getFoto())
        );
        verify(mapper, times(1)).toModel(clienteDTO);
        verify(mapper, times(1)).toDTO(cliente);
        verify(repository, times(1)).save(cliente);
    }

    @Test
    @Order(6)
    void deleteCliente() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.empty());
        ResponseEntity response = controller.delete(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode())
        );
        verify(repository, times(1)).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        verify(repository, times(1)).findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
    }

    @Test
    @Order(7)
    void deleteClienteError() {
        doNothing().when(repository).deleteById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
        when(repository.findById(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"))).thenReturn(Optional.of(cliente));
        ResponseEntity response = controller.delete(UUID.fromString("fec6f825-d3b2-4753-b0f1-ce933b3ba5f6"));
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
