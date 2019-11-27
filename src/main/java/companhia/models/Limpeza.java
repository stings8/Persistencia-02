package companhia.models;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_funcionario")
@NamedQueries({@NamedQuery(name = "Limpeza.findAll", query="from Limpeza")})
public class Limpeza extends Funcionario {
	
	private String cargo;
	private int jornada;
	
	public Limpeza() {
		
	}
	
	
	public Limpeza(String nome, String endereco, String sexo, String nascimento, float salario,
			Departamento departamento, List<Dependente> dependentes, String cargo, int jornada) {
		super(nome, endereco, sexo, nascimento, salario, departamento, dependentes);
		this.cargo = cargo;
		this.jornada = jornada;
	}

	public Limpeza(String nome, String endereco, String sexo, String nascimento, float salario,
			Departamento departamento, String cargo, int jornada) {
		super(nome, endereco, sexo, nascimento, salario, departamento);
		this.cargo = cargo;
		this.jornada = jornada;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}
	@Override
	public String toString() {
		return "Limpeza [cargo=" + cargo + ", jornada=" + jornada + "]";
	}
	
	

}
