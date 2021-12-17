package heroku.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TIPO_TELEFONE")
public class TipoTelefone {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID_TIPO")
	private Long id;
	
	@Column(name ="TIPO",nullable = false)
	private String tipo;
	
	@Column(name ="DESCRICAO",nullable = false)
	private String descricao;
	


	
}
