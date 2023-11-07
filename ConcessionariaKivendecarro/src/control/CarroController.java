package control;

import java.util.ArrayList;
import java.util.List;
import model.Carro;

public class CarroController {
    
    public boolean adicionarCarro(String placa, String modelo, int ano, String cor){       
        Carro carro = new Carro(placa, modelo, ano, cor);
        return carro.cadastrar();
    }
    
    public boolean atualizarCarro(String placa, String modelo, int ano, String cor){       
        Carro carro = new Carro(placa, modelo, ano, cor);
        return carro.atualizar();
    }
    
    public boolean apagarCarro(String placa){       
        Carro carro = new Carro(placa);
        return carro.apagar();
    }
    
    public List<String[]> listarCarros(){
        List<String[]> dadosCarros = new ArrayList<>();
        List<Carro> carros = Carro.listarCarros();        
        for (Carro carro : carros){
            String[] dadosCarro = new String[4];
            dadosCarro[0] = carro.getPlaca();
            dadosCarro[1] = carro.getModelo();
            dadosCarro[2] = String.valueOf(carro.getAno());
            dadosCarro[3] = carro.getCor();
            dadosCarros.add(dadosCarro);
        }        
        return dadosCarros;
    }
    
    public List<String[]> listarCarrosPorModelo(String modelo){
        List<String[]> dadosCarros = new ArrayList<>();
        List<Carro> carros = Carro.listarCarrosPorModelo(modelo);        
        for (Carro carro : carros){
            String[] dadosCarro = new String[4];
            dadosCarro[0] = carro.getPlaca();
            dadosCarro[1] = carro.getModelo();
            dadosCarro[2] = String.valueOf(carro.getAno());
            dadosCarro[3] = carro.getCor();
            dadosCarros.add(dadosCarro);
        }        
        return dadosCarros;
    }    
        
}
