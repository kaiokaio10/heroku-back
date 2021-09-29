package heroku.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import heroku.spring.dto.request.ClienteDTO;
import heroku.spring.service.ClienteService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClienteController.class)
public class ClienteControllerTest {

    @MockBean
    private ClienteService service;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void teste_criar_cliente_controller() throws JsonProcessingException, Exception {
        ClienteDTO post = montaDTO();

        mockMvc.perform(post("/cliente")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isCreated());
    }
    
  
    private ClienteDTO montaDTO() {
        return ClienteDTO.builder().cpf("99533260106").idade(37)
                .nomeCompleto("Gustavo Augusto Ribeiro").build();
    }

}

