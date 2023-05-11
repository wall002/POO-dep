/*Elaborar um programa com uma classe Pessoa como classe
abstrata. Construa a classe para Pessoa Física e outra classe
para Pessoa Juridica. A classe Pessoa possui um código (long)
e um nome (String). Na classe PessoaFisica crie os atributos
cpf(String), cargo (String) e salario (double). Na classe
PessoaJuridica crie os atributos cnpj (String), ramo de
atuação (String). Crie os métodos get e set para cada
atributo de todas as classes. Na classe principal que possui
o método main, crie um objeto pessoa física e outro da pessoa
jurídica.*/

package Questao2;

public abstract class Pessoa {
	
	private long codigo;
	private String nome;
	
	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
