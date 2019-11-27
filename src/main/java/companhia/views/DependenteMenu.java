package companhia.views;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import companhia.dao.DependenteDAO;
import companhia.dao.FuncionarioDAO;
import companhia.jpa.DependenteJPADAO;
import companhia.jpa.FuncionarioJPADAO;
import companhia.models.Dependente;
import companhia.models.Funcionario;

public class DependenteMenu {
	
DependenteDAO dao = new DependenteJPADAO();
	
	public void menu() {
		boolean show = true;
		while(show) {
			System.out.println("1 - Adicionar Dependente");
			System.out.println("2 - Remover Dependente");
			System.out.println("3 - Listar Dependentes");
			System.out.println("4 -Voltar menu principal");

			int op = Integer.parseInt(getCommand());
			switch (op) {
			case 1:				
				System.out.println("Digite o nome");
				String name = getCommand();
				System.out.println("Digite o sexo");
				String sexo = getCommand();
				System.out.println("Digite o grau de parentesco");
				int parentesco = Integer.parseInt(getCommand());
				System.out.println("Digite a data de nascimento");
				String data = getCommand();
				System.out.println("Digite o numero do funcionario");
				int id = Integer.parseInt(getCommand());
				FuncionarioDAO daof = new FuncionarioJPADAO();
				Funcionario f = daof.find(id);
				Dependente d = new Dependente(name, sexo, parentesco, data, f);
				savef(d);
				break;
			case 2:
				System.out.println("Digite o id do pesquisador: ");
				int delpId = Integer.parseInt(getCommand());
				dao.deleteById(dao.find(delpId).getId());
				break;
			case 3:
			 	List<Dependente> dependentes = dao.findAll();
			 	for(Dependente dl: dependentes) {
			 		System.out.println(dl.toString());
			 	}
			 	break;
			 	
			case 4:
				MenuPrincipal menu = new MenuPrincipal();
				menu.menu();
			 	
			default:
				break;
			}
			}
		}

	private void savef(Dependente d) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(d);
			System.out.println("Inserido com sucesso!");
			tx.commit();
		}catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@SuppressWarnings("resource")
	private String getCommand() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
