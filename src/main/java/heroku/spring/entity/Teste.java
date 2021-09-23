package heroku.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teste {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TESTE")
	private String teste;
	
	

}
