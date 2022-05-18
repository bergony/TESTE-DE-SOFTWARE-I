package lib.util;

import static org.junit.Assert.*;

import javax.xml.crypto.Data;

import org.junit.Before;
import org.junit.Test;

import lib.exceptions.InvalidDateException;

public class DateTest {

	
	Date data;
	
	@Before
	public void setUp() throws Exception {
		
		data = new Date(20,07,2022);
	}

	@Test
	public void testAddDias() throws InvalidDateException {
		Date old = new Date(22,07,2022);
		String dataOld = old.toString();
		Date.addDias(data, 2);
		String dataNew = data.toString();
		
		assertEquals(dataOld, dataNew);
	}

	@Test
	public void testAnteriorData() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompara() {
		fail("Not yet implemented");
	}

	@Test
	public void testDiferencaEmDias() {
		fail("Not yet implemented");
	}

	@Test
	public void testDiferencaEmSegundos() {
		fail("Not yet implemented");
	}

	@Test
	public void testEhFinalDeSemana() {
		fail("Not yet implemented");
	}

	@Test
	public void testEhFinalDeSemanaDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatDateInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testProximaData() {
		fail("Not yet implemented");
	}

}
