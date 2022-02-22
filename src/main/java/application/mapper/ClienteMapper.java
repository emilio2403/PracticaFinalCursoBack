package application.mapper;

import application.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import application.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ClienteDTO> toDTOList(List<Cliente> lista){
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Cliente> toModelList(List<ClienteDTO> lista){
        return lista.stream().map(this::toModel).collect(Collectors.toList());
    }

}
