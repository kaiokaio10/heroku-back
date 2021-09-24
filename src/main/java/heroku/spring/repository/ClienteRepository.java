package heroku.spring.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	 Optional<Cliente> findByCpf(String cpf);


}
