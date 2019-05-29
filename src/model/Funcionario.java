package model;

import modelinterface.IRHService.Tipo;

public class Funcionario {
	
	private String nome;
	private long cpf;
	private Tipo tipo;
	
	public Funcionario(long cpf, String nome) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}
	
	public Funcionario(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", tipo=" + tipo + "]";
	}
	
	
}
