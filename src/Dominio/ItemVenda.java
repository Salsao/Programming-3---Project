package Dominio;


public class ItemVenda {
	
	private int id;
	private float valorVenda;
	private int quant;
	private Produto pro;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public Produto getPro() {
		return pro;
	}

	public void setPro(Produto pro) {
		this.pro = pro;
	}

        
	public ItemVenda(int id, int quant, Produto pro){
		this.id = id;
		this.quant = quant;
		this.pro = pro;
	}

	

}
