package servente;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import model.Funcionario;
import model.Professor;
import model.STA;
import model.Terceirizado;
import modelinterface.IRHService;

public class RHService implements IRHService {

	List<Funcionario> FolhaDePagamento = new ArrayList<>();
	
		
	public RHService() {
		super();
	}
	
	public void mostrarMenu() {
		System.out.println("BEM VINDO AO CONTROLADOR DE FOLHA DE PAGAMENTO");
		System.out.println("LEGENDA");
		System.out.println("PROF: 1\nSTA: 2\nTERC: 3\n");
		System.out.println("| 1 -> Cadastrar Funcionario na Folha de Pagamento      |");
		System.out.println("| 2 -> Remover um Funcionario da folha de Pagamento     |");
		System.out.println("| 3 -> Obter folha de pagamento em Ordem Alfabetica     |");
		System.out.println("| 4 -> Obter Funcionarios por Categoria                 |");
		System.out.println("| 5 -> Obter total de funcionarios                      |");
		System.out.println("| 6 -> Ver salario do funcinario pelo CPF               |");
		System.out.println("| 7 -> Obter o total da Folha de Pagamento              |");
		System.out.println("| 0 -> SAIR                                             |");
	
	}
	
	public boolean cadastrar(Funcionario funcionario) {

		for (Funcionario func : FolhaDePagamento) {
			if (func.getCpf() == (funcionario.getCpf()))
				return false;
		}
		FolhaDePagamento.add(funcionario);
		return true;
	}

	public boolean remover(long cpf) {
		for (Funcionario func : FolhaDePagamento) {
			if (func.getCpf() == cpf) {
				FolhaDePagamento.remove(func);
				return true;
			}
		}
		return false;
	}

	public Funcionario obterFuncionario(long cpf) {
		for (Funcionario func : FolhaDePagamento) {
			if (func.getCpf() == cpf) {
				return func;
			}
		}
		return null;
	}

	public List<Funcionario> getFuncionarios() {
		List<String> cadastrados = new ArrayList<>();
		List<Funcionario> ListaFuncionario = new ArrayList<>();

		for (Funcionario funcionario : FolhaDePagamento) {
			cadastrados.add(funcionario.getNome());
		}

		Collections.sort(cadastrados);

		for (int i = 0; i < cadastrados.size(); i++) {
			for (Funcionario funcionario : FolhaDePagamento) {
				if (funcionario.getNome().equals(cadastrados.get(i))) {
					ListaFuncionario.add(funcionario);
				}
			}
		}

		return ListaFuncionario;
	}

	@Override
	public List<Funcionario> getFuncionariosPorCategoria(Tipo tipo) {
		List<String> tipofunc = new ArrayList<>();
		List<Funcionario> categoria = new ArrayList<>();
		for (Funcionario func : FolhaDePagamento) {
			if (func.getTipo().equals(tipo)) {
				tipofunc.add(func.getNome());
			}
		}
		if (tipofunc.isEmpty())
			return null;

		else
			Collections.sort(tipofunc);

		for (int i = 0; i < tipofunc.size(); i++) {
			for (Funcionario func : FolhaDePagamento) {
				if (func.getNome().equals(tipofunc.get(i))) {
					categoria.add(func);
				}
			}
		}
		return categoria;
	}

	public int getTotalFuncionarios() {

		if (FolhaDePagamento.isEmpty())
			return 0;

		else
			return FolhaDePagamento.size();

	}

	public Double calcularSalario(long cpf) {
		double salario;
		for (Funcionario func : FolhaDePagamento) {
			if (func.getCpf() == cpf) {
				if (func instanceof Terceirizado) {
					if (((Terceirizado) func).isInsalubridade()) {
						salario = 1200 + 300; 
						return salario;
					}
					else {
						salario = 1200;
						return salario;
					}
				}
				else if(func instanceof STA){
					salario = 1000;
					return salario;
				}
				
				else if (func instanceof Professor) {
					salario = 2000;
					return salario;
				}
			}
			else {
				return null;
			}
			return null;
			}
		return null;
		}
	
	public double calcularFolhaDePagamento() {
		double totalfinal = 0;
		for (Funcionario funcionario : FolhaDePagamento) {
			totalfinal += calcularSalario(funcionario.getCpf());
		}
		return totalfinal;
	}
}