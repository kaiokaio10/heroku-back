package heroku.spring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cliente")
public class Cliente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(nullable = false, unique = true,name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(nullable = false,name = "IDADE")
    private Integer idade;

    @Column(nullable = false,name ="ENDERECO")
    private String endereco;

    @Column(nullable = false,name ="NUMERO_TELEFONE")
    private String numeroTelefone;
    
    @Column(nullable = false,name ="CPF")
    private String cpf;
    
	@Column(name = "NU_TIPO")
	private Long idTipoTelefone;
	

}
	