package br.edu.ifms.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paciente {
	private int codigo;
	private  String nome;
	private String sexo;
	private String patologias;
	public Paciente() {
	}
	
	public Paciente(int codigo,String nome,String sexo,String patologias) {
		super();
		this.codigo=codigo;
		this.nome=nome;
		this.sexo=sexo;
		this.patologias=patologias;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getPatologias() {
		return patologias;
	}

	public void setPatologias(String patologias) {
		this.patologias = patologias;
	}
	
	

}
