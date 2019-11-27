package companhia.jpa;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import companhia.dao.ProjetoDAO;
import companhia.models.Projeto;

public class ProjetoJPADAO extends GenericJPADAO<Projeto> implements ProjetoDAO{

	public ProjetoJPADAO() {
		super(Projeto.class);
	}
	
	public List<Projeto> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Projeto>projetos = em.createNamedQuery("Projeto.findAll", Projeto.class).getResultList();
		return projetos;
	}


	public void save(Entity entity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(entity);
			System.out.println("Projeto inserido!");
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
			
			Projeto d = em.find(Projeto.class, id);
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

	public Projeto find(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Projeto>projetos = em.createNamedQuery("Projeto.findAll", Projeto.class).getResultList();
		for(Projeto p: projetos) {
			if(id == p.getId()) return p;
		}
		return null;
	}

}
