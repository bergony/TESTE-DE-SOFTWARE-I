package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameSellerTest {

	
	GameSeller gameSeller;
	
	@Before
	public void setUp() throws Exception {
		gameSeller = new GameSeller();
	}

	@Test
	public void testValidos() throws ArgumentoInvalidoException {
		assertEquals(gameSeller.calculaPreco(GameSeller.JOGO_TABULEIRO, 20.0), 50.0, 0);
		assertEquals(gameSeller.calculaPreco(GameSeller.JOGO_TABULEIRO, 210.0), 210.0, 0);
		assertEquals(gameSeller.calculaPreco(GameSeller.JOGO_STREAM, 20.0), 20.0, 0);
		assertEquals(gameSeller.calculaPreco(GameSeller.JOGO_DVD, 20.0), 50.0, 0);
		assertEquals(gameSeller.calculaPreco(GameSeller.JOGO_DVD, 110.0), 130.0, 0);
		
		
	}
	
	@Test
	public void testInvalidos() throws ArgumentoInvalidoException {
		
		try {
			assertEquals(gameSeller.calculaPreco(GameSeller.JOGO_TABULEIRO, (Double) null), 50.0, 0);
			fail("Falho a passa no teste");
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}

}
