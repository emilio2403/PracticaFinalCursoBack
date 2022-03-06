package application.mapper;

import application.dto.AlquilerDTO;
import application.model.Alquiler;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AlquilerMapper {

    private final ModelMapper mapper;

    public AlquilerDTO toDTO(Alquiler alquiler) {
        return mapper.map(alquiler, AlquilerDTO.class);
    }

    public Alquiler toModel(AlquilerDTO dto) {
        return mapper.map(dto, Alquiler.class);
    }

    public List<AlquilerDTO> toDTOList(List<Alquiler> lista) {
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Alquiler> toModelList(List<AlquilerDTO> lista) {
        return lista.stream().map(this::toModel).collect(Collectors.toList());
    }

}
