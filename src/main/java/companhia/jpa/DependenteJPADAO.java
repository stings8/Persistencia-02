package companhia.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import companhia.dao.DependenteDAO;
import companhia.models.Dependente;

public class DependenteJPADAO extends GenericJPADAO<Dependente> implements DependenteDAO{

	public DependenteJPADAO() {
		super(Dependente.class);
		
	}
	
	public List<Dependente> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Dependente>dependentes = em.createNamedQuery("Dependente.findAll", Dependente.class).getResultList();
		return dependentes;
	}


	public void save(Entity entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
			System.out.println("Dependente inserido!");
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
			
			Dependente d = em.find(Dependente.class, id);
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

	public Dependente find(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Dependente>dependentes = em.createNamedQuery("Dependente.findAll", Dependente.class).getResultList();
		for(Dependente d: dependentes ) {
			if(id == d.getId()) return d;
		}
		return null;
	}
	

}
