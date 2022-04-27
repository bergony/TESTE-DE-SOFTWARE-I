package br.sistema.crud.jdbc.bo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.sistema.crud.jdbc.dao.PessoaDAO;
import br.sistema.crud.jdbc.dto.EnderecoDTO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.dto.UfDTO;

public class PessoaBOTest {
	
	PessoaBO pessoalBO = new PessoaBO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	PessoaDTO pessoaDTO = new PessoaDTO();
	EnderecoDTO enderecoDTO = new EnderecoDTO();
	UfDTO ufDTO = new UfDTO();

	@Before
	public void setUp() throws Exception {
		
		pessoaDTO.setNome("bergony");
		pessoaDTO.setCpf(31238912087l);
		pessoaDTO.setDtNascimento(new Date());
		
		enderecoDTO = new EnderecoDTO();
		enderecoDTO.setBairro("Nova");
		enderecoDTO.setCep(59151650);
		enderecoDTO.setCidade("Natal");
		enderecoDTO.setLogradouro("casa");
		enderecoDTO.setNumero(1l);
		
		ufDTO = new UfDTO();
	
		ufDTO.setDescrcao("nada");
		ufDTO.setSiglaUF("AA");
		enderecoDTO.setUfDTO(ufDTO);
		
		pessoaDTO.setEnderecoDTO(enderecoDTO);
		pessoaDTO.setSexo('M');
	}

	@Test
	public void cadastraPassTest() {
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
		} catch (Exception e) {
			fail("Falhou a cadastrar a pessoal.");
		}
	}
	
	@Test
	public void listagemTest() {
		try {
			
			List<Integer> idsPessoas = new ArrayList<Integer>();
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			pessoaDAO.listarTodos().forEach(u -> {
				idsPessoas.add(u.getIdPessoa());
			});
			
			String[][] listaRetorno = null;
			
			listaRetorno = pessoalBO.listagem(idsPessoas, pessoaDAO);
			
			for (String[] strings : listaRetorno) {
				assertEquals(strings[0], "0");
				assertEquals(strings[1], "bergony");
				assertEquals(strings[2], "31238912087");
				assertEquals(strings[3], "Masculino");
				assertEquals(strings[4], "27/04/2022");
				assertEquals(strings[5], "casa");
				assertEquals(strings[6], "AA");
				assertEquals(strings[7], "59151650");
			}
			
			assertEquals(listaRetorno.length, 1);
			

		} catch (Exception e) {
			
			fail("Falhou a cadastrar a pessoal com erro.");
		}
		
	}
	
	@Test 
	public void ValidarNomeVazio() {

		try {
			pessoalBO.validaNome("");
			fail("nome invalido");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void ValidarNomeNUll() {

		try {
			pessoalBO.validaNome(null);
			fail("nome invalido");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void ValidarNomeMaxLenght() {

		try {
			pessoalBO.validaNome("bergonybergonybergonybergonybergonybergonybergonybergonybergonybergonybergonybergonybergony");
			fail("nome invalido");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void ValidarCpf() {

		try {
			pessoalBO.validaCpf("bergonybergonybergonybergonybergonybergonybergonybergonybergonybergonybergonybergonybergony");
			fail("nome invalido");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
