
package model;

import java.util.List;
import dao.CarroDAO;

public class Carro {

	private String placa;
	private String modelo;
	private int ano;
	private String cor;

	public Carro(String placa, String modelo, int ano, String cor) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
	}
	
	public Carro(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + "]";
	}

	public boolean cadastrar() {
		return CarroDAO.adicionarCarro(this);
	}
	
	public boolean atualizar() {
	    return CarroDAO.atualizarCarro(this);
	}
	
	public boolean apagar() {
	    return CarroDAO.apagarCarro(this);
	}

	public static List<Carro> listarCarros() {
		return CarroDAO.listarCarros();
	}

	public static List<Carro> listarCarrosPorModelo(String modelo) {
		return CarroDAO.listarCarrosPorModelo(modelo);
	}

}
