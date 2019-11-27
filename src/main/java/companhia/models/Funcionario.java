package companhia.models;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({@NamedQuery(name = "Funcionario.findAll", query="from Funcionario")})
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String endereco;
	private String sexo;
	private String nascimento;
	private float salario;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
	private List<Dependente>dependentes;
	
	public Funcionario() {
		super();
	}
	
	
	
	public Funcionario(String nome, String endereco, String sexo, String nascimento, float salario,
			Departamento departamento, List<Dependente> dependentes) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.salario = salario;
		this.departamento = departamento;
		this.dependentes = dependentes;
	}

	public Funcionario(String nome, String endereco, String sexo, String nascimento, float salario) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.salario = salario;

	}


	public Funcionario(String nome, String endereco, String sexo, String nascimento, float salario,
			Departamento departamento) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.salario = salario;
		this.departamento = departamento;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", sexo=" + sexo
				+ ", nascimento=" + nascimento + ", salario=" + salario + "]";
	}
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
	
	
}
