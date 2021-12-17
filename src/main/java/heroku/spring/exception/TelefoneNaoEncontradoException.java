package heroku.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TelefoneNaoEncontradoException extends RuntimeException {
	
	public TelefoneNaoEncontradoException() {
		super();
	}

	public TelefoneNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TelefoneNaoEncontradoException(String message) {
		super(message);
	}

	public TelefoneNaoEncontradoException(Throwable cause) {
		super(cause);
	}


}
