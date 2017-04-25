package Dominio;

import java.util.ArrayList;
import java.util.Random;


public class Loja {
	
	private String nome;
	private ArrayList<Produto> produtos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Venda> vendas;
	
	public Loja(){
		this.produtos = new ArrayList<Produto>();
		this.clientes = new ArrayList<Cliente>();
		this.vendas = new ArrayList<Venda>();
	}
        
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public ArrayList<Venda> getVendas() {
		return vendas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Loja(String nome){
		this.nome = nome;
	}
	public void inserirProduto(Produto pro){
		this.produtos.add(pro);
	}
	public void removeProduto(Produto pro){
		this.produtos.remove(pro);
	}
	public void inserirCliente(Cliente cli){
		this.clientes.add(cli);
	}	
	public void removerCliente(Cliente cli){
		this.clientes.remove(cli);
	}	
	public void inserirVenda(Venda ven){
		this.vendas.add(ven);
	}	
	public void removerVenda(Venda ven){
		this.vendas.remove(ven);
	}

        public boolean existe(int id){
            for (int i=0; i < this.getProdutos().size(); i++){
                if (id == this.getProdutos().get(i).getId())
                    return true;
            }
            for (int i=0; i < this.getClientes().size(); i++){
                if (id == this.getClientes().get(i).getId())
                    return true;
            }
            for (int i=0; i < this.getVendas().size(); i++){
                if (id == this.getVendas().get(i).getId())
                    return true;
            }
            return false;
        }
        
        public int geraId(){
            int id;
            
            do{
            Random geradorID = new Random();
            id = geradorID.nextInt(1000);
            
            if (existe(id) == false){
                return id;
            }
            }while(existe(id) == true);
            
            return -1;
        }
}
