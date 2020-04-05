package br.com.relatorios.model;

import java.util.ArrayList;
import java.util.List;

public class Contato {

	private int id;
	private String nome;
	private String telefone;
	private String email;
	
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Contato() {
	
	}
	public Contato(int id, String nome, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public static ArrayList<Contato> selecionarTodos(){
		//Pode vir de banco de dados
		ArrayList<Contato> retorno = new ArrayList<Contato>();
		
		retorno.add(new Contato(1,"Raulivan","3788888888"));
		retorno.add(new Contato(2,"Laryssa","3799999999"));
		retorno.add(new Contato(3,"Bela","3799999999"));
		retorno.add(new Contato(4,"Raulivan 2","3788888888"));
		retorno.add(new Contato(5,"Laryssa 2","3799999999"));
		retorno.add(new Contato(6,"Bela 2","3799999999"));
		return retorno;
	}
}
