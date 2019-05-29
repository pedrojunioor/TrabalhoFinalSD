package model;

import modelinterface.IRHService;
import modelinterface.IRHService.Tipo;

public class Terceirizado extends Funcionario {
	
	private boolean insalubridade;

	private static Tipo tipo = IRHService.Tipo.TERC;

	public Terceirizado(long cpf, String nome, boolean insalubridade) {
		super(cpf, nome);
		setInsalubridade(insalubridade);
	}

	public boolean isInsalubridade() {
		return insalubridade;
	}

	public void setInsalubridade(boolean insalubridade) {
		this.insalubridade = insalubridade;
	}
}
