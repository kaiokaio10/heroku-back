package heroku.spring.dto.request;


import com.sun.istack.NotNull;

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
    
    private String idade;
    
    private String endereco;
    
    private int numeroTelefone;
    
	private String cpf;

}