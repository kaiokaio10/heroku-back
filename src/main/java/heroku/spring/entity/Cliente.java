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
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(nullable = false, unique = true,name = "NOMECOMPLETO")
    private String nomeCompleto;

    @Column(nullable = false,name = "IDADE")
    private Integer idade;

    @Column(nullable = false,name ="ENDERECO")
    private String endereco;

    @Column(nullable = false,name ="NUMEROTELEFONE")
    private Integer numeroTelefone;
    
    @Column(nullable = false, unique = true,name ="CPF")
    private String cpf;

}
	