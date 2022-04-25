package br.sistema.crud.jdbc.bo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.sistema.crud.jdbc.dao.PessoaDAO;
import br.sistema.crud.jdbc.dto.PessoaDTO;

public class PessoaBOTest {
	
	PessoaBO pessoalBO = new PessoaBO();
	PessoaDTO pessoaDTO = new PessoaDTO();
	PessoaDAO pessoaDAO = new PessoaDAO();

	@Before
	public void setUp() throws Exception {
		pessoaDTO.setNome("Bergony2");
		
	}

	@Test
	public void cadastraPassTest() {
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);

			PessoaDTO pessoaDTO2 = new PessoaDTO();
			pessoaDTO2.setNome("Lucas");
			
			pessoalBO.cadastrar(pessoaDTO2, pessoaDAO);
		} catch (Exception e) {
			fail("Falhou a cadastrar a pessoal.");
		}
		
	}
	
	@Test
	public void listagemTest() {
		try {
			
			List<Integer> idsPessoas = new ArrayList<Integer>();
			
			String[][] listaRetorno = null;
			
			listaRetorno = pessoalBO.listagem(idsPessoas, pessoaDAO);
			assertEquals(listaRetorno.length, 1);
			

		} catch (Exception e) {
			
			fail("Falhou a cadastrar a pessoal com erro.");
		}
		
	}
	
}
