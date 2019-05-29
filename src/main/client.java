package main;

import servente.RHService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Funcionario;
import modelinterface.IRHService;
import modelinterface.IRHService.Tipo;

public class client {

	public static void main(String[] args) {

		RHService controlador = new RHService();

		Scanner ler = new Scanner(System.in);

		int escolha = 1;
		while (escolha != 0) {
			controlador.mostrarMenu();
			System.out.println("Esperando --->  ");
			escolha = ler.nextInt();
			if (escolha == 0) {
				System.out.println("ENCERRADO!");
				escolha = 0;
				break;
			}

			else if (escolha == 1) {
				System.out.println("Digite o nome: ");
				ler.nextLine();
				String nome = ler.nextLine();
				System.out.println("Digite o cpf ");
				long cpf = ler.nextInt();
				System.out.println("Digie o Tipo como na legenda ");
				int tipo = ler.nextInt();

				Funcionario novo = new Funcionario(cpf, nome);

				if (tipo == 1) {
					novo.setTipo(Tipo.PROF);
				} else if (tipo == 2) {
					novo.setTipo(Tipo.STA);
				} else if (tipo == 3) {
					novo.setTipo(Tipo.TERC);
				}

				ArrayList<Funcionario> Func = new ArrayList<>();
				Func.add(novo);
				for (Funcionario a : Func) {
					controlador.cadastrar(a);
				}

			} else if (escolha == 2) {
				System.out.println("Digite o CPF do Funcionario que deseja remover:");
				int cpf = ler.nextInt();
				controlador.remover(cpf);
			}

			else if (escolha == 3) {
				System.out.println("----------------------------------");
				System.out.println("Funcionario Cadastrados: ");
				List<Funcionario> result = new ArrayList<>();
				for (Funcionario func : controlador.getFuncionarios()) {
					result.add(func);
				}
				for (Funcionario func : result) {
					System.out.println(func);
				}
				System.out.println("----------------------------------");
			}
		}

	}
}
