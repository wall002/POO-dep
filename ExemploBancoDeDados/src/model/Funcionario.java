
package model;

import dao.FuncionarioDAO;
import java.util.List;

public class Funcionario {
    
    private int codigo;
    private String nome;
    private String cargo;
    private double salario;
    
    public Funcionario(int codigo, String nome, String cargo, double salario){
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }
    
    public Funcionario(String nome, String cargo, double salario){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Funcionario{" + "codigo=" + codigo + ", nome=" + nome + ", cargo=" + cargo + ", salario=" + salario + '}';
    }
    
    public boolean cadastrar(){
        return FuncionarioDAO.adicionarFuncionario(this);
    }
    
    public static List<Funcionario> listarFuncionarios(){
        return FuncionarioDAO.listarFuncionarios();
    }

    public static List<Funcionario> listarFuncionariosPorNome(String nome){
        return FuncionarioDAO.listarFuncionariosPorNome(nome);
    }    
    
}
