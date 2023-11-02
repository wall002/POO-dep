package model;

import java.util.List;

import dao.DependenteDAO;

public class Dependente {
	
	private int codigo;
	private int codigoDoFuncionario;
    private String nome;
    private double mesada;
    
    public Dependente(int codigo, int codigoDoFuncionario, String nome, double mesada){
        this.codigo = codigo;
    	this.codigoDoFuncionario = codigoDoFuncionario;
        this.nome = nome;
        this.mesada = mesada;
    }
    
    public Dependente(int codigoDoFuncionario, String nome, double mesada){
    	this.codigoDoFuncionario = codigoDoFuncionario;
    	this.nome = nome;
        this.mesada = mesada;
    }

    public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoDoFuncionario() {
        return codigoDoFuncionario;
    }

    public void setCodigoDoFuncionario(int codigoDoFuncionario) {
        this.codigoDoFuncionario = codigoDoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMesada() {
        return mesada;
    }

    public void setMesada(double mesada) {
        this.mesada = mesada;
    }

    @Override
    public String toString() {
        return "Dependente{"+ "codigo=" + codigo + ",codigoDoFuncionario=" + codigoDoFuncionario + ", nome=" + nome + ", mesada=" + mesada + '}';
    }
    
    public boolean cadastrar(){
        return DependenteDAO.adicionarDependente(this);
    }
    
    public static List<Dependente> listarDependentes(){
        return DependenteDAO.listarDependentes();
    }

    public static List<Dependente> listarDependentesPorNome(String nome){
        return DependenteDAO.listarDependentesPorNome(nome);
    }

}
