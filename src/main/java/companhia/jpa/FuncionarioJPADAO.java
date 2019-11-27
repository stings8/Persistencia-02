package companhia.jpa;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import companhia.dao.FuncionarioDAO;
import companhia.models.Funcionario;

public class FuncionarioJPADAO extends GenericJPADAO<Funcionario> implements FuncionarioDAO{

	public FuncionarioJPADAO() {
		super(Funcionario.class);
		
	}
	
	public List<Funcionario> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Funcionario>funcionarios = em.createNamedQuery("Funcionario.findAll", Funcionario.class).getResultList();
		return funcionarios;
	}
	
	public Funcionario find(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Funcionario>funcionarios = em.createNamedQuery("Funcionario.findAll", Funcionario.class).getResultList();
		for(Funcionario f: funcionarios) {
			if(id == f.getId()) return f;
		}
		return null;
	}


	public void save(Entity entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
			System.out.println("Funcionario inserido!");
			tx.commit();
		}catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}
	
	public void deleteById(Object id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			
			Funcionario d = em.find(Funcionario.class, id);
			tx.begin();
			em.remove(d);
			tx.commit();
			
		} catch (PersistenceException e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close(); 
		}
	}
	

}
