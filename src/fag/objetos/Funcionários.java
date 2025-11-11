package fag.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionários {
	static Scanner scan = new Scanner(System.in);
	private String nome;
	private String cargo;
	private ArrayList<String> listaDeConstrucoes = new ArrayList<>();
	private double salario;
	
	public Funcionários() {
		
	}
	public Funcionários(String nome, String cargo, double salario) {
		setNome(nome);
		setCargo(cargo);
		setSalario(salario);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (!nome.isBlank() && nome != null) {
			this.nome = nome;
		}else {
			System.out.println("Digite um nome válido:");
			String a = scan.nextLine();
			setNome(a);
		}
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		if (!cargo.isBlank() && cargo != null) {
			this.cargo = cargo;
		}else {
			System.out.println("Digite um cargo válido:");
			String a = scan.nextLine();
			setNome(a);
		}
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		if (salario > 0) {
			this.salario = salario;
		}else {
			System.out.println("Digite um salário válido:");
			Double a = scan.nextDouble();
			scan.nextLine();
			setSalario(a);
		}
	}
	@Override
	public String toString() {
		return "Nome: "+nome+" | Cargo: "+cargo+" | Salário: "+salario+" | Construções: "+listarConstrucoes()+"\n";
	}
	public String Listar() {
		return "Nome: "+nome+" | Cargo: "+cargo+" | Salário: "+salario+" | Construções: "+listarConstrucoes()+"\n";
	}
	public ArrayList<String> listarConstrucoes() {
		return this.listaDeConstrucoes;
	}
	public void adicionarConstrucoes(Construções construcao) {
		this.listaDeConstrucoes.add(construcao.getNomeObra());
	}
	public void removerConstrucao(Construções construcao) {
		this.listaDeConstrucoes.remove(construcao.getNomeObra());
	}

}
