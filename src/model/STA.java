package model;

import modelinterface.IRHService;
import modelinterface.IRHService.Tipo;

public class STA extends Funcionario {
	
	private static Tipo tipo = IRHService.Tipo.STA;


	public STA(long cpf, String nome) {
		super(cpf, nome);
	}

}
