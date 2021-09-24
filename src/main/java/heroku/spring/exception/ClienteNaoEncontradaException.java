package heroku.spring.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradaException extends Exception {
	
	public ClienteNaoEncontradaException(Long id) {
		super(String.format("Pessoa com ID% s não encontrada", id));
	}
	public ClienteNaoEncontradaException(String nomeCompleto) {
		super(String.format("Pessoa com ID% s não encontrada", nomeCompleto));
	}

}
