package application.mapper;

import application.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import application.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;

    public ClienteDTO toDTO(Cliente cliente){
        return mapper.map(cliente,ClienteDTO.class);
    }

    public Cliente toModel(ClienteDTO dto){
        return mapper.map(dto, Cliente.class);
    }
}
