package heroku.spring.config.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String BASE_PACKAGE = "heroku.spring.controller";
    private static final String API_TITLE = "Cliente API";
    private static final String API_DESCRIPTION = "REST API para cadrastro de clientes";
    private static final String CONTACT_NAME = "Kaio Vitor";
    private static final String CONTACT_GITHUB = "https://github.com/kaiokaio10/heroku-back";
    private static final String CONTACT_EMAIL = "kgalvo47@gmail.com";

	@Bean
	public Docket api() {
		// @formatter:off
		 return new Docket(DocumentationType.SWAGGER_2)
		          .select()
		          .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE ))
		          .paths(PathSelectors.any())
		          .build()
		          .globalResponseMessage(RequestMethod.GET, globalResponses())
	              .globalResponseMessage(RequestMethod.POST, globalResponses())
	              .globalResponseMessage(RequestMethod.DELETE, globalResponses())
	              .globalResponseMessage(RequestMethod.PUT, globalResponses())
		          .apiInfo(apiInfo());
		 // @formatter:on
	}

	private ApiInfo apiInfo() {
		// @formatter:off
	    return new ApiInfoBuilder()
	            .title(API_TITLE )
	            .description(API_DESCRIPTION)
	            .version("1.0.0")
	            .contact(new Contact( CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
	            .build();
		 // @formatter:on

	}

	private List<ResponseMessage> globalResponses() {
		// @formatter:off
	    return new ArrayList<ResponseMessage>() {{
	        add( new ResponseMessageBuilder().code(500).message("Erro inesperado no servidor, não foi possível processar a solicitação").build());
	        add( new ResponseMessageBuilder().code(400).message("Dados inválidos fornecidos pelo cliente").build());
	        add( new ResponseMessageBuilder().code(404).message("Recurso não encontrado").build());
	        add( new ResponseMessageBuilder().code(200).message("Operação bem sucedida").build());
	    }};
		// @formatter:on

	}
}