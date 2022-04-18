package fila;

import static org.junit.Assert.*;

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
	
	
	


}
