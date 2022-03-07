package application.mapper;

import application.dto.AdminDTO;
import application.model.Admin;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdminMapper {

    private final ModelMapper mapper;

    public AdminDTO toDTO(Admin admin) {
        return mapper.map(admin, AdminDTO.class);
    }

    public Admin toModel(AdminDTO dto) {
        return mapper.map(dto, Admin.class);
    }

    public List<AdminDTO> toDTOList(List<Admin> admin) {
        return admin.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Admin> toModelList(List<AdminDTO> admin) {
        return admin.stream().map(this::toModel).collect(Collectors.toList());
    }
}
