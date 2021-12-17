package heroku.spring.dto.request;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {
	
    private Long id;
    
    private String nomeCompleto;
    
    private Integer idade;
    
    private String endereco;
    
    private String numeroTelefone;
    
	private String cpf;
	
	private Long idTipoTelefone;
	
	private TipoTelefoneDTO tipoTelefone;

}