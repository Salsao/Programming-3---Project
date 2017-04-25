package Dominio;

import java.util.Date;
import java.util.ArrayList;


public abstract class Venda {

	protected int id;
	protected Date data;
	protected ArrayList<ItemVenda> itensVenda;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public ArrayList<ItemVenda> getItensVenda() {
		return itensVenda;
	}
	public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public void inserirItemVenda(ItemVenda item){
		this.itensVenda.add(item);
	}
	public void removerItemVenda(ItemVenda item){
		this.itensVenda.remove(item);
	}
	
	public float calcularValorTotal(){
		float valor = 0;
                if (this.itensVenda != null)
                     for(int x = 0; x < this.itensVenda.size(); x++){
                        valor += this.itensVenda.get(x).getQuant() * this.itensVenda.get(x).getValorVenda();
                    }
		return valor;
	}
	
	public Venda(int id, Date data){
		super();
                this.itensVenda = new ArrayList<ItemVenda>();
		this.id = id;
		this.data = data;
	}

}
