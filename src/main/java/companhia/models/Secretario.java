package companhia.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_funcionario")
@NamedQueries({@NamedQuery(name = "Secretario.findAll", query="from Secretario")})
public class Secretario extends Funcionario{
	
	private String escolaridade;
	
	public Secretario() {
		super();
	}

	
	public Secretario(String nome, String endereco, String sexo, String nascimento, float salario,
			Departamento departamento, String escolaridade) {
		super(nome, endereco, sexo, nascimento, salario, departamento);
		this.escolaridade = escolaridade;
	}
	
	


	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

}
