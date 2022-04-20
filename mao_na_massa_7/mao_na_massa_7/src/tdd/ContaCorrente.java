package tdd;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {
	
	private double saldo;
	private double saldoInicial;
	private String name;
	private String data;
	
	private List<String> historicoData = new ArrayList<String>();

	public ContaCorrente() {
		saldoInicial = 0.0;
	}

	public ContaCorrente(double saldo) {
		this.saldo = saldo;
		this.saldoInicial = 0.0;
	}

	public ContaCorrente(String name) {
		this.name = name;
	}

	public ContaCorrente(String name, double saldo) {
		this.name = name;
		this.saldo += saldo;
		this.saldoInicial = saldo;

	}

	public void creditar(Deposito deposito) {
		this.saldo += deposito.valor;
		this.saldoInicial += 0.0;
		String extrato = deposito.data+"\tDeposito\t$"+(int)deposito.valor+"\n";
		
		this.historicoData.add(extrato);
		
	}

	public double saldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String extrato() {
		// TODO Auto-generated method stub
		
		String saldo = "";

			saldo = "Saldo Inicial $"+(int)this.saldoInicial+"\n";
			saldo += "Saldo Final $"+(int)this.saldo+"\n";
			
			if(!historicoData.isEmpty()) {
				for (String string : historicoData) {
					saldo += string;
				}
				
			}else {
				saldo += "Nenhuma trasacao realizada\n";
			}
		
		return "Conta de "+this.name+"\n" + saldo;
		
	}

}
