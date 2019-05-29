package modelinterface;

import java.util.List;

import model.Funcionario;

public interface IRHService{

	public enum Tipo{PROF, STA, TERC};
	
	void mostrarMenu();
	
    boolean cadastrar(Funcionario funcionario);

    boolean remover(long cpf);

    Funcionario obterFuncionario(long cpf);
    
    List<Funcionario> getFuncionarios();

    List<Funcionario> getFuncionariosPorCategoria(IRHService.Tipo tipo);
    
    int getTotalFuncionarios();

    Double calcularSalario(long cpf);
    
    double calcularFolhaDePagamento();
}
