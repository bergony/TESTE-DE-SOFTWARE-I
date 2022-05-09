package param;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CalculoImpostoRendaTest extends CalculoImpostoRenda {

	 @Parameter(0)
	 public double entrada;
	 @Parameter(1)
	 public double esperado;
	 
	 
	 @Parameters
	 public static Iterable<Object[]> data() {
	 return Arrays.asList(new Object[][] { 
	 { 200, 200 }, 
	 { 2000, 2200 }, 
	 { 10000, 11500 }, 
	 { 20000, 24000 },
	 { 0, 0 },
	 { -1, -1 }
	 
	 });
	 }
	 
	@Test
	public void verificar() {
		assertEquals(esperado, CalculoImpostoRenda.calculaImposto(entrada), 0);
	}
	
	@Test
	public void verificarInvalido() {
		assertEquals(esperado, CalculoImpostoRenda.calculaImposto(-20000L), 0);
	}

}
