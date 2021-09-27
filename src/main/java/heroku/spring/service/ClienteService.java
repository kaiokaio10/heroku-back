package heroku.spring.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.entity.Cliente;
import heroku.spring.exception.ClienteNaoEncontradaException;
import heroku.spring.mapper.ClienteMapper;
import heroku.spring.repository.ClienteRepository;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteService {

	@Autowired
	private ClienteMapper mapper;
	
	@Autowired
	private ClienteRepository repository;
	
	public  List<Cliente> procura() {
        return repository.findAll();
    }
	
	public ClienteDTO salvar(ClienteDTO dto) throws ValidationException {

        validacao(dto);

        Cliente cliente = repository.save(mapper.toEntity(dto));

        dto = mapper.toDto(cliente);

        return dto;
    }
	
	public void validacao(ClienteDTO dto) throws ValidationException {
		if(dto.getNomeCompleto() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}
		if(dto.getEndereco() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}
		if(dto.getIdade() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}
		if(dto.getCpf() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}		
		return;
	}
	
	public void validacao(ClienteDTO dto,Long id) throws ValidationException {
		if(dto.getNomeCompleto() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}
		if(dto.getEndereco() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}
		if(dto.getIdade() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}
		if(dto.getCpf() == null ) {
			throw new ValidationException("campo vazio ou incompleto");
		}		
		return;
	}
	private Cliente verifyIfExists(Long id) throws ClienteNaoEncontradaException {
        return repository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradaException(id));
    }
	
	public void deletarId(Long id) throws ClienteNaoEncontradaException {
        verifyIfExists(id);
        repository.deleteById(id);
    }
	
	public ClienteDTO alterar(ClienteDTO dto) throws ValidationException {

		validacao(dto, dto.getId());

        repository.save(mapper.toEntity(dto));

        return dto;

    }

	
		
}
