package application.mapper;

import application.dto.AlquilerDTO;
import application.dto.InfraestructuraDTO;
import application.model.Alquiler;
import lombok.RequiredArgsConstructor;
import application.model.Infraestructura;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InfraestructuraMapper {

    private final ModelMapper mapper;

    public InfraestructuraDTO toDTO(Infraestructura infraestructura){
        return mapper.map(infraestructura,InfraestructuraDTO.class);
    }

    public Infraestructura toModel(InfraestructuraDTO dto){
        return mapper.map(dto,Infraestructura.class);
    }

    public List<InfraestructuraDTO> toDTOList(List<Infraestructura> lista){
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Infraestructura> toModelList(List<InfraestructuraDTO>lista){
        return lista.stream().map(this::toModel).collect(Collectors.toList());
    }
}
