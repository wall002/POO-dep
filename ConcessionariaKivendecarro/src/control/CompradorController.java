package control;

import java.util.ArrayList;
import java.util.List;

import model.Carro;
import model.Comprador;

public class CompradorController {
	
	public boolean adicionarComprador(String nome, String cpf, String placa_Carro){       
        Comprador comprador = new Comprador(nome, cpf, placa_Carro);
        return comprador.cadastrar();
    }
	
	public boolean atualizarComprador(int id, String nome, String cpf, String placa_Carro){       
        Comprador comprador = new Comprador(id, nome, cpf, placa_Carro);
        return comprador.atualizar();
    }
    
    public boolean apagarComprador(int id){       
    	Comprador comprador = new Comprador(id);
        return comprador.apagar();
    }
    
    public List<String[]> listarCompradores(){
        List<String[]> dadosCompradores = new ArrayList<>();
        List<Comprador> compradores = Comprador.listarCompradores();        
        for (Comprador comprador : compradores){
            String[] dadosComprador = new String[4];
            dadosComprador[1] = comprador.getNome();
            dadosComprador[2] = comprador.getCpf();
            dadosComprador[3] = comprador.getPlaca_Carro();
            dadosCompradores.add(dadosComprador);
        }        
        return dadosCompradores;
    }
    
    public List<String[]> listarCompradoresPorNome(String nome){
        List<String[]> dadosCompradores = new ArrayList<>();
        List<Comprador> compradores = Comprador.listarCompradoresPorNome(nome);        
        for (Comprador comprador : compradores){
            String[] dadosComprador = new String[4];
            dadosComprador[0] = String.valueOf(comprador.getId());
            dadosComprador[1] = comprador.getNome();
            dadosComprador[2] = comprador.getCpf();
            dadosComprador[3] = comprador.getPlaca_Carro();;
            dadosCompradores.add(dadosComprador);
        }        
        return dadosCompradores;
    } 
}
