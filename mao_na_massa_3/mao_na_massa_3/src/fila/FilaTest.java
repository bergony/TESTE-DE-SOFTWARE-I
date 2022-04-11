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

}
