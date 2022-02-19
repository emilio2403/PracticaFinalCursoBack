package mapper;

import dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import model.Cliente;
import org.modelmapper.ModelMapper;

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