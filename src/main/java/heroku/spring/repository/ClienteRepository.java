package heroku.spring.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import heroku.spring.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	@Query("SELECT CLI FROM Cliente CLI                          "
			  +"WHERE lower(CLI.nomeCompleto) like CONCAT('%', :nomeCompleto,'%')"
			  +"ORDER BY CLI.nomeCompleto ASC"	)
	List<Cliente> pesquisaPorNome(@Param("nomeCompleto") String nome);

	Optional<Cliente> findByCpf(String cpf);

}
