package companhia.views;

import java.util.List;
import java.util.Scanner;
import companhia.dao.DepartamentoDAO;
import companhia.jpa.DepartamentoJPADAO;
import companhia.models.Departamento;

public class DepartamentoMenu {
	DepartamentoDAO dao = new DepartamentoJPADAO();
	
	public void menu() {
		boolean show = true;
		while(show) {
			System.out.println("1 - Adicionar Departamento");
			System.out.println("2 - Listar Departamentos");
			System.out.println("3 - Atualizar um Departamento");
			System.out.println("4 - Excluir Departamento");
			System.out.println("5 - Voltar Menu Principal");
			int op = Integer.parseInt(getCommand());
			switch (op) {
			case 1:
				System.out.println("Digite o nome do Departamento: ");
				String name = getCommand();
				save(name);
				break;
			case 2:
				System.out.println("Lista de Departamentos: ");
				List<Departamento>departamentos = dao.findAll();
				for(Departamento ds: departamentos) {
					System.out.println(ds.toString());
				}
				break;
			case 3:
				System.out.println("Digite o numero do Departamento a ser atualizado: ");
				int id = Integer.parseInt(getCommand());
				System.out.println("Digite o novo nome do Departamento: ");
				String nameUpdate = getCommand();
				update(id, nameUpdate);
				break;
			case 4:
				System.out.println("Digite o numero do Departamento a ser excluído: ");
				int idE = Integer.parseInt(getCommand());
				delete(idE);
			case 5:
				MenuPrincipal menu = new MenuPrincipal();
				menu.menu();
			default:
				break;
			}
		}
	}

	private void delete(int idE) {
		dao.deleteById(idE);
	}

	private void update(int id, String nameUpdate) {
		
	}

	/*private void list() {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Departamento>departamentos = em.createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
		for(Departamento d: departamentos) {
			System.out.println(d.toString());
		}
		dao.findAll();
		
	}*/

	private void save(String name) {
		Departamento d = new Departamento(name);
		DepartamentoDAO dao = new DepartamentoJPADAO();
		try {
			dao.beginTransaction();
			dao.save(d);
			dao.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			dao.close();
		}
		
		
		
	}

	@SuppressWarnings("resource")
	private String getCommand() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
