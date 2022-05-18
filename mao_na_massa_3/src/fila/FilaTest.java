package fila;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FilaTest {

	Fila fila;
	
	@Before
	public void setUp() throws Exception {
		
		fila = new Fila(5);
	}

	@Test
	public void inserirNaFila() {

		
		Fila fila2 = new Fila();
		
		Object obj = new Object();
		
		fila.insereNaFila(obj);
		assertEquals(1, fila.tamanho());

	}
	
	@Test
	public void estaVazia() {

		Object obj = new Object();
		
		fila.insereNaFila(obj);
		fila.removeDaFila();
		
		assertEquals(0, fila.tamanho());
		assertTrue(fila.estaVazia());
		fila.insereNaFila(obj);
		assertTrue(!fila.estaVazia());

	}
	

	@Test	
	public void estaCheia() {
		for (int i = 0; i < 5; i++) {
			Object obj = new Object();
			fila.insereNaFila(obj);
		}
		assertTrue(fila.estaCheia());
		assertEquals(5, fila.tamanho());
		fila.removeDaFila();
		assertTrue(!fila.estaCheia());


	}


	@Test	
	public void limparFila() {
		for (int i = 0; i < 5; i++) {
			Object obj = new Object();
			fila.insereNaFila(obj);
		}
		
		fila.limpaFila();
		assertEquals(0, fila.tamanho());
		assertTrue(fila.estaVazia());

	}
	
	
	@Test	
	public void removerInicio() {
		
		Object obj = new Object();
		
		fila.insereNaFila(obj);
		
		for (int i = 0; i < 2; i++) {
			Object obj2 = new Object();
			fila.insereNaFila(obj2);
		}
		
		Object objRemove = fila.removeDaFila();
		
		assertEquals(obj, objRemove);

	}
	
	@Test	
	public void inserirFinal() {
		
		Object obj = new Object();
		
		fila.insereNaFila(obj);
		
		for (int i = 0; i < 2; i++) {
			Object obj2 = new Object();
			fila.insereNaFila(obj2);
		}
		
		Object objRemove = fila.removeDaFila();
		
		assertEquals(obj, objRemove);

	}
	
	@Test	
	public void constrGetSet() {
		
		Fila filaTeste = new Fila(5);
		
		assertEquals(filaTeste.getCapacidade(), 5);
		assertEquals(filaTeste.getTam(), 5);
		filaTeste.setFim(1);
		assertEquals(filaTeste.getFim(), 1l);
	}
	
	@Test	
	public void filaCheiaThrow() {
		try {
			Fila filaTeste = new Fila();
			Object obj = new Object();
			Object obj2 = new Object();
			Object obj3 = new Object();
			Object obj4 = new Object();
			Object obj5 = new Object();
			Object obj6 = new Object();
			
			
			filaTeste.insereNaFila(obj);
			filaTeste.insereNaFila(obj2);
			filaTeste.insereNaFila(obj3);
			filaTeste.insereNaFila(obj4);
			filaTeste.insereNaFila(obj5);
			filaTeste.insereNaFila(obj5);
			
		} catch (FilaCheiaException e) {

			var expectedException =
				      assertThrows(
				    		  FilaCheiaException.class,
				          () -> {
				            throw new FilaCheiaException();
				          });
			  assertEquals(e.getMessage(), expectedException.getMessage());
		} 
		
		
	}
	
	
	


}
