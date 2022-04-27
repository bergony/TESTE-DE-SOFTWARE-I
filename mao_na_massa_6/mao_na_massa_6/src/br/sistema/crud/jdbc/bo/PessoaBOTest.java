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
import br.sistema.crud.jdbc.exception.NegocioException;
import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public class PessoaBOTest {
	
	PessoaBO pessoalBO = new PessoaBO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	PessoaDTO pessoaDTO = new PessoaDTO();
	PessoaDTO pessoaDTO2 = new PessoaDTO();

	EnderecoDTO enderecoDTO = new EnderecoDTO();
	UfDTO ufDTO = new UfDTO();

	@Before
	public void setUp() throws Exception {
		
		pessoaDTO.setNome("bergony");
		pessoaDTO.setCpf(31238912087l);
		pessoaDTO.setDtNascimento(new Date());
		pessoaDTO.setSexo('M');
		
		pessoaDTO2.setNome("bergony2");
		pessoaDTO2.setCpf(31238912087l);
		pessoaDTO2.setDtNascimento(new Date());
		pessoaDTO2.setSexo('F');
		
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
		pessoaDTO2.setEnderecoDTO(enderecoDTO);
		
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
	public void cadastraFailTest() {
		try {
			pessoalBO.cadastrar(null, pessoaDAO);
			fail("Falhou a cadastrar a pessoal.");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void listagemMascTest() {
		try {
			
			List<Integer> idsPessoas = new ArrayList<Integer>();
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			pessoaDAO.listarTodos().forEach(u -> {
				idsPessoas.add(u.getIdPessoa());
			});
			
			String[][] listaRetorno = null;
			
			listaRetorno = pessoalBO.listagem(idsPessoas, pessoaDAO);
			
			for (String[] strings : listaRetorno) {
				assertEquals(strings[0], "2");
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
	public void listagemFemiTest() {
		try {
			
			List<Integer> idsPessoas = new ArrayList<Integer>();
			pessoalBO.cadastrar(pessoaDTO2, pessoaDAO);
			pessoaDAO.listarTodos().forEach(u -> {
				idsPessoas.add(u.getIdPessoa());
			});
			
			String[][] listaRetorno = null;
			
			listaRetorno = pessoalBO.listagem(idsPessoas, pessoaDAO);
			
			for (String[] strings : listaRetorno) {
				assertEquals(strings[0], "1"); 
				assertEquals(strings[1], "bergony2");
				assertEquals(strings[2], "31238912087");
				assertEquals(strings[3], "Feminino");
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
	public void listagemTestFail() {
		try {
			
			PessoaDTO usuarioERRo = new PessoaDTO();
			
			List<Integer> idsPessoas = new ArrayList<Integer>();
			pessoalBO.cadastrar(usuarioERRo, pessoaDAO);
			
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

			fail("Falhou a cadastrar a pessoal com erro.");

		} catch (Exception e) {
			
		}
		
	}
	
	@Test 
	public void validarNomeFailTest() {

		try {
			pessoalBO.validaNome("");
			fail("nome Inserido Com ERRO");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void validarNomeFailNullTest() {

		try {
			pessoalBO.validaNome(null);
			fail("nome Inserido Com ERRO");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void validarNomeFailSizeTest() {

		try {
			pessoalBO.validaNome("nome Inserido Com ERROnome Inserido Com ERROnome Inserido Com ERROnome Inserido Com ERROnome Inserido Com ERROnome Inserido Com ERRO");
			fail("nome Inserido Com ERRO");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@Test 
	public void validarNomePassTest() {
 
		try {
			pessoalBO.validaNome(pessoaDTO.getNome());
		} catch (Exception e) {
			fail("nome invalido");
		}
	}
	
	
	

	@Test 
	public void validarCPFFailTest() {

		try {
			pessoalBO.validaCpf("014564861a");
			fail("CPF Inserido Com ERRO");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void validarCPFFailNullTest() {

		try {
			pessoalBO.validaCpf(null); 
			fail("CPF Inserido Com ERRO");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test 
	public void validarCPFFailVazioTest() {

		try {
			pessoalBO.validaCpf(""); 
			fail("CPF Inserido Com ERRO");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void validarCPFFailNumeroTest() {

		try {
			pessoalBO.validaCpf("9889190109.");  
			fail("CPF Inserido Com ERRO");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@Test 
	public void validarCPFPassTest() {

		try {
			pessoalBO.validaCpf(pessoaDTO.getCpf().toString());
		} catch (Exception e) {
			fail("CPF invalido");
		}
	}
	

	@Test 
	public void validarEnderecoPassTest() {

		try {
			pessoalBO.validaEndereco(enderecoDTO);

		} catch (Exception e) {
			fail("Endereco invalido");
		}
	}
	
	@Test 
	public void validarEnderecoFailTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO");
		 } catch (Exception e) {
		}
	}
	@Test 
	public void validarEnderecoFailLougaVazioTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro("");
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO");
		 } catch (Exception e) {
		}
	}
	
	@Test 
	public void validarEnderecoFailBarrioNullTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro("asdfasd");
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO");
		 } catch (Exception e) {
		}
	}
	
	@Test 
	public void validarEnderecoFailBarrioVazioTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro("asdfasd");
			enderecoDTO.setBairro("");
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO"); 
		 } catch (Exception e) {
		}
	}
	
	@Test 
	public void validarEnderecoFailNumeroNullTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro("asdfasd");
			enderecoDTO.setBairro("asdf");
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO"); 
		 } catch (Exception e) {
		} 
	}
	
	@Test 
	public void validarEnderecoFailNumeroVazioTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro("asdfasd");
			enderecoDTO.setBairro("asdfdas");
			enderecoDTO.setNumero(0l); 
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO"); 
		 } catch (Exception e) {
		}
	}
	
	@Test 
	public void validarEnderecoFailCEPNUllTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro("asdfasd");
			enderecoDTO.setBairro("asdf");
			enderecoDTO.setNumero(1l); 
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO"); 
		 } catch (Exception e) {
		}
	}
	
	@Test 
	public void validarEnderecoFailCEPVazioTest() {

		try {
			enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro("asdfasd");
			enderecoDTO.setBairro("asdfdas");
			enderecoDTO.setNumero(1l); 

			enderecoDTO.setCep(0); 
			pessoalBO.validaEndereco(enderecoDTO);
			fail("Endereco Inserido Com ERRO"); 
		 } catch (Exception e) {
		}
	}
	
	@Test 
	public void validardDtaNasPassTest() {

		try {
			pessoalBO.validaDtNasc("23/07/1988");

		} catch (Exception e) {
			fail("Data Nascimento invalido");
		}
	}
	
	@Test 
	public void validarDtaNasFailTest() {

		try {
			pessoalBO.validaDtNasc("");
			fail("Data Nascimento Inserido Com ERRO");
		} catch (Exception e) {
		}
	}
	
	@Test 
	public void validarDtaNasFailNullTest() {

		try {
			pessoalBO.validaDtNasc(null);
			fail("Data Nascimento Inserido Com ERRO");
		} catch (Exception e) {
		}
	} 
	
	@Test 
	public void validarDtaNasFailInvalidTest() {

		try {
			pessoalBO.validaDtNasc("256548945");
			fail("Data Nascimento Inserido Com ERRO");
		} catch (Exception e) {
		}
	} 
	
	@Test 
	public void removerPessoaTest() throws PersistenciaExcpetion {

		
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			assertEquals(pessoaDAO.listarTodos().size(), 1l);
			pessoalBO.removePessoa(pessoaDTO.getIdPessoa(), pessoaDTO.getEnderecoDTO().getIdEndereco(), pessoaDAO);
			assertEquals(pessoaDAO.listarTodos().size(), 0l);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test 
	public void removerPessoaNUllTest() throws PersistenciaExcpetion {

		
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			assertEquals(pessoaDAO.listarTodos().size(), 1l);
			pessoalBO.removePessoa(2, pessoaDTO.getEnderecoDTO().getIdEndereco(), pessoaDAO);
			assertEquals(pessoaDAO.listarTodos().size(), 0l);
			fail("Remover Falhou");
		} catch (NegocioException e) {
		}
		
	}
	
	@Test 
	public void removerTudoTest() throws PersistenciaExcpetion {

		
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			pessoalBO.cadastrar(pessoaDTO2, pessoaDAO);
			assertEquals(pessoaDAO.listarTodos().size(), 2l);
			pessoalBO.removeTudo(pessoaDAO);
			
			assertEquals(pessoaDAO.listarTodos().size(), 0l);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test 
	public void removerTudoNullTest() throws PersistenciaExcpetion {

		
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			pessoalBO.cadastrar(pessoaDTO2, pessoaDAO);
			assertEquals(pessoaDAO.listarTodos().size(), 2l);
			pessoalBO.removeTudo(null);
			fail("Remover Falhou");
			assertEquals(pessoaDAO.listarTodos().size(), 0l);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test 
	public void buscarIDTest() throws PersistenciaExcpetion {

		
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			pessoalBO.cadastrar(pessoaDTO2, pessoaDAO);
			PessoaDTO pessoaBuscada = pessoalBO.buscaPorId(pessoaDTO2.getIdPessoa(), pessoaDAO);
			
			assertEquals(pessoaBuscada.getNome(), pessoaDTO2.getNome());
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test 
	public void buscarIDNUllTest() throws PersistenciaExcpetion {

		
		try {
			pessoalBO.cadastrar(pessoaDTO, pessoaDAO);
			pessoalBO.cadastrar(pessoaDTO2, pessoaDAO);
			PessoaDTO pessoaBuscada = pessoalBO.buscaPorId(220, pessoaDAO);
			
			assertEquals(pessoaBuscada.getNome(), pessoaDTO2.getNome());
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
