package companhia.views;

import java.util.Scanner;

public class MenuPrincipal {
	
	public void menu() {
		boolean show = true;
		while(show) {
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Departamento");
			System.out.println("2 - Projeto");
			System.out.println("3 - Funcionario");
			System.out.println("4 - Dependente");
			System.out.println("5 - Sair");
			int op = Integer.parseInt(getCommand());
			switch (op) {
			case 1:
				DepartamentoMenu departamentoMenu = new DepartamentoMenu();
				departamentoMenu.menu();
				break;
			case 2:
				ProjetoMenu projetoMenu = new ProjetoMenu();
				projetoMenu.menu();
				break;
			case 3:
				FuncionarioMenu funcionarioMenu = new FuncionarioMenu();
				funcionarioMenu.menu();
				break;
			case 4:
				DependenteMenu dependenteMenu = new DependenteMenu();
				dependenteMenu.menu();
				break;
			case 5:
				show = false;
			default:
				break;
			}			
			
		}
	}

	
	@SuppressWarnings("resource")
	private String getCommand() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
