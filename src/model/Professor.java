package model;

import modelinterface.IRHService;
import modelinterface.IRHService.Tipo;

public class Professor extends Funcionario {
	private char classe;
	private static Tipo tipo = IRHService.Tipo.PROF;
	
	public Professor(long cpf, String nome, char classe) {
		super(cpf, nome);
		setClasse(classe);
	}

	public char getClasse() {
		return classe;
	}

	public void setClasse(char classe) {
		this.classe = classe;
	}

}
