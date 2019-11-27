package companhia.dao;

import java.util.List;
import javax.persistence.Entity;
import companhia.models.Projeto;

public interface ProjetoDAO extends GenericDAO<Projeto> {
	public List<Projeto>findAll();
	public void save(Entity entity);
	public void deleteById(Object id);
	public Projeto find(Integer id);
}
