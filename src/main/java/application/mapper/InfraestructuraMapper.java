package application.mapper;

import application.dto.InfraestructuraDTO;
import lombok.RequiredArgsConstructor;
import application.model.Infraestructura;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InfraestructuraMapper {

    private final ModelMapper mapper;

    public InfraestructuraDTO toDto(Infraestructura infraestructura){
        return mapper.map(infraestructura,InfraestructuraDTO.class);
    }

    public Infraestructura toModel(InfraestructuraDTO dto){
        return mapper.map(dto,Infraestructura.class);
    }
}
