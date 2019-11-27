package companhia.dao;

import java.util.List;

import javax.persistence.Entity;

import companhia.models.Departamento;

public interface DepartamentoDAO extends GenericDAO<Departamento>{
	public List<Departamento>findAll();
	public void save(Entity entity);
	public void deleteById(Object id);
	public Departamento find(Integer id);

}
