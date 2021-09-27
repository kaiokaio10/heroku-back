package heroku.spring.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	
	private final ClienteService service;
	
	

	@GetMapping("/teste")
	public String test() {
		return "teste  ok e teste 2";
	}

	@GetMapping("/listar")
	public List<Cliente> listar(){
		return service.procura();
	}
	
	@PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO criarCliente(@RequestBody @Validated ClienteDTO clienteDTO) throws ValidationException {
        return service.salvar(clienteDTO);
    }
	
	@DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarId(@PathVariable Long id) throws ClienteNaoEncontradaException {
		service.deletarId(id);
    }
	@PutMapping
	public ResponseEntity<?> atualizar(
			@RequestBody ClienteDTO clienteDTO) throws ValidationException {

		ClienteDTO dto = service.alterar(clienteDTO);

		return ResponseEntity.ok(dto);
	}

}
