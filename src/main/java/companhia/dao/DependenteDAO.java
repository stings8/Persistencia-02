package companhia.dao;

import java.util.List;
import javax.persistence.Entity;
import companhia.models.Dependente;

public interface DependenteDAO extends GenericDAO<Dependente> {
	public List<Dependente>findAll();
	public void save(Entity entity);
	public void deleteById(Object id);
	public Dependente find(Integer id);
}
