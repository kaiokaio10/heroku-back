package heroku.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import heroku.spring.dto.request.TipoTelefoneDTO;
import heroku.spring.service.TipoTelefoneService;
import lombok.AllArgsConstructor;

@Controller
@RestController
@RequestMapping("/telefone")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin("http://localhost:4200")
public class TipoTelefoneController {
	
	private TipoTelefoneService service;
	
	@GetMapping("/teste")
	public String test() {
		return "teste  ok telefone";
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> criarCliente(@RequestBody TipoTelefoneDTO tipoTelefoneDTO)
			 {
		TipoTelefoneDTO dto = service.salvar(tipoTelefoneDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@GetMapping("/listar")
	public List<?> listar() {
		return service.listar();
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deletarId(@PathVariable Long id)
			 {
		service.deletarId(id);
		return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso");
	}
	
	@GetMapping("/pesquisartipo/{tipo}")
	public ResponseEntity<?> listarPorTipo(@PathVariable(required = true) String tipo) {

		List<?> dto = service.pesquisar(tipo);

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(
			 @RequestBody TipoTelefoneDTO tipoTelefoneDTO)
			 {

		TipoTelefoneDTO dto = service.alterar(tipoTelefoneDTO);

		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/pesquisa")
	public ResponseEntity<?> listar(@RequestBody TipoTelefoneDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.pesquisarPortipo(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable(required = true) Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultarPorId(id));
	}
	
	@GetMapping("/listartipo")
	public ResponseEntity<?> listarTipo() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarTipo());
	}

}
