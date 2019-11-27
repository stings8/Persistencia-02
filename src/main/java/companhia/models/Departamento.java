package companhia.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name = "Departamento.findAll", query="from Departamento")})
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Projeto>projetos;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Funcionario>funcionarios;
		
	
	public Departamento() {
		super();
	}
	public Departamento(String nome) {
		super();
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", projetos=" + projetos + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	

}
