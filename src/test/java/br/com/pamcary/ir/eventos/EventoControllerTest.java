package br.com.pamcary.ir.eventos;

import org.junit.Before;
import org.junit.Ignore;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.pamcary.api.evento.controller.EventoController;
import br.com.pamcary.api.evento.dao.EventoDAO;
import br.com.pamcary.api.evento.service.EventoService;
@Ignore
@TestComponent
public class EventoControllerTest extends InfologRiscosEventosApplicationTests {

	@InjectMocks
	private EventoController controller;
	
	@Mock
	private EventoDAO repository;

	@Mock
	private EventoService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		MockMvcBuilders.standaloneSetup(controller).build();

	}
/*
	@Test
	public void testGetById() throws Exception {
		EventoEntity eventoEntity = new EventoEntity();
		eventoEntity.setCodigo(1L);
		eventoEntity.setNome("Diego Novo");

		when(service.findById(1L)).thenReturn(eventoEntity);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/eventos/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		Assert.assertEquals(eventoEntity.getNome(), "Diego Novo");
	}

*/
/*	
	@Test
	public void testSave() throws Exception {
		
		PessoaFisicaEntity pessoa = new PessoaFisicaEntity();
		pessoa.setCodigo(1L);
		pessoa.setNome("Diegos");
		pessoa.setCpf("");
		pessoa.setDataNascimento(LocalDateTime.now());
		
		when(service.save(any(PessoaFisicaDTO.class))).thenReturn(pessoa);
		
		 this.mockMvc.perform(MockMvcRequestBuilders.post("api/pessoas/")
				.param("nome", "CARLOS")
				.param("cpf", "04064842529")
				.param("dataNascimento", "2019-04-05T10:20"));
		
		Assert.assertEquals(pessoa.getNome(), "Diegos");
	}

	@Test
	public void testSaveAndDelete() throws Exception {

		PessoaFisicaEntity pessoa = new PessoaFisicaEntity();
		pessoa.setCodigo(1L);
		pessoa.setNome("Diego");
		pessoa.setCpf("");
		pessoa.setDataNascimento(LocalDateTime.now());
		when(service.save(any(PessoaFisicaDTO.class))).thenReturn(pessoa);

		PessoaFisicaEntity pessoaReturned = service.save(new PessoaFisicaDTO());
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/pessoas/" + pessoaReturned.getCodigo()));
		
		Assert.assertEquals(pessoaReturned.getNome(), "Diego");
	}

	@Test
	public void testUpdate() throws Exception {
		PessoaFisicaEntity pessoa = new PessoaFisicaEntity();
		pessoa.setCodigo(1L);
		pessoa.setNome("Diego");
		pessoa.setCpf("");
		pessoa.setDataNascimento(LocalDateTime.now());
		when(service.save(any(PessoaFisicaDTO.class))).thenReturn(pessoa);
		PessoaFisicaEntity pessoaReturned = service.save(new PessoaFisicaDTO());
		
		
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/pessoas/1"));
		
		Assert.assertEquals(pessoaReturned.getNome(), "Diego");
	}
*/
}
