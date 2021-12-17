package heroku.spring.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.dto.request.TipoTelefoneDTO;
import heroku.spring.entity.TipoTelefone;
import heroku.spring.exception.TelefoneNaoEncontradoException;
import heroku.spring.mapper.TiposDeTelefoneMapper;
import heroku.spring.repository.TelefoneRepository;


@Service
@Transactional(readOnly = true)
public class TipoTelefoneService {

	@Autowired
	private TiposDeTelefoneMapper mapper;

	@Autowired
	private TelefoneRepository repository;

	@Autowired
	private MessageSource message;

	public void validacao(TipoTelefoneDTO dto) {
		if (StringUtils.isBlank(dto.getTipo())) {
			throw new TelefoneNaoEncontradoException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "tipo" }, LocaleContextHolder.getLocale()));
		}
		if (StringUtils.isBlank(dto.getDescricao())) {
			throw new TelefoneNaoEncontradoException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "descrição" }, LocaleContextHolder.getLocale()));
			
		}
		return;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public TipoTelefoneDTO salvar(TipoTelefoneDTO dto) {

		validacao(dto);

		TipoTelefone tipoTelefone = repository.save(mapper.toEntity(dto));

		return mapper.toDto(tipoTelefone);
	}
	
	public List<TipoTelefone> listar() {
		return repository.findAll();
	}
	
	private TipoTelefone verifyIfExists(Long id) {
		return repository.findById(id).orElseThrow(() -> new TelefoneNaoEncontradoException());
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletarId(Long id) {
		verifyIfExists(id);
		repository.deleteById(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public TipoTelefoneDTO alterar(TipoTelefoneDTO dto) {
		validacao(dto);

		repository.save(mapper.toEntity(dto));

		return dto;

	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<?> pesquisar(String tipo) {
		return repository.pesquisaPortipo(tipo);

	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TipoTelefoneDTO> pesquisarPortipo(TipoTelefoneDTO dto) {
		return mapper.toDto(StringUtils.isNotBlank(dto.getTipo())
				? repository.pesquisaPortipo(dto.getTipo().toLowerCase().trim())
				: repository.findAll(Sort.by(Sort.Direction.ASC, "tipo")));
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TipoTelefoneDTO consultarPorId(Long id) {

		TipoTelefoneDTO dto = mapper.toDto(repository.getById(id));

		return dto;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TipoTelefoneDTO> listarTipo() {
		return mapper.toDto(repository.findAll(Sort.by(Sort.Direction.ASC, "tipo")));
	}


}
