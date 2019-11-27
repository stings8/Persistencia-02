package companhia.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import companhia.dao.DepartamentoDAO;
import companhia.dao.PesquisadorDAO;
import companhia.dao.ProjetoDAO;
import companhia.jpa.DepartamentoJPADAO;
import companhia.jpa.PesquisadorJPADAO;
import companhia.jpa.ProjetoJPADAO;
import companhia.models.Departamento;
import companhia.models.Pesquisador;
import companhia.models.Projeto;

public class ProjetoMenu {
	ProjetoDAO dao = new ProjetoJPADAO();
	
	public void menu() {
		boolean show = true;
		while(show) {
			System.out.println("1 - Adicionar Projeto");
			System.out.println("2 - Listar Projetos");
			System.out.println("3 - Atualizar um Departamento");
			System.out.println("4 - Excluir Projeto");
			System.out.println("5 - Voltar Menu Principal");
			int op = Integer.parseInt(getCommand());
			switch (op) {
			case 1:
				System.out.println("Digite o nome do Projeto: ");
				String namep = getCommand();
				System.out.println("Digite o numero do departamento: ");
				int depId = Integer.parseInt(getCommand());
				System.out.println("Digite o numero do pesquisador: ");
				int pesId = Integer.parseInt(getCommand());
				System.out.println("Digite a duracao do projeto em meses: ");
				int periodo = Integer.parseInt(getCommand());
				save(namep, depId, pesId, periodo);
				break;
			case 2:
				System.out.println("Lista de Departamentos: ");
				List<Projeto>projetos = dao.findAll();
				for(Projeto ps: projetos) {
					System.out.println(ps.toString());
				}
				break;
			case 3:
				System.out.println("Digite o numero do pesquisador a ser adicionado: ");
				int pId = Integer.parseInt(getCommand());
				System.out.println("Digite o numero do projeto: ");
				int projId = Integer.parseInt(getCommand());
				addPesquisador(pId, projId);
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

	private void addPesquisador(int pId, int projId) {
		PesquisadorDAO daop = new PesquisadorJPADAO();
		Pesquisador psq = daop.find(pId);
		Projeto p = dao.find(projId);
		p.getPesquisadores().add(psq);
		
		
	}

	private void delete(int idE) {
		dao.deleteById(idE);
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

	private void save(String name, int depId, int pesId, int periodo) {
		
		List<Pesquisador>pesl = new ArrayList<Pesquisador>();
		PesquisadorDAO daop = new PesquisadorJPADAO();
		Pesquisador psq = daop.find(pesId);
		pesl.add(psq);
		DepartamentoDAO daod = new DepartamentoJPADAO();
		Departamento dpt = daod.find(depId);
		Projeto p = new Projeto(name, periodo, dpt, pesl);

		try {
			dao.beginTransaction();
			dao.save(p);
			dao.commit();
		}catch (Exception e) {
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
