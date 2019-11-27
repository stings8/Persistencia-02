package companhia.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = "Projeto.findAll", query="from Projeto")})
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int periodo;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	@ManyToMany
	@JoinTable(name = "projeto_pesquisador",
	joinColumns = @JoinColumn(name= "projeto_id"),
	inverseJoinColumns = @JoinColumn(name= "pesquisador_id"))
	private List<Pesquisador>pesquisadores;
	
	public Projeto() {
		super();
	}
	
	
	public Projeto(String nome, int periodo, Departamento departamento, List<Pesquisador> pesquisadores) {
		super();
		
		this.nome = nome;
		this.periodo = periodo;
		this.departamento = departamento;
		this.pesquisadores = pesquisadores;
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
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", periodo=" + periodo + "]";
	}
	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}
	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}
	
	
	

}
