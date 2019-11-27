package companhia.dao;

import java.util.List;
import javax.persistence.Entity;
import companhia.models.Funcionario;

public interface FuncionarioDAO extends GenericDAO<Funcionario>{
	public List<Funcionario>findAll();
	public void save(Entity entity);
	public void deleteById(Object id);
	public Funcionario find(Integer id);

}
