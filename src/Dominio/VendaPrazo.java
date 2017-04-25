package Dominio;

import java.util.Date;

public class VendaPrazo extends Venda {
	
	private Cliente cli;
	
	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public VendaPrazo(int id, Date data, Cliente cli){
		super(id, data);
		this.cli = cli;
		}
}
