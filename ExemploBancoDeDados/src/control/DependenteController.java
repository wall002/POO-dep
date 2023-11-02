package control;

import java.util.ArrayList;
import java.util.List;

import model.Dependente;

public class DependenteController {
	public boolean adicionarDependente(int codigoDoFuncionario, String nome, double mesada){       
        Dependente dependente = new Dependente(codigoDoFuncionario, nome, mesada);
        return dependente.cadastrar();
    }
    
    public List<String[]> listarDependentes(){
        List<String[]> dadosDependentes = new ArrayList<>();
        List<Dependente> dependentes = Dependente.listarDependentes();        
        for (Dependente dependente : dependentes){
            String[] dadosDependente = new String[4];
            dadosDependente[0] = String.valueOf(dependente.getCodigo());
            dadosDependente[1] = String.valueOf(dependente.getCodigoDoFuncionario());
            dadosDependente[2] = dependente.getNome();
            dadosDependente[3] = String.valueOf(dependente.getMesada());
            dadosDependentes.add(dadosDependente);
        }        
        return dadosDependentes;
    }
    
    public List<String[]> listarDependentesPorNome(String nome){
        List<String[]> dadosDependentes = new ArrayList<>();
        List<Dependente> dependentes = Dependente.listarDependentesPorNome(nome);        
        for (Dependente dependente : dependentes){
            String[] dadosDependente = new String[4];
            dadosDependente[0] = String.valueOf(dependente.getCodigo());
            dadosDependente[1] = String.valueOf(dependente.getCodigoDoFuncionario());
            dadosDependente[2] = dependente.getNome();
            dadosDependente[3] = String.valueOf(dependente.getMesada());
            dadosDependentes.add(dadosDependente);
        }        
        return dadosDependentes;
    } 
}
