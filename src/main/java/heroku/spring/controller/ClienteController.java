package heroku.spring.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.exception.ClienteNaoEncontradaException;
import heroku.spring.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

@Controller
@RestController
@RequestMapping("/cliente")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "API REST Cliente Builder")
public class ClienteController {
	
	private final ClienteService service;
	
	
	@GetMapping("/teste")
	public String test() {
		return "teste  ok e teste 2";
	}
	@ApiOperation(value = "Recuperar os clientes", response = ClienteDTO[].class)
	@GetMapping("/listar")
	public List<?> listar(){
		return service.listar();
	}
	
	@ApiOperation(value = "Adiciona um cliente" , response = ClienteDTO.class)
	@PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> criarCliente(@ApiParam(name = "clienteDTO", value = "Representação do cliente a ser adicionado", required = true) 
	@RequestBody ClienteDTO clienteDTO) throws ValidationException {
		ClienteDTO dto = service.salvar(clienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
	
	@ApiOperation(value = "Exclui um cliente")
	@DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deletarId( @ApiParam(name = "id", value = "Identificador utilizado para excluir o cliente", required = true, example = "1")
	@PathVariable Long id) throws ClienteNaoEncontradaException {
		service.deletarId(id);
		return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso");
    }
	
	@ApiOperation(value = "Atualiza um cliente", response = ClienteDTO.class)
	@PutMapping
	public ResponseEntity<?> atualizar(
			@ApiParam(name = "clienteDTO", value = "Representação do cliente a ser alterado")
			@RequestBody ClienteDTO clienteDTO) throws ValidationException {

		ClienteDTO dto = service.alterar(clienteDTO);

		return ResponseEntity.ok(dto);
	}
	
	@ApiOperation(value = "Recuperar os clientes por nome", response = ClienteDTO[].class)
	@GetMapping("/pesquisarnome/{nome}")
	public ResponseEntity<?> listarPorNome(@PathVariable(required = true) String nome){
		
		List<?> dto = service.pesquisarPorNome(nome);
		
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

}
