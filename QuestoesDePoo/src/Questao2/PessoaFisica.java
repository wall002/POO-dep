/* Na classe PessoaFisica crie os atributos
cpf(String), cargo (String) e salario (double).*/

package Questao2;

public class PessoaFisica {
	
	private String cpf, cargo;
	private double salario;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

}
