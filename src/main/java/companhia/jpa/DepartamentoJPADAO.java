package companhia.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import companhia.dao.DepartamentoDAO;
import companhia.models.Departamento;

public class DepartamentoJPADAO extends GenericJPADAO<Departamento> implements DepartamentoDAO{
	
	
	
	public DepartamentoJPADAO() {
		super(Departamento.class);
	}


	public List<Departamento> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Departamento>departamentos = em.createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
		return departamentos;
	}
	
	public Departamento find(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		List<Departamento>departamentos = em.createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
		for(Departamento d: departamentos) {
			if(id == d.getId()) return d;
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
			System.out.println("Departamento inserido!");
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
			
			Departamento d = em.find(Departamento.class, id);
			tx.begin();
			em.remove(d);
			tx.commit();
			
		} catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close(); 
		}
	}

}
