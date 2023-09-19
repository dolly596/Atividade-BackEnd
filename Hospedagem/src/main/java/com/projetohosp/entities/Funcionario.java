package com.projetohosp.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "funcionario")
public class Funcionario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	 
	@Column(name = "nome")
	private String name;
	
	@Column(name = "salario")
	private double salario;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "telefone")
	private String telefone;
	
	
	public Long getId() {
		return codigo;
	}
	public void setId(Long codigo) {
		this.codigo = codigo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.name = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.name = telefone;
	}
}