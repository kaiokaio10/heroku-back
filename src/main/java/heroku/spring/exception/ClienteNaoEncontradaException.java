package heroku.spring.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradaException extends RuntimeException {
	
	public ClienteNaoEncontradaException() {
		super();
	}

	public ClienteNaoEncontradaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteNaoEncontradaException(String message) {
		super(message);
	}

	public ClienteNaoEncontradaException(Throwable cause) {
		super(cause);
	}

}
