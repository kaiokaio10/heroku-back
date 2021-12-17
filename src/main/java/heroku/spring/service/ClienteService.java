package heroku.spring.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.entity.Cliente;
import heroku.spring.exception.ClienteNaoEncontradaException;
import heroku.spring.mapper.ClienteMapper;
import heroku.spring.repository.ClienteRepository;

@Service
@Transactional(readOnly = true)
public class ClienteService {

	@Autowired
	private ClienteMapper mapper;

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private MessageSource message;

	public List<Cliente> listar() {
		return repository.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ClienteDTO salvar(ClienteDTO dto) {

		validacao(dto);

		Cliente cliente = repository.save(mapper.toEntity(dto));

		return mapper.toDto(cliente);
	}

	public void validacao(ClienteDTO dto) {
		if (StringUtils.isBlank(dto.getNomeCompleto())  ) {
			throw new ClienteNaoEncontradaException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "Nome" }, LocaleContextHolder.getLocale()));
		}
		if (StringUtils.isBlank(dto.getEndereco())) {
			throw new ClienteNaoEncontradaException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "Endereco" }, LocaleContextHolder.getLocale()));

		}
		if (dto.getIdade() == null) {
			throw new ClienteNaoEncontradaException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "idade" }, LocaleContextHolder.getLocale()));
		}
		if (StringUtils.isBlank(dto.getEndereco())) {
			throw new ClienteNaoEncontradaException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "cpf" }, LocaleContextHolder.getLocale()));
		}
		return;
	}

	private Cliente verifyIfExists(Long id) {
		return repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradaException());
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletarId(Long id) {
		verifyIfExists(id);
		repository.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ClienteDTO alterar(ClienteDTO dto) {
		validacao(dto);

		repository.save(mapper.toEntity(dto));

		return dto;

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<?> pesquisar(String nome) {
		return repository.pesquisaPorNome(nome);

	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<ClienteDTO> pesquisarPorNome(ClienteDTO dto) {
		return mapper.toDto(StringUtils.isNotBlank(dto.getNomeCompleto())
				? repository.pesquisaPorNome(dto.getNomeCompleto().toLowerCase().trim())
				: repository.findAll(Sort.by(Sort.Direction.ASC, "nomeCompleto")));
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public ClienteDTO consultarPorId(Long id) {

		ClienteDTO dto = mapper.toDto(repository.getById(id));

		return dto;
	}

}
