package companhia.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import companhia.dao.SecretarioDAO;
import companhia.models.Secretario;

public class SecretarioJPADAO extends GenericJPADAO<Secretario> implements SecretarioDAO {

	public SecretarioJPADAO() {
		super(Secretario.class);
	}
	
	public List<Secretario> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Secretario>secretarios = em.createNamedQuery("Secretario.findAll", Secretario.class).getResultList();
		return secretarios;
	}


	public void save(Entity entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
			System.out.println("Secretario inserido!");
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
			
			Secretario d = em.find(Secretario.class, id);
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
