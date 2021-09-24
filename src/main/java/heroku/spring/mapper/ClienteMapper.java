package heroku.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.entity.Cliente;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO> {
	
}


	