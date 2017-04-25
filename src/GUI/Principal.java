package GUI;

import Dominio.Loja;
import Dominio.Cliente;
import Dominio.Produto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;


public class Principal {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

	Loja L = new Loja();

	FileReader reader = new FileReader("C:/produtos.txt"); // Localizacao do Arquivo  
	String linha = null;
	
	try {
            BufferedReader leitor = new BufferedReader(reader);  
            StringTokenizer st = null;  
            while ((linha = leitor.readLine()) != null) {
                st = new StringTokenizer(linha, ";");
  	      	while ((linha = leitor.readLine()) != null) {
  	      		
                    int n = Integer.parseInt(st.nextToken());
                    st = new StringTokenizer(linha, ";");     
                    int i = 0;
                    while ( i < n){
                    	int id = Integer.parseInt(st.nextToken());
  	             	String nome = st.nextToken();
  	             	String descricao = st.nextToken();
  	             	float valor = Float.parseFloat(st.nextToken());
  	             	Produto p = new Produto(id, nome, descricao, valor);
  	             	L.inserirProduto(p);
  	             	i += 1;
  	             	if ((linha = leitor.readLine()) != null)
  	             		st = new StringTokenizer(linha, ";");
                    }
                }
            }
            reader.close();
  	    FileReader reader2 = new FileReader("C:/clientes.txt"); // Localiza��o do Arquivo  
            String linha2 = null;
  	    BufferedReader leitor2 = new BufferedReader(reader2);  
            StringTokenizer st2 = null;  
            while ((linha2 = leitor2.readLine()) != null) {
                st2 = new StringTokenizer(linha2, ";");
                int a = Integer.parseInt(st2.nextToken());
                int h = 0;
                while ((linha2 = leitor2.readLine()) != null) {
                    st2 = new StringTokenizer(linha2, ";");
                    while (h < a){
                        int id = Integer.parseInt(st2.nextToken());
                        String nome = st2.nextToken();
                        String cpf = st2.nextToken();
                        Cliente c = new Cliente(id, nome, cpf);
                        L.inserirCliente(c);
                        h += 1;
                        if ((linha2 = leitor2.readLine()) != null)
                        st2 = new StringTokenizer(linha2, ";");
                    };
                };
            }
  	    reader2.close();
        }
  	catch (Exception e) {  
            e.printStackTrace();  
        }
      
        JanelaPrincipal jp = new JanelaPrincipal();       
        jp.setLoja(L);
        jp.inicializaComponentes();
        jp.setVisible(true);
    }
}
        
        

    





