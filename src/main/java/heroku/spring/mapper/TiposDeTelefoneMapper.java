package heroku.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import heroku.spring.dto.request.TipoTelefoneDTO;
import heroku.spring.entity.TipoTelefone;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TiposDeTelefoneMapper extends BaseMapper<TipoTelefone, TipoTelefoneDTO> {

}
