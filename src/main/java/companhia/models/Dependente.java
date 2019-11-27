package companhia.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = "Dependente.findAll", query="from Dependente")})
public class Dependente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String sexo;
	private int grau;
	private String nascimento;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	public Dependente() {
		super();
	}
		
	public Dependente(String nome, String sexo, int grau, String nascimento, Funcionario funcionario) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.grau = grau;
		this.nascimento = nascimento;
		this.funcionario = funcionario;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getGrau() {
		return grau;
	}
	public void setGrau(int grau) {
		this.grau = grau;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Dependente(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Dependente [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", grau=" + grau + ", nascimento="
				+ nascimento + ", funcionario=" + funcionario + "]";
	}
	
	
}
