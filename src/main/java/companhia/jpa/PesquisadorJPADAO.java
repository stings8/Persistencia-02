package companhia.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import companhia.dao.PesquisadorDAO;
import companhia.models.Pesquisador;

public class PesquisadorJPADAO extends GenericJPADAO<Pesquisador> implements PesquisadorDAO{

	public PesquisadorJPADAO() {
		super(Pesquisador.class);
	}
	
	public List<Pesquisador> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Pesquisador>pesquisadores = em.createNamedQuery("Pesquisador.findAll", Pesquisador.class).getResultList();
		return pesquisadores;
	}
	
	public Pesquisador find(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Pesquisador>pesquisadores = em.createNamedQuery("Pesquisador.findAll", Pesquisador.class).getResultList();
		for(Pesquisador p: pesquisadores) {
			if(id == p.getId()) return p;
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
			System.out.println("Pesquisador inserido!");
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
			
			Pesquisador d = em.find(Pesquisador.class, id);
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
