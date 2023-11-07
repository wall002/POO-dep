package model;

import java.util.List;

import dao.CarroDAO;
import dao.CompradorDAO;

public class Comprador {

	private int id;
	private String nome;
	private String cpf;
	private String placa_Carro;

	public Comprador(int id, String nome, String cpf, String placa_Carro) {

		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.placa_Carro = placa_Carro;
	}

	public Comprador(String nome, String cpf, String placa_Carro) {

		this.nome = nome;
		this.cpf = cpf;
		this.placa_Carro = placa_Carro;
	}

	public Comprador(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPlaca_Carro() {
		return placa_Carro;
	}

	public void setPlaca_Carro(String placa_Carro) {
		this.placa_Carro = placa_Carro;
	}

	@Override
	public String toString() {
		return "Comprador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", placa_Carro=" + placa_Carro + "]";
	}

	public boolean cadastrar() {
		return CompradorDAO.adicionarComprador(this);
	}

	public boolean atualizar() {
		return CompradorDAO.atualizarComprador(this);
	}

	public boolean apagar() {
		return CompradorDAO.apagarComprador(this);
	}

	public static List<Comprador> listarCompradores() {
		return CompradorDAO.listarCompradores();
	}

	public static List<Comprador> listarCompradoresPorNome(String nome) {
		return CompradorDAO.listarCompradoresPorNome(nome);
	}

}
