package banco;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	Conta pagar;
	Conta receber;
	
	@Before
	public void setUp() throws Exception {
		pagar = new Conta("0", 10);
		receber = new Conta("1", 20);

	}

	@Test
	public void verificarValorTraferido() throws OperacaoIlegalException {
		
		pagar.transferir(receber, 5);
		assertEquals(receber.getSaldo(), 25, 0);
		assertEquals(pagar.getSaldo(), 5, 0);
		
	}
	
	@Test
	public void verificarTraferidoValorNegativo() throws OperacaoIlegalException {
		
		try {
			pagar.transferir(receber, -5);
			
			fail("Falho a verificar valor negativo");
		} catch (OperacaoIlegalException e) {

			var expectedException =
				      assertThrows(
				    	  OperacaoIlegalException.class,
				          () -> {
				            throw new OperacaoIlegalException();
				          });
			assertEquals(receber.getSaldo(), 20, 0);
			assertEquals(pagar.getSaldo(), 10, 0);
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}  
	}
	
	@Test
	public void verificarSaldoInsuficiente() throws OperacaoIlegalException {
		
		try {
			pagar.transferir(receber, 0);
			fail("Falho a verificar saldo insuficiente");
		} catch (OperacaoIlegalException e) {

			var expectedException =
				      assertThrows(
				    	  OperacaoIlegalException.class,
				          () -> {
				            throw new OperacaoIlegalException();
				          });
			assertEquals(receber.getSaldo(), 20, 0);
			assertEquals(pagar.getSaldo(), 10, 0);
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}  
	}
	
	
	@Test
	public void verificarSemDebito() throws OperacaoIlegalException {
		
		try {
			pagar.debitar(11);
			fail("Falho a verificar saldo insuficiente");
		} catch (OperacaoIlegalException e) {

			var expectedException =
				      assertThrows(
				    	  OperacaoIlegalException.class,
				          () -> {
				            throw new OperacaoIlegalException();
				          });
			assertEquals(receber.getSaldo(), 20, 0);
			assertEquals(pagar.getSaldo(), 10, 0);
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}  
	}
	
	@Test
	public void verificarSemDebitoSaldo() throws OperacaoIlegalException {
		
		try {
			
			Conta contaVazia = new Conta("2", 0);
			contaVazia.debitar(2);
			contaVazia.debitar(-1);
			fail("Falho a verificar saldo insuficiente");
		} catch (OperacaoIlegalException e) {

			var expectedException =
				      assertThrows(
				    	  OperacaoIlegalException.class,
				          () -> {
				            throw new OperacaoIlegalException();
				          });
			assertEquals(receber.getSaldo(), 20, 0);
			assertEquals(pagar.getSaldo(), 10, 0);
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}  
	}
	
	
	


}
