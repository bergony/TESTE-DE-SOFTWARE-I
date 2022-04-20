package temperature;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ConversorTemperaturaTest {
	
	
	Fahrenheit fahrenheit = new Fahrenheit();
	Celsius celsius = new Celsius();
	ConversorTemperatura conversorTemperatura;

	
	@Parameter(0)
	public double entradaCel;
	@Parameter(1)
	public double esperadoCel;
	
	@Parameter(2)
	public double entradaFah;
	@Parameter(3)
	public double esperadoFah;


	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 20, 68, 20, -6.67 }, 
			{ 1, 33.8, 10, -12.22 }, 
			{ 40, 104, 104, 40 } , 
			{ -17.7778, 0, 0, -17.7778 } , 
			{ -17.7778, 0, 0, -17.7778 } 
			
		});
	}

	@Before
	public void setUp() throws Exception {
		celsius.setValue(entradaCel);
		fahrenheit.setValue(entradaFah);
		conversorTemperatura = new ConversorTemperatura();
		
	}

	@Test
	public void converCelsiusTest() throws TempException {
		
		Temperatura tempFah = new Fahrenheit();
		tempFah = conversorTemperatura.converte(celsius);
		
		assertEquals(esperadoCel, tempFah.getValue(),0.1);
	}
	
	@Test
	public void converFahrenheitTest() throws TempException {
		Temperatura tempCel = new Celsius();
		tempCel = conversorTemperatura.converte(fahrenheit);
		
		assertEquals(esperadoFah, tempCel.getValue(),0.1);
	}
	
	@Test
	public void zeroAbsolutoCelsiusTeste() throws TempException {
		
		try {
			celsius.setValue(entradaCel);
		} catch (Exception e) {
			fail("Valor abaixo do zero abosluto");
		}
	}
	
	@Test
	public void zeroAbsolutoFahrenheitTeste() throws TempException {
		
		try {
			fahrenheit.setValue(entradaFah);
		} catch (Exception e) {
			fail("Valor abaixo do zero abosluto");
		}
	}

}
