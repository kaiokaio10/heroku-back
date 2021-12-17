package heroku.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import heroku.spring.entity.TipoTelefone;


public interface TelefoneRepository extends JpaRepository<TipoTelefone, Long> {

	@Query("SELECT TIP FROM TipoTelefone TIP                          "
			  +"WHERE lower(TIP.tipo) like CONCAT('%', :tipo,'%')"
			  +"ORDER BY TIP.tipo ASC"	)
	List<TipoTelefone> pesquisaPortipo(@Param("tipo") String tipo);
}
