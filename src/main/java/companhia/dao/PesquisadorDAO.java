package companhia.dao;

import java.util.List;
import javax.persistence.Entity;
import companhia.models.Pesquisador;

public interface PesquisadorDAO extends GenericDAO<Pesquisador>{
	public List<Pesquisador>findAll();
	public void save(Entity entity);
	public void deleteById(Object id);
	public Pesquisador find(Integer id);
}
