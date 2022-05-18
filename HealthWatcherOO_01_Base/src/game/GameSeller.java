package game;

public class GameSeller {

	
	public static int JOGO_TABULEIRO = 1;
	public static int JOGO_STREAM = 2;
	public static int JOGO_DVD = 3;
	
	public static void main(String[] args) throws ArgumentoInvalidoException {

	}
	
	
	/* Este m�todo retorna o pre�o calculado para um Jogo comprado na loja virtual GameSeller. Se
	o Jogo for de tabuleiro a cobran�a do frete deve ser de 30 reais em todas as compras abaixo de
	200 reais, caso contr�rio o frete ser� gr�tis. Se o jogo for STREAM nunca ser� comprado frete.
	Se o jogo for em DVD o valor de frete ser� de 30 reais (para compras at� 100 reais) e de 20 reais
	para compras superiores a 100 reais. Caso algum dos par�metros seja invalido o m�todo deve
	lan�ar ArgumentoInvalidoException */
	
	public double calculaPreco (int tipoJogo, double valor) throws ArgumentoInvalidoException
	{
		double frete = 0;
		
		switch (tipoJogo) {
		case 1:
			
			if(valor < 200) {
				frete = 30;
			}
			break;
		case 3:
			
			if(valor < 100) {
				frete = 30;
			}else {
				frete = 20;
			}
			
			break;
		default:
			break;
		}
		
		return valor+frete;
	}

}
