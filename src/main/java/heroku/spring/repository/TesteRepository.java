package heroku.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import heroku.spring.entity.Teste;

public interface TesteRepository extends JpaRepository<Teste, Long>  {

}
