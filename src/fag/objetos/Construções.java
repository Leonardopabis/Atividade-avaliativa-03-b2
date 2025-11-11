package fag.objetos;
import java.util.Scanner;
import java.util.ArrayList;

public class Construções {
	static Scanner scan = new Scanner(System.in);
	
	private String nomeObra;
	private String endereco;
	private String data;
	private ArrayList<String> listaDeFuncionarios = new ArrayList<>();
	public Construções() {
		
	}
	public Construções(String nomeObra, String endereco, String data) {
		setNomeObra(nomeObra);
		setEndereco(endereco);
		setData(data);
	}
	public String getNomeObra() {
		return nomeObra;
	}
	public void setNomeObra(String nomeObra) {
		if (!nomeObra.isBlank() && nomeObra != null) {
			this.nomeObra = nomeObra;
		}else {
			System.out.println("Digite um nome válido:");
			String a = scan.nextLine();
			setNomeObra(a);
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if (!endereco.isBlank() && endereco != null) {
			this.endereco = endereco;
		}else {
			System.out.println("Digite um nome válido:");
			String a = scan.nextLine();
			setEndereco(a);
		}
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
			this.data = data;
		}else {
			System.out.println("Insira uma data válida: (dd/mm/aaaa");
			String a = scan.nextLine();
			setData(a);
		}
	}
	@Override
	public String toString() {
		return "Nome da obra: "+nomeObra+" | Endereço: "+endereco+" | Data: "+data+" | Funcionários: "+listarFuncionarios()+"\n";
	}
	public String Listar() {
		return "Nome da obra: "+nomeObra+" | Endereço: "+endereco+" | Data: "+data+" | Funcionários: "+listarFuncionarios()+"\n";
	}
	public ArrayList<String> listarFuncionarios() {
		return this.listaDeFuncionarios;
	}
	public void adicionarFuncionario(Funcionários funcionario) {
		this.listaDeFuncionarios.add(funcionario.getNome());
	}
	public void removerFuncionario(Funcionários funcionario) {
		this.listaDeFuncionarios.remove(funcionario.getNome());
	}
	
}
