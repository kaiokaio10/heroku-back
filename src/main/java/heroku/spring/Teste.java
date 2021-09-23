package heroku.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {

	@GetMapping("/teste")
	public String test() {
		return "teste  ok e teste 2";
	}


}
