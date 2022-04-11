package ufrn.br;

public class Operador {
	
	public Operador() {
	}

	public float soma( float num1, float num2) {
		return num1+num2;
	}
	
	public float sub( float num1, float num2) {
		return num1-num2;
	}
	
	public float div( float num1, float num2) {
		return num1/num2;
	}
	public float mul( float num1, float num2) {
		return num1*num2;
	}
	
	public float inv( float num1) {
		return 1/num1;
	}
	
	public float power( float num1, int power){
		
		float mult = num1;
		
		if(power == 0) return 1;
		
		if(power == 1) return num1;
		
		for(int x = 2; x < power; x++) {
			num1 = num1 * mult;
		}
		
		return num1;
	}
	
	public float sqd( float num1) {
		float t;
		float squareroot = num1 / 2;
		do 
		{
		t = squareroot;
		squareroot = (t + (num1 / t)) / 2;
		}
		while ((t - squareroot) != 0);
		return squareroot;
	}

}
