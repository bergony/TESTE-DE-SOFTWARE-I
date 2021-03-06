package fila;

public class Fila implements IFila {

	private static final int capacidade = 5;
	private Object[] Fila;  //Array que representa a fila
	private final int tam; // capacidade total da fila
	private int fim = -1; //final da fila

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public int getTam() {
		return tam;
	}
	
	public int getCapacidade() {
		return capacidade;
	}

	public Fila(){
		this(capacidade);
	}

	public Fila(int cap){
		tam = cap;
		Fila = new Object[tam];
	}

	public int tamanho() {
		return fim+1;
	}

	public boolean estaVazia() {
		return (fim == -1) ? true : false;
	}

	public boolean estaCheia() { 
		return (fim+1 == tam) ? true : false;
	}

	public void insereNaFila(Object obj) throws FilaCheiaException {
		
		try {

			fim++;
			Fila[fim] = obj;
		} catch (FilaCheiaException e) {
			throw new FilaCheiaException("Fila Cheia", new Throwable("ERRO"));
		} catch (Exception e) {
			throw new FilaCheiaException("Fila Cheia");
		}
	}

	public Object removeDaFila() throws FilaVaziaException {
		Object item = Fila[0];
		for(int k = 1; k < fim+1; k++) {
			Fila[k-1] = Fila[k];
		}
		
		fim--;
		return item;
	}

	public void limpaFila(){
		for(int i=0; i < tam; i++)
			Fila[i] = null;
		fim=-1;
	}
}
