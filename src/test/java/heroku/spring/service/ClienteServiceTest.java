package heroku.spring.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import javax.xml.bind.ValidationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.entity.Cliente;
import heroku.spring.mapper.ClienteMapper;
import heroku.spring.repository.ClienteRepository;


@ExtendWith(MockitoExtension.class)

public class ClienteServiceTest {
    @InjectMocks
    private ClienteService servico;
    @Mock
    private ClienteRepository repository;
    @Mock
    private ClienteMapper mapper;
    @Mock
    private MessageSource messageSource;

    @Test
    public void cadastrar_usuario_com_sucesso() throws ValidationException {
        when(repository.findByCpf(Mockito.anyString())).thenReturn(null);
        when(repository.save(Mockito.any(Cliente.class))).thenReturn(Cliente.builder().id(1L).build());
        when(mapper.toEntity(Mockito.any(ClienteDTO.class))).thenReturn(montaEntity());
        when(mapper.toDto(Mockito.any(Cliente.class))).thenReturn(montaDTO());
        ClienteDTO cl = servico.salvar(montaDTO());
        Mockito.verify(repository, Mockito.atLeastOnce()).save(montaEntity());
        assertNotNull(cl);
    }

    @Test
    public void usuario_cpf_branco() {
        Assertions.assertThrows(ValidationException.class, () -> {
            servico.salvar(montaDTO("",LocalDate.now(),"gustavo",37));
            Mockito.verify(repository, Mockito.atLeastOnce()).findById(Mockito.anyLong());
          });
    }
    @Test
    public void usuario_nome_branco() {
        Assertions.assertThrows(ValidationException.class, () -> {
            servico.salvar(montaDTO("",LocalDate.now(),"",37));
            Mockito.verify(repository, Mockito.atLeastOnce()).findById(Mockito.anyLong());
        });
    }
    @Test
    public void usuario_idade_nulo() {
        Assertions.assertThrows(ValidationException.class, () -> {
            servico.salvar(montaDTO("",LocalDate.now(),"",null));
            Mockito.verify(repository, Mockito.atLeastOnce()).findById(Mockito.anyLong());
        });
    }
    @Test
    public void usuario_dtNasc_nulo() {
        Assertions.assertThrows(ValidationException.class, () -> {
            servico.salvar(montaDTO("",null,"",37));
            Mockito.verify(repository, Mockito.atLeastOnce()).findById(Mockito.anyLong());
        });
    }

    private ClienteDTO montaDTO() {
        return ClienteDTO.builder().cpf("99533260106").idade(37)
                .nomeCompleto("Gustavo Augusto Ribeiro").build();
    }
    private ClienteDTO montaDTO(String cpf,LocalDate dtNasc,String nome,Integer idade) {
        return ClienteDTO.builder().cpf(cpf).idade(idade)
                .nomeCompleto(nome).build();
    }

    private Cliente montaEntity() {
        return Cliente.builder().cpf("99533260106").idade(37)
                .nomeCompleto("Gustavo Augusto Ribeiro").build();
    }

}
