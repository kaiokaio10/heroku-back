package heroku.spring.dto.request;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
	
    private Long id;
    
    private String nomeCompleto;
    
    private Integer idade;
    
    private String endereco;
    
    private Integer numeroTelefone;
    
	private String cpf;

}