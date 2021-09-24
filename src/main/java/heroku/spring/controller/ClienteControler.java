package heroku.spring.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.entity.Cliente;
import heroku.spring.exception.ClienteNaoEncontradaException;
import heroku.spring.service.ClienteService;
import lombok.AllArgsConstructor;

@Controller
@RestController
@RequestMapping("/cliente")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteControler {
	
	private final ClienteService clienteService;
	
	

	@GetMapping("/teste")
	public String test() {
		return "teste  ok e teste 2";
	}

	@GetMapping("/listar")
	public List<Cliente> listar(){
		return clienteService.procura();
	}
	@PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO criarCliente(@RequestBody @Validated ClienteDTO clienteDTO) throws ValidationException {
        return clienteService.salvar(clienteDTO);
    }
}
