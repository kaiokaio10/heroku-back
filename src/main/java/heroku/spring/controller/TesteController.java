package heroku.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heroku.spring.entity.Teste;
import heroku.spring.service.TesteService;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/teste")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TesteController {
	
	private final TesteService testeService;
	
	

	@GetMapping("/teste")
	public String test() {
		return "teste  ok e teste 2";
	}

	@GetMapping("/listar")
	public List<Teste>listTestes(){
		return testeService.procura();
	}
}
