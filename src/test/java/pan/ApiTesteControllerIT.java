package pan;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.bancopan.api.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class ApiTesteControllerIT {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	
	/**
	 * Executa um teste da API buscando o usuario de CPF 123
	 * @throws Exception
	 */

	@Test
	public void verifyUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bancopan/api/user/123").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.nome").exists())
		.andExpect(jsonPath("$.cpf").value(123))
		.andExpect(jsonPath("$.idade").exists())
		.andExpect(jsonPath("$.estadoCivil").exists())
		.andExpect(jsonPath("$.numero").exists())
		.andExpect(jsonPath("$.telefone").exists())
		.andDo(print())
		;
	}
	
	/**
	 * Executa um teste da API buscando o usuario de CPF inexistente
	 * @throws Exception
	 */
	@Test
	public void verifyUserNull() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bancopan/api/user/12").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Cpf não existe"))
		.andDo(print())
		;
	}
	
	/**
	 * Executa um teste da API atualizando o endereço do usuario de CPF 123
	 * @throws Exception
	 */
	@Test
	public void verifyUpdateUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/bancopan/api/user/update")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"cpf\": 123, \"endereço\" : \"rua teste\", \"numero\" : 20 }")
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		.andExpect(jsonPath("$.message").value("cpf atualizado com sucesso"))
		.andDo(print())
		;
	}
	
	/**
	 * Executa um teste da API buscando o endereço do cep 04417-010
	 * @throws Exception
	 */
	@Test
	public void verifyEndereco() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bancopan/api/endereco/04417-010").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.cep").exists())
		.andExpect(jsonPath("$.logradouro").value("Rua Vale da Macieira"))
		.andDo(print())
		;
	}
	
	/**
	 * Executa um teste da API buscando o endereço de um cep inexistente
	 * @throws Exception
	 */
	@Test
	public void verifyEnderecoNull() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bancopan/api/endereco/6").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("CEP invalido"))
		.andDo(print())
		;
	}

	/**
	 * Executa um teste da API buscando os municipios do estado de id 35.
	 * @throws Exception
	 */
	@Test
	public void verifyMunincipios() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bancopan/api/estado/municipios/35").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].id").value(3500105))
		.andExpect(jsonPath("$[0].nome").value("Adamantina"))
		.andDo(print());
	}
	
	/**
	 * Executa um teste da API buscando os municipios de um estado inexistente
	 * @throws Exception
	 */
	@Test
	public void verifyMunicipiosNull() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bancopan/api/estado/municipios/4").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Não existe municipios para o ID informado"))
		.andDo(print())
		;
	}

	/**
	 * Executa um teste da API buscando a lista de estados
	 * @throws Exception
	 */
	@Test
	public void verifyEstados() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bancopan/api/estado").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].id").value(11))
		.andExpect(jsonPath("$[0].nome").value("Rondônia"))
		.andExpect(jsonPath("$[1].id").value(12))
		.andExpect(jsonPath("$[1].nome").value("Acre"))
		.andDo(print())
		;
	}
}
