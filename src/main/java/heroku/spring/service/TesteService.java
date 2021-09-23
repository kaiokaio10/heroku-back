package heroku.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import heroku.spring.entity.Teste;
import heroku.spring.repository.TesteRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TesteService {
	
	 private final TesteRepository testeRepository;
	 
	 public  List<Teste> procura() {
	        return testeRepository.findAll();
	    }

}
