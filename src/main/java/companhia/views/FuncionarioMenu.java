package companhia.views;


import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import companhia.dao.DepartamentoDAO;
import companhia.dao.FuncionarioDAO;
import companhia.dao.LimpezaDAO;
import companhia.dao.PesquisadorDAO;
import companhia.dao.SecretarioDAO;
import companhia.jpa.DepartamentoJPADAO;
import companhia.jpa.FuncionarioJPADAO;
import companhia.jpa.LimpezaJPADAO;
import companhia.jpa.PesquisadorJPADAO;
import companhia.jpa.SecretarioJPADAO;
import companhia.models.Departamento;
import companhia.models.Funcionario;
import companhia.models.Limpeza;
import companhia.models.Pesquisador;
import companhia.models.Secretario;

public class FuncionarioMenu {
	DepartamentoDAO daoDep = new DepartamentoJPADAO();
	
	public void menu() {
		boolean show = true;
		while(show) {
			System.out.println("1 - Adicionar Funcionario");
			System.out.println("2 - Remover Funcionario");
			System.out.println("3 - Adicionar Funcionario da Limpeza");
			System.out.println("4 - Remover Funcionario da Limpeza");
			System.out.println("5 - Adicionar Secretario");
			System.out.println("6 - Remover Secretario");
			System.out.println("7 - Adicionar Pesquisador");
			System.out.println("8 - Remover Pesquisador");
			System.out.println("9 - Listar Funcionario");
			System.out.println("10 - Listar Secretario");
			System.out.println("11 - Listar Pesquisador");
			System.out.println("12 - Listar Funcionario Limpeza");
			System.out.println("13 - Voltar Menu Principal");
			int op = Integer.parseInt(getCommand());
			switch (op) {
			case 1:				
				System.out.println("Digite o nome");
				String namef = getCommand();
				System.out.println("Digite o endereço");
				String endf = getCommand();
				System.out.println("Digite o sexo");
				String sexof = getCommand();
				System.out.println("Digite a data de nascimento");
				String dataf = getCommand();
				System.out.println("Digite o salario");
				float salariof = Float.parseFloat(getCommand());
				System.out.println("Digite o id do departmento");
				int departamentof = Integer.parseInt(getCommand());		
				Departamento depf = new Departamento();
				depf = daoDep.find(departamentof);
				if(depf.getClass() == null) {
					System.out.println("departamento não existe!");
					break;
				}				
				Funcionario f = new Funcionario(namef, endf, sexof, dataf, salariof, depf);
				savef(f);
				break;
				
				
			case 2:
				FuncionarioDAO delf = new FuncionarioJPADAO();
				System.out.println("Digite o id do funcionario: ");
				int delfId = Integer.parseInt(getCommand());
				delf.deleteById(delf.find(delfId).getId());
				break;
				
			case 3:
				System.out.println("Digite o nome");
				String namel = getCommand();
				System.out.println("Digite o endereço");
				String endl = getCommand();
				System.out.println("Digite o sexo");
				String sexol = getCommand();
				System.out.println("Digite a data de nascimento");
				String datal = getCommand();
				System.out.println("Digite o salario");
				float salariol = Float.parseFloat(getCommand());
				System.out.println("Digite carga horaria");
				int jornada = Integer.parseInt(getCommand());
				System.out.println("Digite o cargo");
				String cargo = getCommand();
				System.out.println("Digite o id do departmento");
				int departamentol = Integer.parseInt(getCommand());		
				Departamento depl = new Departamento();
				depl = daoDep.find(departamentol);
				if(depl.getClass() == null) {
					System.out.println("departamento não existe!");
					break;
				}				
				Limpeza l = new Limpeza(namel, endl, sexol, datal, salariol, depl, cargo, jornada);
				savel(l);
				break;
				
			case 4:
				LimpezaDAO dell = new LimpezaJPADAO();
				System.out.println("Digite o id do funcionario da limpeza: ");
				int dellId = Integer.parseInt(getCommand());
				dell.deleteById(dell.find(dellId).getId());
				break;
				
			case 5:
				
				System.out.println("Digite o nome");
				String names = getCommand();
				System.out.println("Digite o endereço");
				String ends = getCommand();
				System.out.println("Digite o sexo");
				String sexos = getCommand();
				System.out.println("Digite a data de nascimento");
				String datas = getCommand();
				System.out.println("Digite o salario");
				float salarios = Float.parseFloat(getCommand());
				System.out.println("Digite a escolaridade");
				String escolaridade = getCommand();
				System.out.println("Digite o id do departmento");
				int departamentos = Integer.parseInt(getCommand());		
				Departamento deps = new Departamento();
				deps = daoDep.find(departamentos);
				if(deps.getClass() == null) {
					System.out.println("departamento não existe!");
					break;
				}				
				Secretario s = new Secretario(names, ends, sexos, datas, salarios, deps, escolaridade);
				saves(s);
				break;
				
			case 6:
				SecretarioDAO dels = new SecretarioJPADAO();
				System.out.println("Digite o id do secretario: ");
				int delsId = Integer.parseInt(getCommand());
				dels.deleteById(dels.find(delsId).getId());
				break;
				
			case 7:
				
				System.out.println("Digite o nome");
				String namep = getCommand();
				System.out.println("Digite o endereço");
				String endp = getCommand();
				System.out.println("Digite o sexo");
				String sexop = getCommand();
				System.out.println("Digite a data de nascimento");
				String datap = getCommand();
				System.out.println("Digite o salario");
				float salariop = Float.parseFloat(getCommand());
				System.out.println("Digite a area de pesquisa");
				String area = getCommand();
				System.out.println("Digite o id do departmento");
				int departamentop = Integer.parseInt(getCommand());		
				Departamento depp = new Departamento();
				depp = daoDep.find(departamentop);
				if(depp.getClass() == null) {
					System.out.println("departamento não existe!");
					break;
				}				
				Pesquisador p = new Pesquisador(namep, endp, sexop, datap, salariop, depp, area);
				savep(p);
				break;
			
			case 8:
				PesquisadorDAO delp = new PesquisadorJPADAO();
				System.out.println("Digite o id do pesquisador: ");
				int delpId = Integer.parseInt(getCommand());
				delp.deleteById(delp.find(delpId).getId());
				break;
				
			case 9:
				FuncionarioDAO listf = new FuncionarioJPADAO();
			 	List<Funcionario> funcionarios = listf.findAll();
			 	for(Funcionario fl: funcionarios) {
			 		System.out.println(fl.toString());
			 	}
			 	break;
			 	
			case 10:
				SecretarioDAO lists = new SecretarioJPADAO();
				List<Secretario>secretarios = lists.findAll();
				for(Secretario sl: secretarios) {
					System.out.println(sl.toString());
				}
				break;
			case 11:
				PesquisadorDAO listp = new PesquisadorJPADAO();
				List<Pesquisador>pesquisadores = listp.findAll();
				for(Pesquisador pl: pesquisadores) {
					System.out.println(pl.toString());
				}
				break;
			case 12:
				LimpezaDAO listl = new LimpezaJPADAO();
				List<Limpeza>flimpeza = listl.findAll();
				for(Limpeza ll: flimpeza) {
					System.out.println(ll.toString());
				}
				break;
			case 13:
				MenuPrincipal menu = new MenuPrincipal();
				menu.menu();
				
			default:
				break;
			}
		}
	}
	public void savef(Funcionario entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
			System.out.println("Inserido com sucesso!");
			tx.commit();
		}catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	
	public void savep(Pesquisador entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
			System.out.println("Inserido com sucesso!");
			tx.commit();
		}catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	
	public void savel(Limpeza entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
			System.out.println("Inserido com sucesso!");
			tx.commit();
		}catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	
	public void saves(Secretario entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
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
