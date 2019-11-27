package companhia.models;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_funcionario")
@NamedQueries({@NamedQuery(name = "Pesquisador.findAll", query="from Pesquisador")})
public class Pesquisador extends Funcionario {
	
	private String area;

	@ManyToMany(mappedBy = "pesquisadores")
	private List<Projeto>projetos;
		
	public Pesquisador() {
		super();
	}
	
	public Pesquisador(String nome, String endereco, String sexo, String nascimento, float salario,
			Departamento departamento, String area, List<Projeto> projetos) {
		super(nome, endereco, sexo, nascimento, salario, departamento);
		this.area = area;
		this.projetos = projetos;
		
	}
	
	public Pesquisador(String nome, String endereco, String sexo, String nascimento, float salario,
			Departamento departamento, String area) {
		super(nome, endereco, sexo, nascimento, salario, departamento);
		this.area = area;
		
		
	}
	

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Pesquisador [area=" + area + "]";
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	

}
